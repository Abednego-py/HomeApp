package com.example.homeapp.ui

import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homeapp.databinding.ActivitySignUpBinding
import com.example.homeapp.databinding.Signup2Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.content_sign_up.view.*

class Signup2 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: Signup2Binding
    private lateinit var binding2 : ActivitySignUpBinding
    private val TAG = "Signup2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Signup2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding2 = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val paths = arrayOf("Savings", "Current")
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this@Signup2,
            R.layout.simple_spinner_item, paths
        )


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.accounttype.adapter = adapter

        binding.root.backbutton.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        // Initialize Firebase Auth
        auth = Firebase.auth
        val emailText = intent.getStringExtra("email").toString()
        val password = binding.passwordText


//        fun isValidPassword(password : String) : Boolean {
//            val pattern: Pattern
//            val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
//            pattern = Pattern.compile(passwordPattern);
//            val matcher: Matcher = pattern.matcher(password);
//
//            return matcher.matches();
//        }
        fun isValidPassword(password: String): Boolean {
            if (password.length < 8) return false
            if (password.filter { it.isDigit() }.firstOrNull() == null) return false
            if (password.filter { it.isLetter() }.filter { it.isUpperCase() }.firstOrNull() == null) return false
            if (password.filter { it.isLetter() }.filter { it.isLowerCase() }.firstOrNull() == null) return false
            if (password.filter { !it.isLetterOrDigit() }.firstOrNull() == null) return false

            return true
        }

        binding.button.setOnClickListener {
            if (isValidPassword(password.text.toString())) {
                password.error = "Password is required"
                password.hint = "The password must be at least 8 characters long and include a number, " +
                        "lowercase letter, uppercase letter and special character"
            } else {
                auth.createUserWithEmailAndPassword(emailText, password.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success")
                            val intent = Intent(this, LoginSuccessful::class.java)
                            startActivity(intent)
                            val user = auth.currentUser
//                    updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
//                    updateUI(null)
                        }
                    }
            }
        }
    }



    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
//            reload();
        }
    }
}
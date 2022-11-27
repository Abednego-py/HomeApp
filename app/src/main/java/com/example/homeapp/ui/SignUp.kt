package com.example.homeapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.homeapp.databinding.ActivitySignUpBinding
import com.example.homeapp.ui.homepage.HomeActivity
import kotlinx.android.synthetic.main.content_sign_up.view.*
import java.util.regex.Pattern


class SignUp : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val paths = arrayOf("male", "female")
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this@SignUp,
            android.R.layout.simple_spinner_item, paths
        )


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.root.gender.adapter = adapter

//        fun isValidEmail(email: String)  : Boolean{
//            val pattern = Patterns.EMAIL_ADDRESS;
//            return pattern.matcher(email).matches();
//        }
        val EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
        fun isValidString(str: String): Boolean{
            return EMAIL_ADDRESS_PATTERN.matcher(str).matches()
        }
        val email = binding.root.emailtext
        val firstName = binding.root.firstnametext
        val lastName = binding.root.lastnametext

        binding.root.next.setOnClickListener {

            if (isValidString(email.text.toString())) {
                email.error = "Email is required"
                email.hint = "Please enter a valid email"
            } else {
                val intent = Intent(this, Signup2::class.java)
                intent.putExtra("email", email.text.toString())
                startActivity(intent)
            }
        }

        binding.root.backbutton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

//        setSupportActionBar(binding.toolbar)

//        val navController = findNavController(R.id.nav_host_fragment_content_sign_up)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//

    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_sign_up)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}
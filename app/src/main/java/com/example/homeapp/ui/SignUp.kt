package com.example.homeapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.homeapp.databinding.ActivitySignUpBinding
import com.example.homeapp.databinding.ContentSignUpBinding
import com.example.homeapp.ui.homepage.HomeActivity
import kotlinx.android.synthetic.main.content_sign_up.view.*
//import kotlinx.android.synthetic.main.content_sign_up.view.*


class SignUp : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var binding2: ContentSignUpBinding

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
        fun isEntryValid(entry: String): Boolean {
            return entry.isEmpty()
        }

        val email = binding.root.emailtext
        val firstName = binding.root.firstnametext
        val lastName = binding.root.lastnametext

        binding.root.next.setOnClickListener {

            if (isEntryValid(email.text.toString())) {
                email.error = "Email is required"
                email.hint = "Please enter a valid email"
            } else {
                val intent = Intent(this, Signup2::class.java)
                intent.putExtra("email", email.text.toString())
                startActivity(intent)
//            }
            }
        }

        binding.root.backbutton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}
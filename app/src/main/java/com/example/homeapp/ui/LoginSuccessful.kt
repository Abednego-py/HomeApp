package com.example.homeapp.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.homeapp.R


class LoginSuccessful : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_successful)

        Handler().postDelayed(Runnable {
            val mainIntent = Intent(this@LoginSuccessful, WelcomeActivity::class.java)
            this@LoginSuccessful.startActivity(mainIntent)
            this@LoginSuccessful.finish()
        }, 5000)

    }

}
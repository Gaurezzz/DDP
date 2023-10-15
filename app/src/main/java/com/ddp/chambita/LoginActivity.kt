package com.ddp.chambita

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import android.widget.Button
import android.content.Intent

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_activity)
        val urlGif = "https://giphy.com/gifs/t47xtKkH44tsfy7P2G"
        val imageView = findViewById<ImageView>(R.id.eslogan)
        Glide.with(this).asGif().load("https://s6.gifyu.com/images/S6ijd.gif").into(imageView)

        val login = findViewById<Button>(R.id.loginButton)
        login.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
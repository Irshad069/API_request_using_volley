package com.example.api_request_using_volley

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Ui_practice : AppCompatActivity() {
    private lateinit var button : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_practice)
        button = findViewById(R.id.searchgooglr)
        button.setOnClickListener {
            intent = Intent(this, Google::class.java)
            startActivity(intent)
        }
    }
}
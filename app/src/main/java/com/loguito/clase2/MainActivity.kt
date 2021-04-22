package com.loguito.clase2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var loginButton: Button
    private lateinit var userNameEditText: TextInputEditText

    private val DETAIL_ACTIVITY = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        loginButton = findViewById(R.id.button)
        userNameEditText = findViewById(R.id.textInputEditText)

        loginButton.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            val user = User(userNameEditText.text.toString(), "Sandí")
            intent.putExtra("USER", user)
            startActivityForResult(intent, DETAIL_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == DETAIL_ACTIVITY && resultCode == 102) {
            data?.let {
                userNameEditText.setText(it.extras?.getString("DISMISS", "Ninguno"))
            }
        }
    }
}
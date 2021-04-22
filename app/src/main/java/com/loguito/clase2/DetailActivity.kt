package com.loguito.clase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private lateinit var userNameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        userNameTextView = findViewById(R.id.textView2)

        intent.extras?.let {
            (it.getParcelable("USER") as? User)?.let { user ->
                userNameTextView.text = user.lastName
            }
        }
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("DISMISS", "Prueba")
        setResult(102, intent)
        finish()
    }
}
package com.dglasmann.weatherapp.view.list

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dglasmann.weatherapp.R

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)}, 3000
        )

    }
}
package com.example.sudokusolver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class InitialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial)
    }

    fun clickPlay(view: View?){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}
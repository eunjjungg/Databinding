package com.practice.databinding.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.practice.databinding.R
import com.practice.databinding.data.Person
import com.practice.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mbinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val person = Person("ej", 23, 164)
        mbinding.person = person
    }
}
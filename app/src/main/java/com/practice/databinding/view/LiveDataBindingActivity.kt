package com.practice.databinding.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.practice.databinding.R
import com.practice.databinding.databinding.ActivityLiveDataBindingBinding

class LiveDataBindingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLiveDataBindingBinding
    var liveText = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data_binding)

        binding.lifecycleOwner = this@LiveDataBindingActivity
        binding.activity = this@LiveDataBindingActivity

        binding.btnChange.setOnClickListener {
            if(liveText.value == "hello")
                liveText.value = "hi"
            else
                liveText.value = "hello"
        }

    }
}
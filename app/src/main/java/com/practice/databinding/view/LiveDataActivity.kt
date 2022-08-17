package com.practice.databinding.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.practice.databinding.R
import com.practice.databinding.databinding.ActivityLiveDataBinding

class LiveDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLiveDataBinding
    var liveText: MutableLiveData<String> = MutableLiveData<String>()
    private var count = 0

    //LiveData 생성과 동시에 초기화 방법
    private var liveText2: MutableLiveData<String> = MutableLiveData<String>().set("init")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data)

        liveText.observe(this, Observer {
            binding.text.text = it
        })

        binding.btnUp.setOnClickListener {
            liveText.value = "${++count}"
        }
    }

    private fun MutableLiveData<String>.set(value: String): MutableLiveData<String> {
        this.value = value
        return this
    }
}
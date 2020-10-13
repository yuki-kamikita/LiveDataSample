package com.akaiyukiusagi.livedatasample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // LiveDataを初期化（？）
        val sampleLiveData: MutableLiveData<Int> by lazy {
            MutableLiveData<Int>()
        }
        sampleLiveData.value = 0 // 初期値

        // Observerを定義
        // sampleLiveData の値が変化したら text_view.text を変更
        sampleLiveData.observe(this, Observer { value ->
            value?.let { text_view.text = it.toString() }
        })

        // 背景タップで値+1
        constraint.setOnClickListener {
            sampleLiveData.value = sampleLiveData.value!! + 1
        }

    }
}
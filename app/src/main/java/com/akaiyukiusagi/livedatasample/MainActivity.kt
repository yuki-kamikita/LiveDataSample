package com.akaiyukiusagi.livedatasample

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // LiveDataを初期化
        val sampleLiveData: MutableLiveData<LocalDateTime> by lazy {
            MutableLiveData<LocalDateTime>()
        }

        // Observerを定義
        // sampleLiveData の値が変化したら text_view.text を変更
        sampleLiveData.observe(this, Observer { value ->
            value?.let { text_view.text = it.toString() }
        })

        // 背景タップでLiveDataの値を変更
        constraint.setOnClickListener {
            sampleLiveData.value = LocalDateTime.now()
        }

        // おまけ
        // 1秒（1000ms）delay（待機）して実行
//        val handler = Handler()
//        val r: Runnable? = object : Runnable {
//            override fun run() {
//                sampleLiveData.value = LocalDateTime.now() // LiveDataに保存
//                handler.postDelayed(this, 1000) // 1000ms待つ
//            }
//        }
//        handler.post(r)
    }
}
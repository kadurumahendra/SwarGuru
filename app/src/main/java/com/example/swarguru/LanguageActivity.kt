package com.example.swarguru

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.swarguru.databinding.ActivityLanguageBinding

class LanguageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLanguageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLanguageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpListeners()
    }

    private fun setUpListeners() {

        binding.box1.setOnClickListener {
            binding.box1.setBackgroundResource(R.drawable.curved_bg_21dp)
            binding.box2.setBackgroundResource(R.drawable.curved_stroke_5_20dp_bg)
        }

        binding.box2.setOnClickListener {
            binding.box2.setBackgroundResource(R.drawable.curved_bg_21dp)
            binding.box1.setBackgroundResource(R.drawable.curved_stroke_5_20dp_bg)
        }

        binding.continueBtn.setOnClickListener {
            val intent = Intent(this,AgeActivity::class.java)
            startActivity(intent)
        }
    }
}
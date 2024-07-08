package com.example.swarguru

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.swarguru.databinding.ActivityAnimationBinding
import com.example.swarguru.databinding.ActivityLetterWordsBinding

class AnimationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.animationProfile.setOnClickListener {
            val intent = Intent(this, AnimationActivity::class.java)
            startActivity(intent)
        }

            binding.backButton.setOnClickListener {
                val intent = Intent(this, LetterWordsActivity::class.java)
                startActivity(intent)
            }

    }
}
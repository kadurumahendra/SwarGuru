package com.example.swarguru

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.swarguru.databinding.ActivityLetterWordsBinding
import com.example.swarguru.databinding.ActivityLettersBinding

class LetterWordsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLetterWordsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityLetterWordsBinding.inflate(layoutInflater)
    setContentView(binding.root)
    setUpListeners()
}

        private fun setUpListeners() {
            binding.letterWordsProfile.setOnClickListener {
                val intent = Intent(this, AnimationActivity::class.java)
                startActivity(intent)
            }
            binding.backButton.setOnClickListener {
                val intent = Intent(this, LettersActivity::class.java)
                startActivity(intent)
            }

        }
}
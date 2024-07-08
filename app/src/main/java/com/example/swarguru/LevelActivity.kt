package com.example.swarguru

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.swarguru.databinding.ActivityLanguageBinding
import com.example.swarguru.databinding.ActivityLevelBinding

class LevelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLevelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLevelBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpListeners()
    }

    private fun setUpListeners() {

        binding.beginnerbox.setOnClickListener {
            val intent = Intent(this, LetterWordsActivity::class.java)
            startActivity(intent)
        }
        binding.intermediatebox.setOnClickListener {
            val intent = Intent(this, LetterWordsActivity::class.java)
            startActivity(intent)
        }
        binding.advancedbox.setOnClickListener {
            val intent = Intent(this, LetterWordsActivity::class.java)
            startActivity(intent)
        }
    }
}

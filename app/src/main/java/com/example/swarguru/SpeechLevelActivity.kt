package com.example.swarguru

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton // Add this import
import androidx.core.view.WindowInsetsCompat
import com.example.swarguru.databinding.ActivityAgeBinding
import com.example.swarguru.databinding.ActivitySpeechLevelBinding

class SpeechLevelActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpeechLevelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpeechLevelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val radioGroup: RadioGroup = findViewById(R.id.speechLevelRG)
        val radioButton1: RadioButton = findViewById(R.id.radioButton1)
        val radioButton2: RadioButton = findViewById(R.id.radioButton2)
        val radioButton3: RadioButton = findViewById(R.id.radioButton3)
        val radioButton4: RadioButton = findViewById(R.id.radioButton4)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val selectedRadioButton: RadioButton = findViewById(checkedId)
            val selectedText = selectedRadioButton.text.toString()
        }
        binding.continueBtn.setOnClickListener {
            val intent = Intent(this, WordsActivity::class.java)
            startActivity(intent)

        }

    }
}

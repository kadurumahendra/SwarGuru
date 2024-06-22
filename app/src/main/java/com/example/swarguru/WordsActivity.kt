package com.example.swarguru

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.swarguru.databinding.ActivityAgeBinding
import com.example.swarguru.databinding.ActivityWordsBinding

class WordsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWordsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWordsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.continueBtn.setOnClickListener {
            val intent = Intent(this, TherapistActivity::class.java)
            startActivity(intent)
        }

        val allAges = resources.getStringArray(R.array.words_array)
        val routesAdapter = ArrayAdapter(this, R.layout.dropdown_item, allAges)
        binding.selectWordsTV.setAdapter(routesAdapter)
    }

}
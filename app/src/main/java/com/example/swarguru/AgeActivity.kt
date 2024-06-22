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

class AgeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAgeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.continueBtn.setOnClickListener {
            val intent = Intent(this, SpeechLevelActivity::class.java)
            startActivity(intent)
        }

        val allAges = resources.getStringArray(R.array.age_array)
        val routesAdapter = ArrayAdapter(this, R.layout.dropdown_item, allAges)
        binding.selectAgeTV.setAdapter(routesAdapter)
    }

}
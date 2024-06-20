package com.example.swarguru

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.swarguru.databinding.ActivitySignupBinding
import com.example.swarguru.databinding.ActivityTherapistBinding
import com.example.swarguru.databinding.FragmentHomeBinding

class TherapistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTherapistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTherapistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()
    }

    private fun setUpListeners() {

        binding.yesBox1.setOnClickListener {
            binding.yesBox1.setBackgroundResource(R.drawable.curved_green_bg_20dp)
            binding.noBox2.setBackgroundResource(R.drawable.curved_stroke_lightblue_5_20dp)
        }

        binding.noBox2.setOnClickListener {
            binding.noBox2.setBackgroundResource(R.drawable.curved_red_bg_20dp)
            binding.yesBox1.setBackgroundResource(R.drawable.curved_stroke_lightblue_5_20dp)
        }

        binding.ProceedBtn.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
    }
}
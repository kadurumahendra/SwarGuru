package com.example.swarguru

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.swarguru.databinding.ActivityProfileChangepasswordBinding

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileChangepasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileChangepasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
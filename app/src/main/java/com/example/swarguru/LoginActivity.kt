package com.example.swarguru

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.swarguru.Constants.CHOOSE_TYPE
import com.example.swarguru.databinding.ActivityLanguageBinding
import com.example.swarguru.databinding.ActivityLoginBinding
import com.example.swarguru.databinding.ActivitySignupBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var chooseType:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)  // Correct binding class
        val view = binding.root
        setContentView(view)

        if (intent.hasExtra(CHOOSE_TYPE)) {
            chooseType = intent.getStringExtra(CHOOSE_TYPE).toString()
        }
        setUpView()
        setUpListeners()
    }

    private fun setUpView() {
        if (chooseType.equals("USER")) {
            binding.textView.text = "welcome Parent \nLogin"
        } else if (chooseType.equals("ADMIN")) {
            binding.textView.text = "welcome Admin \nLogin"
        }
    }

    private fun setUpListeners() {
        binding.loginBtn.setOnClickListener {
            val intent = Intent(this, LanguageActivity::class.java)
            startActivity(intent)
        }

        binding.signUpTV.setOnClickListener {
            val signUpIntent = Intent(this, SignupActivity::class.java)
            startActivity(signUpIntent)
        }
    }
}

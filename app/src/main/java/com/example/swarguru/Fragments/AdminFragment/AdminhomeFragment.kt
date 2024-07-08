package com.example.swarguru.Fragments.AdminFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.swarguru.AdminQuizActivity
import com.example.swarguru.AdminVocalbularyActivity
import com.example.swarguru.AnimationActivity
import com.example.swarguru.LevelActivity
import com.example.swarguru.QuizActivity
import com.example.swarguru.R
import com.example.swarguru.databinding.FragmentAdminhomeBinding
import com.example.swarguru.databinding.FragmentHomeBinding

class AdminhomeFragment : Fragment() {

    private lateinit var binding: FragmentAdminhomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdminhomeBinding.inflate(layoutInflater)

        setUpListeners()

        return binding.root
    }

    private fun setUpListeners() {
        binding.RoundProfile.setOnClickListener {
            val intent = Intent(requireContext(), LevelActivity::class.java)
            startActivity(intent)
        }
        binding.quizBoxCL.setOnClickListener {
            val intent = Intent(requireContext(), AdminQuizActivity::class.java)
            startActivity(intent)
        }
        binding.vocalbularyBoxCL.setOnClickListener {
            val intent = Intent(requireContext(), AdminVocalbularyActivity::class.java)
            startActivity(intent)
        }

    }
}

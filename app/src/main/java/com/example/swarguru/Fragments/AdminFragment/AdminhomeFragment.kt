package com.example.swarguru.Fragments.AdminFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.swarguru.AnimationActivity
import com.example.swarguru.LevelActivity
import com.example.swarguru.R
import com.example.swarguru.databinding.FragmentAdminhomeBinding
import com.example.swarguru.databinding.FragmentHomeBinding

class AdminhomeFragment : Fragment() {

    private lateinit var binding: FragmentAdminhomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminhomeBinding.inflate(layoutInflater)

        setUpListeners()

        return binding.root
    }

    private fun setUpListeners() {
        binding.RoundProfile.setOnClickListener {
            val intent = Intent(requireContext(), LevelActivity::class.java)
            startActivity(intent)
        }
        binding.quizbox.setOnClickListener {
            val intent = Intent(requireContext(), AnimationActivity::class.java)
            startActivity(intent)
        }
    }
}

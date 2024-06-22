package com.example.swarguru.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.swarguru.ChangePasswordActivity
import com.example.swarguru.EditProfileActivity
import com.example.swarguru.SpeechTherapyActivity
import com.example.swarguru.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        setUpListeners()

        return binding.root
    }
    private fun setUpListeners() {
        binding.editProfileTV.setOnClickListener {
            val intent = Intent(requireContext(), EditProfileActivity::class.java)
            startActivity(intent)
        }
        binding.changePasswordTV.setOnClickListener {
            val intent = Intent(requireContext(), ChangePasswordActivity::class.java)
            startActivity(intent)
        }
        binding.progessTV.setOnClickListener {
            val intent = Intent(requireContext(), EditProfileActivity::class.java)
            startActivity(intent)
        }
        binding.speechTherapyTV.setOnClickListener {
            val intent = Intent(requireContext(), SpeechTherapyActivity::class.java)
            startActivity(intent)
        }

    }



}
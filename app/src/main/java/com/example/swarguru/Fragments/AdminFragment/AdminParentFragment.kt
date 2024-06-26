package com.example.swarguru.Fragments.AdminFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.swarguru.R
import com.example.swarguru.databinding.FragmentAdminParentBinding

class AdminParentFragment : Fragment() {

    private lateinit var binding: FragmentAdminParentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdminParentBinding.inflate(layoutInflater)
        return binding.root
    }

}

package com.example.swarguru

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.swarguru.Fragments.GraphFragment
import com.example.swarguru.Fragments.HomeFragment
import com.example.swarguru.Fragments.ProfileFragment
import com.example.swarguru.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private val homeFragment = HomeFragment()
    private val graphFragment = GraphFragment()
    private val profileFragment = ProfileFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(homeFragment)

        setUpListeners()
    }

    private fun setUpListeners() {
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(homeFragment)
                }

                R.id.graph -> {
                    replaceFragment(graphFragment)
                }

                R.id.profile -> {
                    replaceFragment(profileFragment)
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }
}
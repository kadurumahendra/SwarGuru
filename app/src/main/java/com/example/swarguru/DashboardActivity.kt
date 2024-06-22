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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
            R.id.home -> {
                val homeFragment = HomeFragment()
                replaceFragment(homeFragment)
            }
                R.id.graph -> {
                    val graphFragment = GraphFragment()
                    replaceFragment(graphFragment)
                }
                R.id.profile -> {
                    val profileFragment = ProfileFragment()
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
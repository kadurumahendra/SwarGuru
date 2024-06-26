package com.example.swarguru.AdminActivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.swarguru.Fragments.AdminFragment.AdminParentFragment
import com.example.swarguru.Fragments.AdminFragment.AdminhomeFragment
import com.example.swarguru.Fragments.AdminFragment.SpeechVideosFragment
import com.example.swarguru.Fragments.GraphFragment
import com.example.swarguru.Fragments.HomeFragment
import com.example.swarguru.Fragments.ProfileFragment
import com.example.swarguru.R
import com.example.swarguru.databinding.ActivityAdminDashboardBinding
import com.example.swarguru.databinding.ActivityDashboardBinding
import com.example.swarguru.databinding.FragmentAdminParentBinding

class AdminDashboardActivity : AppCompatActivity() {


        private lateinit var binding: ActivityAdminDashboardBinding
        private val homeFragment = AdminhomeFragment()
        private val graphFragment = AdminParentFragment()
        private val profileFragment = SpeechVideosFragment()


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityAdminDashboardBinding.inflate(layoutInflater)
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

                    R.id.parent -> {
                        replaceFragment(graphFragment)
                    }

                    R.id.speechvideos -> {
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
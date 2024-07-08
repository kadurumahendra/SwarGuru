package com.example.swarguru

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swarguru.Adapters.LettersAdapter
import com.example.swarguru.Fragments.HomeFragment
import com.example.swarguru.databinding.ActivityLetterWordsBinding
import com.example.swarguru.databinding.ActivityLettersBinding
import com.example.swarguru.databinding.ActivitySignupBinding

class LettersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLettersBinding
    private var images = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLettersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBeginnerData()
        setAdapter()
        setUpListeners()
    }

    private fun setBeginnerData() {
        images.add(R.drawable.a)
        images.add(R.drawable.b)
        images.add(R.drawable.c)
        images.add(R.drawable.d)
        images.add(R.drawable.e)
        images.add(R.drawable.f)
        images.add(R.drawable.g)
        images.add(R.drawable.h)
    }

    private fun setIntermediateData() {
        images.add(R.drawable.i)
        images.add(R.drawable.j)
        images.add(R.drawable.k)
        images.add(R.drawable.l)
        images.add(R.drawable.m)
        images.add(R.drawable.n)
        images.add(R.drawable.o)
       images.add(R.drawable.p)
    }

    private fun setAdvancedData() {
        images.add(R.drawable.q)
        images.add(R.drawable.r)
        images.add(R.drawable.s)
        images.add(R.drawable.t)
        images.add(R.drawable.u)
        images.add(R.drawable.v)
        images.add(R.drawable.w)
        images.add(R.drawable.x)
    }

    private fun setAdapter() {
        binding.letterRV.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
        val adapter = LettersAdapter(images,this)
//        adapter.setShowLockIcon(false)
        binding.letterRV.adapter =  adapter
    }

    private fun setUpListeners() {
        binding.letterProfile.setOnClickListener {
            val intent = Intent(this, LetterWordsActivity::class.java)
            startActivity(intent)
        }
        binding.backButton.setOnClickListener {
            val intent = Intent(this, HomeFragment::class.java)
            startActivity(intent)
        }
    }
}


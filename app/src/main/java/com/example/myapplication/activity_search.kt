package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivitySearchBinding

class activity_search : AppCompatActivity() {
    val activity = this
    val binding by lazy {
        ActivitySearchBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        searchBar()

    }

    private fun searchBar() {
        binding.apply {
            searchBar.setNavigationOnClickListener {
            }
            searchView.setupWithSearchBar(searchBar)
        }

    }
}
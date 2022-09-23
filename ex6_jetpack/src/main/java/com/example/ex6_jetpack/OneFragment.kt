package com.example.ex6_jetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ex6_jetpack.databinding.FragmentOneBinding

// 원래 있던 거 바인딩으로 바꿈 return inflater.inflate(R.layout.fragment_one, container, false)
class OneFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOneBinding.inflate(inflater,container,false)
        return binding.root
    }

    }

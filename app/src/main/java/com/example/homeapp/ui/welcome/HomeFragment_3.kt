package com.example.homeapp.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homeapp.R
import com.example.homeapp.databinding.FragmentHome3Binding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class HomeFragment_3 : Fragment() {

    private var _binding: FragmentHome3Binding? = null
    private val binding get() = _binding!!
    val user = Firebase.auth.currentUser

//    private val args: HomeFragment_3Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_3, container, false)


    }

}
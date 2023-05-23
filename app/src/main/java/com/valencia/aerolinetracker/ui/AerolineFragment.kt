package com.valencia.aerolinetracker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.valencia.aerolinetracker.R
import com.valencia.aerolinetracker.databinding.FragmentAerolineBinding
import com.valencia.aerolinetracker.viewmodels.AerolineViewModel


class AerolineFragment : Fragment() {

    private val aerolineViewModel: AerolineViewModel by activityViewModels {
        AerolineViewModel.Factory
    }

    private lateinit var binding: FragmentAerolineBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAerolineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = aerolineViewModel
    }


}
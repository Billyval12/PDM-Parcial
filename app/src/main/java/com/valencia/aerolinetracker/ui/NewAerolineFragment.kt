package com.valencia.aerolinetracker.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.valencia.aerolinetracker.R
import com.valencia.aerolinetracker.databinding.FragmentAerolineBinding
import com.valencia.aerolinetracker.databinding.FragmentNewAerolineBinding
import com.valencia.aerolinetracker.viewmodels.AerolineViewModel


class NewAerolineFragment : Fragment() {

    private val aerolineViewModel: AerolineViewModel by activityViewModels {
        AerolineViewModel.Factory
    }

    private lateinit var binding: FragmentNewAerolineBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewAerolineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = aerolineViewModel
    }

    private fun observeStatus() {
        aerolineViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(AerolineViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    aerolineViewModel.clearStatus()
                }

                status.equals(AerolineViewModel.AEROLINE_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, aerolineViewModel.getAerolines().toString())

                    aerolineViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    companion object {
        const val APP_TAG = "APP_TAG"
    }

}
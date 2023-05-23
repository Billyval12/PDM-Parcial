package com.valencia.aerolinetracker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.valencia.aerolinetracker.R
import com.valencia.aerolinetracker.data.AerolineModel
import com.valencia.aerolinetracker.databinding.FragmentAerolineListBinding
import com.valencia.aerolinetracker.ui.recyclerview.AerolineRecyclerViewAdapter
import com.valencia.aerolinetracker.viewmodels.AerolineViewModel


class AerolineListFragment : Fragment() {

    private val aerolineViewModel: AerolineViewModel by activityViewModels {
        AerolineViewModel.Factory
    }

    private lateinit var binding: FragmentAerolineListBinding
    private lateinit var adapter: AerolineRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentAerolineListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.addAerolineButton.setOnClickListener{
            aerolineViewModel.clearData()
            it.findNavController().navigate(R.id.action_aerolineListFragment_to_newAerolineFragment)
        }
    }

    private fun displayAerolines() {
        adapter.setData(aerolineViewModel.getAerolines())
    }

    private fun setRecyclerView(view: View) {
        binding.RecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = AerolineRecyclerViewAdapter { selectedAeroline ->
            showSelectedItem(selectedAeroline)
        }

        binding.RecyclerView.adapter = adapter
        displayAerolines()
    }

    private fun showSelectedItem(aeroline: AerolineModel) {
        aerolineViewModel.setSelectedAeroline(aeroline)
        view?.findNavController()?.navigate(R.id.action_aerolineListFragment_to_aerolineFragment)
    }

}
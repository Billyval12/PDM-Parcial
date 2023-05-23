package com.valencia.aerolinetracker.ui.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.valencia.aerolinetracker.data.AerolineModel
import com.valencia.aerolinetracker.databinding.AerolineItemBinding

class AerolineRecyclerViewHolder (private val binding: AerolineItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(aeroline: AerolineModel, clickListener: (AerolineModel) -> Unit) {
        binding.AerolineName.text = aeroline.name
        binding.AerolineCountry.text = aeroline.country

        binding.aerolineCardView.setOnClickListener {
            clickListener(aeroline)
        }
    }
}

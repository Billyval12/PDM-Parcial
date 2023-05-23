package com.valencia.aerolinetracker.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.valencia.aerolinetracker.data.AerolineModel
import com.valencia.aerolinetracker.databinding.AerolineItemBinding

class AerolineRecyclerViewAdapter (private val clickListener: (AerolineModel)->Unit): RecyclerView.Adapter<AerolineRecyclerViewHolder>(){

    private val aerolines = ArrayList<AerolineModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AerolineRecyclerViewHolder {
        val binding = AerolineItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AerolineRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return aerolines.size
    }

    override fun onBindViewHolder(holder: AerolineRecyclerViewHolder, position: Int) {
        val aeroline = aerolines[position]
        holder.bind(aeroline, clickListener)
    }

    fun setData(aerolineList: List<AerolineModel>) {
        aerolines.addAll(aerolineList)
        notifyDataSetChanged()
    }
}
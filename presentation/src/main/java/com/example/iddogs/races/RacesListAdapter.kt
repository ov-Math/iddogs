package com.example.iddogs.races

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.DogRacesDomain
import com.example.iddogs.R

class RacesListAdapter() : RecyclerView.Adapter<RacesViewHolder>() {
    lateinit var activity : RacesView
    lateinit var options: List<DogRacesDomain>

    constructor(options: List<DogRacesDomain>, activity: RacesView) : this() {
        this.activity = activity
        this.options = options
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RacesViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return RacesViewHolder(layout)
    }

    override fun onBindViewHolder(holder: RacesViewHolder, position: Int) {
        val currentItem = options[position]
        holder.itemName.text = currentItem.name.capitalize()
        holder.item.setOnClickListener {
            activity.onRaceSelected(currentItem)
        }
        holder.itemName.setOnClickListener {
            activity.onRaceSelected(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return options.size
    }
}
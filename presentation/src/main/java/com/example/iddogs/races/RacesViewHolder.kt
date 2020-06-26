package com.example.iddogs.races

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.iddogs.R

class RacesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val item = itemView.findViewById<ConstraintLayout>(R.id.item)
    val itemName = itemView.findViewById<TextView>(R.id.itemName)
}
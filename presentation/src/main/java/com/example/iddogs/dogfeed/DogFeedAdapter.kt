package com.example.iddogs.dogfeed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.DogRacesDomain
import com.example.iddogs.R

class DogFeedAdapter() : RecyclerView.Adapter<DogFeedViewHolder>() {
    lateinit var activity : DogFeedView
    lateinit var options: List<String>

    constructor(options: List<String>, activity: DogFeedView) : this() {
        this.activity = activity
        this.options = options
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogFeedViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.feed_item, parent, false)
        return DogFeedViewHolder(layout)
    }

    override fun onBindViewHolder(holder: DogFeedViewHolder, position: Int) {
        val currentItem = options[position]

        Glide.with(activity as DogFeedActivity).load(currentItem).into(holder.image)

        holder.image.setOnClickListener {
            activity.onImageSelected(currentItem)
        }

    }

    override fun getItemCount(): Int {
        return options.size
    }
}
package com.example.projektv1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ReviewsAdapter(private val itemList: MutableList<Review>) :
    RecyclerView.Adapter<ReviewsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.reviews_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ReviewsAdapter.ViewHolder, position: Int) {
        val data = itemList[position]
        holder.itemTitle.text = data.name
        holder.itemDetail.text = data.comment
        Picasso.get().load(data.image).into(holder.itemImage)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.reviewImage)
            itemTitle = itemView.findViewById(R.id.reviewName)
            itemDetail = itemView.findViewById(R.id.reviewText)
        }

    }

    fun dataAdd(review: MutableList<Review>) {
        val difference = review.find { !itemList.contains(it) }

        if (difference != null) {
            itemList.add(difference)
            notifyItemInserted(itemCount - 1)
        }
    }
}
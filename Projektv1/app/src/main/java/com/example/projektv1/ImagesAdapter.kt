package com.example.projektv1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImagesAdapter (
    private val context: Context,
    private val images: List <Image>
        ) : RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>(){


    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val img = itemView.findViewById<ImageView>(R.id.imageImages)
        fun bindView(image: Image){
            img.setImageResource(image.imageSrc)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.images_layout, parent, false))


    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position])
    }

    override fun getItemCount(): Int = images.size
}
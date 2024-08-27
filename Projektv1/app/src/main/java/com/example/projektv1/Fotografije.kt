package com.example.projektv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fotografije : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fotografije)

        val actionBar = supportActionBar
        actionBar!!.title = "Fotografije"
        actionBar.setDisplayHomeAsUpEnabled(true)


        val images = listOf<Image>(
            Image(R.drawable.img_1),
            Image(R.drawable.img_2),
            Image(R.drawable.img_3),
            Image(R.drawable.img_4),
            Image(R.drawable.img_5)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.imagesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImagesAdapter(this, images)
    }
}
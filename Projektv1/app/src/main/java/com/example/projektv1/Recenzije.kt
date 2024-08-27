package com.example.projektv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Recenzije : AppCompatActivity() {

    companion object {
        lateinit var adapter: ReviewsAdapter
    }

    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recenzije)

        layoutManager = LinearLayoutManager(this)

        val recyclerView = findViewById<RecyclerView>(R.id.reviewsRecycler)
        recyclerView.layoutManager = layoutManager
        adapter = ReviewsAdapter(mutableListOf())
        recyclerView.adapter = adapter


        val actionBar = supportActionBar
        actionBar!!.title = "Recenzije"
        actionBar.setDisplayHomeAsUpEnabled(true)

        Firebase.fetchReviews()
    }
}
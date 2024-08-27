package com.example.projektv1

import android.util.Log
import com.google.firebase.database.*

object Firebase {
    private val dbInstance =
        FirebaseDatabase.getInstance("https://reviewshotel-90e81-default-rtdb.europe-west1.firebasedatabase.app/")
    private val reviewsDbReference = dbInstance.getReference("Reviews")

    fun pushReview(name: String, comment: String, image: String) {
        val review: Review = Review(name, comment, image)

        reviewsDbReference.push().setValue(review).addOnCompleteListener {
            if (it.isSuccessful) {
                Log.e("pushed to database", review.toString())
            } else {
                Log.e("failed push to database", review.toString())
            }
        }
    }

    fun fetchReviews() {
        val reviewsListener = object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val reviews = mutableListOf<Review>()

                val reviewData = snapshot.value as HashMap<*, *>
                val task = Review(
                    reviewData["name"].toString(),
                    reviewData["comment"].toString(),
                    reviewData["image"].toString()
                )

                reviews.add(task)
                Recenzije.adapter.dataAdd(reviews)
            }

            override fun onCancelled(error: DatabaseError) {}
            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onChildRemoved(snapshot: DataSnapshot) {}
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
        }

        val query: Query = reviewsDbReference.orderByChild("name")
        query.addChildEventListener(reviewsListener as ChildEventListener)
    }

}
package com.example.projektv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val userNameTextView: TextView = findViewById(R.id.userNameTextView)
        val loginLogoutButton: Button = findViewById(R.id.loginLogoutButton)

        val user = auth.currentUser

        if (user != null) {
            userNameTextView.text = user.displayName ?: "User"
            loginLogoutButton.text = "Logout"
        } else {
            userNameTextView.text = "Not logged in"
            loginLogoutButton.text = "Login"
        }

        loginLogoutButton.setOnClickListener {
            if (user != null) {
                auth.signOut()
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
            }
        }

        findViewById<Button>(R.id.buttonFoto).setOnClickListener{
            val intentPhoto = Intent(this, Fotografije::class.java)
            startActivity(intentPhoto)
        }

    /*    findViewById<Button>(R.id.buttonSobe).setOnClickListener{
            val intent = Intent(this, Sobe::class.java)
            startActivity(intent)
        }*/

        findViewById<Button>(R.id.buttonRecenzije).setOnClickListener{
            val intentReviews = Intent(this, Recenzije::class.java)
            startActivity(intentReviews)
        }
        findViewById<Button>(R.id.buttonKontakt).setOnClickListener{
            val intentContact = Intent(this, Kontakt::class.java)
            startActivity(intentContact)
        }
        /*findViewById<Button>(R.id.buttonLogin).setOnClickListener{
            val intentLogin = Intent(this, Login::class.java)
            startActivity(intentLogin)
        }*/
        val actionBar = supportActionBar
        actionBar!!.title = "Hotel Mima"

        val image = findViewById<ImageView>(R.id.mainImage)
        Picasso.get().load("https://inel.com.hr/wp-content/uploads/2022/08/93.jpg").into(image)
    /*
        Firebase.pushReview("Milan Perić", "Sobe su sasvim solidno raspoređene", "https://randomuser.me/api/portraits/men/18.jpg")
        Firebase.pushReview("Iva Ivić", "Ugostitelji su ljubazni, svakako preporučam", "https://randomuser.me/api/portraits/women/13.jpg")
        Firebase.pushReview("Ana Anić", "Sobe nisu po mom ukusu, ne preporučujem", "https://randomuser.me/api/portraits/women/43.jpg")
        Firebase.pushReview("Stjepan Stipić", "Hotel ima dobre atrakcije, posebno mi se svidio eksterier", "https://randomuser.me/api/portraits/men/27.jpg")
        Firebase.pushReview("Mario Marić", "Hrana je bila ukusna", "https://randomuser.me/api/portraits/men/64.jpg")

    */
    }

}

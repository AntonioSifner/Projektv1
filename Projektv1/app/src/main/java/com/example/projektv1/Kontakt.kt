package com.example.projektv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.projektv1.databinding.ActivityKontaktBinding
import com.google.android.material.tabs.TabLayoutMediator

class Kontakt : AppCompatActivity() {

    private lateinit var kontaktBinding: ActivityKontaktBinding

    private var adapter = FragmentAdapter(supportFragmentManager, lifecycle)

    companion object {
        lateinit var viewPager: ViewPager2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kontaktBinding = ActivityKontaktBinding.inflate(layoutInflater)
        initializeUI()

        val actionBar = supportActionBar
        actionBar!!.title = "Kontakt"
        actionBar.setDisplayHomeAsUpEnabled(true)
        setContentView(kontaktBinding.root)
    }

    private fun initializeUI() {
        val fragmentTitles = arrayOf("Recepcija", "Vlasnik")

        viewPager = kontaktBinding.vpFragments
        val tabLayout = kontaktBinding.tlKontakt
        viewPager.adapter = adapter
        //viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = fragmentTitles[position]
        }.attach()
    }
}
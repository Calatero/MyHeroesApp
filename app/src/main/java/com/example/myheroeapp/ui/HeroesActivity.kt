package com.example.myheroeapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myheroeapp.R
import com.example.myheroeapp.adapters.HeroeAdapter
import com.example.myheroeapp.models.Heroe
import com.example.myheroeapp.models.Publisher

class HeroesActivity : AppCompatActivity() {
    lateinit var publisherTV: TextView
    lateinit var heroeRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_heroes)
        publisherTV = findViewById(R.id.publisher_activity_name)
        heroeRecyclerView = findViewById(R.id.heroes_activity_recyclerview)
        val publisherId = intent.getIntExtra("publisherId",0)
        val publisher = Publisher.publishers.firstOrNull{ it.id == publisherId}
        publisherTV.text = publisher?.name
        heroeRecyclerView.adapter = HeroeAdapter(Heroe.heroes.filter {it.publisherId == publisherId}){
            startActivity(intent)
        }
        heroeRecyclerView.layoutManager = GridLayoutManager(this,2)

    }
}
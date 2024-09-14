package com.example.myheroeapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myheroeapp.MainActivity
import com.example.myheroeapp.R
import com.example.myheroeapp.adapters.PublisherAdapter
import com.example.myheroeapp.models.Publisher
import com.example.myheroeapp.models.User

class PublisherActivity : AppCompatActivity(){
    lateinit var userName : TextView
    lateinit var logoutBtn : ImageView
    lateinit var publishersRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_publisher)
        val sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)
        userName = findViewById(R.id.userNameTV)
        logoutBtn = findViewById(R.id.logoutBtn)
        val userEmail = sharedPreferences.getString("userEmail","")
        val user = User.staticUser.firstOrNull{ user -> user.email == userEmail}
        userName.text = user?.name
        publishersRecyclerView = findViewById(R.id.publishers_recycleview)
        publishersRecyclerView.adapter = PublisherAdapter(Publisher.publishers){ publisher ->
            Log.i("PublisherActivity", publisher.name)
            val intent = Intent(this@PublisherActivity,HeroesActivity::class.java).apply {
                putExtra("publisherId",publisher.id)
            }
            startActivity(intent)
        }
        publishersRecyclerView.layoutManager = GridLayoutManager(this, 1)

        logoutBtn.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.remove("isLogged")
            editor.apply()

            val intent = Intent(this@PublisherActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
package com.example.uts

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailSuperheroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_superhero)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val imgSuperhero: ImageView = findViewById(R.id.img_item_photo)
        val nameSuperhero: TextView = findViewById(R.id.tv_item_name)
        val newsSuperhero: TextView = findViewById(R.id.tv_item_news)

        val bundle: Bundle? = intent.extras
        val image = bundle!!.getInt("image")
        val name = bundle!!.getString("name")
        val news = bundle!!.getString("news")

        imgSuperhero.setImageResource(image)
        nameSuperhero.text = name
        newsSuperhero.text = news

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
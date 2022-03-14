package com.example.recycleviewexample

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.codinginflow.recyclerviewexample.ExampleItem

class moreOnClick : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_on_click)

        val textFirst : TextView = findViewById(R.id.text_view_1)
        val image : ImageView = findViewById(R.id.image_view)

        val bundle : Bundle?= intent.extras

        val text1 = bundle!!.getString("text1")
        val imageId = bundle!!.getInt("imageResource")


        textFirst.text = text1
        image.setImageResource(imageId)
    }
}
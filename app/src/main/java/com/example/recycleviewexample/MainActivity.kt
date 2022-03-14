package com.example.recycleviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codinginflow.recyclerviewexample.ExampleItem
import com.example.exampleretrofit.MainViewModel
import com.example.exampleretrofit.MainViewModelFactory
import com.example.exampleretrofit.Repository
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    lateinit var ExampleItem : ArrayList<String>
    private lateinit var viewModel: MainViewModel

    val repository = Repository()
    val viewModelFactory = MainViewModelFactory(repository)
    val title = findViewById<TextView>(R.id.text_view_1)
    val poster = findViewById<ImageView>(R.id.image_view)





    //Recycler_view
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exampleList = generateDummyList(500)

        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)

        var adapter = ExampleAdapter(exampleList)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
        adapter.setOnItemClickListener(object : ExampleAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                val intent = Intent(this@MainActivity, moreOnClick::class.java)


                intent.putExtra("text1", exampleList[position].text1)
                intent.putExtra("imageResource", exampleList[position].imageResource)
                startActivity(intent)


//                Toast.makeText(this@MainActivity,"You clicked item!", Toast.LENGTH_SHORT).show()
            }

        })

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            title.text = response.title
            poster.setBackgroundResource(response.posterPath)

        })





    }




    private fun generateDummyList(size: Int) : List<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_audio
                else -> R.drawable.ic_sun
            }

            val item = ExampleItem(drawable, "Title $i ","")
            list += item
        }

        return list
    }





}
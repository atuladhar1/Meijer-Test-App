package com.example.technicaskillproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.technicaskillproject.R
import com.example.technicaskillproject.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var myViewModel: MyViewModel
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProvider(this).get<MyViewModel>()
        adapter = RecyclerViewAdapter(this, ArrayList())

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        init()
    }

    // Function to Get data from the API upon launch of action and handle New API calls.
    private fun init() {
        myViewModel.passData("naruto").observe(this, {
            adapter.newData(it)
        })
        findViewById<ImageView>(R.id.click).setOnClickListener {
            val query = findViewById<EditText>(R.id.mainEditText).text.toString()
            if (query.isNullOrBlank()) {
                Toast.makeText(this, "Please enter valid text", Toast.LENGTH_SHORT).show()
            } else {
                myViewModel.passData(query).observe(this, {
                    adapter.newData(it)
                })
            }
        }
    }
}
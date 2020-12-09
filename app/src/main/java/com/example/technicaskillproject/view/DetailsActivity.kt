package com.example.technicaskillproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.technicaskillproject.R
import com.example.technicaskillproject.databinding.ActivityDetailsBinding
import com.example.technicaskillproject.model.Result
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind =
            DataBindingUtil.setContentView<ActivityDetailsBinding>(this, R.layout.activity_details)
        val details = intent.getSerializableExtra("data") as Result
        bind.details = details

        Picasso.get().load(details.image_url).placeholder(R.drawable.placeholder)
            .into(bind.detailsImage)
    }
}
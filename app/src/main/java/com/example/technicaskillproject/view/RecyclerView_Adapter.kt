package com.example.technicaskillproject.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.technicaskillproject.R
import com.example.technicaskillproject.databinding.RecyclerViewRowBinding
import com.example.technicaskillproject.model.Result
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(private val context: Context, private var list: List<Result>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    //    Create rows for the Recycler View with data binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_view_row, parent, false)
        val bind = RecyclerViewRowBinding.bind(view)
        return ViewHolder(bind.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    //    Pass data from the Activity that is to be displayed in the Recycler View.
    fun newData(newList: List<Result>) {
        list = newList
        (context as MainActivity).runOnUiThread {
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        //        Populate the data using dataBinding and load Image using Picasso
        fun bindView(result: Result) {
            val bind = DataBindingUtil.getBinding<RecyclerViewRowBinding>(view)
            Picasso.get().load(result.image_url).placeholder(R.drawable.placeholder)
                .into(bind?.rowImage)
            bind?.result = result

//            Handle click events to open the details activity when a view is clicked.
            view.setOnClickListener {
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("data", result)
                context.startActivity(intent)
            }
        }
    }
}
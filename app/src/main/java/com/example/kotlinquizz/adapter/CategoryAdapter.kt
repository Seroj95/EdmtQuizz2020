package com.example.kotlinquizz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinquizz.R
import com.example.kotlinquizz.interfac.iOnRecyclerViewItemClickListener
import com.example.kotlinquizz.model.Category
import kotlinx.android.synthetic.main.layout_category_item.view.*

class CategoryAdapter(internal var context: Context,internal var  categoryList: List<Category>):RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),View.OnClickListener{

        internal var txt_category_name:TextView
internal var card_category:CardView
        internal lateinit var iOnRecyclerViewItemClickListener:iOnRecyclerViewItemClickListener
        fun setiOnRecyclerViewItemClickListener(iOnRecyclerViewItemClickListener: iOnRecyclerViewItemClickListener){
            this.iOnRecyclerViewItemClickListener=iOnRecyclerViewItemClickListener
        }

        init {
            txt_category_name=itemView.findViewById(R.id.text_category_name)as TextView
            card_category=itemView.findViewById(R.id.card_category)as CardView
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            if (view != null) {
                iOnRecyclerViewItemClickListener.onClick(view,adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.layout_category_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.txt_category_name.text=categoryList[position].name
        holder.setiOnRecyclerViewItemClickListener(object:iOnRecyclerViewItemClickListener{
            override fun onClick(view: View, position: Int) {
                Toast.makeText(context,"Click on "+categoryList[position].name,Toast.LENGTH_SHORT).show()
            }

        }
        )
    }

}
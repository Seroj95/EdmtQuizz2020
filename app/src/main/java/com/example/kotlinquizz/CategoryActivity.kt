package com.example.kotlinquizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.Space
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinquizz.Common.SpaceItemDescreption
import com.example.kotlinquizz.DBHelper.DBHelper
import com.example.kotlinquizz.adapter.CategoryAdapter
import kotlinx.android.synthetic.main.category_main.*

//6 r, DB SQLITE avelacnel assets database-i mej http://destyy.com/w1QZPl
class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_main)
        toolbar.title="EDMT QUIZ 2019"
        setSupportActionBar(toolbar)
        recycler_category.setHasFixedSize(true)
        recycler_category.layoutManager=GridLayoutManager(this,2)
        val adapter=CategoryAdapter(this,DBHelper.getInstance(this).allCategory)
        recycler_category.addItemDecoration(SpaceItemDescreption(4))
        recycler_category.adapter=adapter
    }
}

package com.bagasbest.fundamental.myListView

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.bagasbest.fundamental.R
import com.bagasbest.fundamental.myListView.adapter.MyListViewHeroAdapter
import com.bagasbest.fundamental.myListView.model.MyListViewHero
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_my_list_view_main.*

class MyListViewMainActivity : AppCompatActivity() {

   // private val dataName = arrayOf("Cut Nyak Dien", "Ki Hajar Dewantara", "Moh Yamin", "Pattimura", "R A Kartini", "Sukarno")
    private lateinit var adapter: MyListViewHeroAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var heroes = arrayListOf<MyListViewHero>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_list_view_main)

//        val adapter = ArrayAdapter(
//            this,
//            android.R.layout.simple_list_item_1,
//            android.R.id.text1,
//            dataName
//        )

        adapter = MyListViewHeroAdapter(this)
        lv_list.adapter = adapter

        prepare()
        addItem()

        lv_list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, heroes[position].name, Toast.LENGTH_SHORT).show()
        }

    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem () {
        for(position in dataName.indices) {
            val hero = MyListViewHero(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position],
            )
            heroes.add(hero)
        }
        adapter.heroes = heroes
    }
}
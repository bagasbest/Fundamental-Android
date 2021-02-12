package com.bagasbest.fundamental.myListView.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bagasbest.fundamental.R
import com.bagasbest.fundamental.myListView.model.MyListViewHero
import com.bumptech.glide.Glide

class MyListViewHeroAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal  var heroes = arrayListOf<MyListViewHero>()

    override fun getCount(): Int {
        return heroes.size
    }

    override fun getItem(p0: Int): Any {
        return heroes[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view;

        if(itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.my_list_view_item_hero ,viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(i) as MyListViewHero
        viewHolder.bind(hero)
        return itemView

    }

    private inner class ViewHolder internal constructor(view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: ImageView = view.findViewById(R.id.img_photo)




        internal fun bind(hero: MyListViewHero) {
            txtName.text = hero.name
            txtDescription.text = hero.description
            Glide.with(context).load(hero.photo).into(imgPhoto)
        }
    }


}
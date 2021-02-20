package com.bagasbest.fundamental.submission1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bagasbest.fundamental.R
import com.bagasbest.fundamental.submission1.GithubUserDetailActivity
import com.bagasbest.fundamental.submission1.model.GithubUserModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.github_user_list_item.view.*
import org.w3c.dom.Text

class GithubUserListAdapter (private val userList: List<GithubUserModel>) :
    RecyclerView.Adapter<GithubUserListAdapter.GithubUserListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserListViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.github_user_list_item, parent, false)

        return GithubUserListViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: GithubUserListViewHolder, position: Int) {
        holder.bind(userList[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, GithubUserDetailActivity::class.java);
            intent.putExtra(GithubUserDetailActivity.EXTRA_USER, userList[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class GithubUserListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(list : GithubUserModel) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(list.avatar)
                    .apply(RequestOptions().override(75, 75))
                    .into(img_avatar)
                tv_item_name.text = list.name
                tv_item_username.text = list.username
                tv_item_repository.text = list.repository



            }
        }



    }

}
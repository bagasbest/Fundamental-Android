package com.bagasbest.fundamental.submission1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagasbest.fundamental.R
import com.bagasbest.fundamental.myListView.adapter.MyListViewHeroAdapter
import com.bagasbest.fundamental.submission1.adapter.GithubUserListAdapter
import com.bagasbest.fundamental.submission1.model.GithubUserModel
import kotlinx.android.synthetic.main.activity_github_user_main.*
import kotlinx.android.synthetic.main.activity_my_list_view_main.*

class GithubUserMainActivity : AppCompatActivity() {

    private val list = ArrayList<GithubUserModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_user_main)

        rv_github_user_list.setHasFixedSize(true)
        list.addAll(getListUserGithub())
        showRecyclerList()
    }

    private fun getListUserGithub() : ArrayList<GithubUserModel> {
        val fullname = resources.getStringArray(R.array.name)
        val username = resources.getStringArray(R.array.username)
        val company = resources.getStringArray(R.array.company)
        val location = resources.getStringArray(R.array.location)
        val follower = resources.getStringArray(R.array.followers)
        val following = resources.getStringArray(R.array.following)
        val repository = resources.getStringArray(R.array.repository)
        val avatar = resources.obtainTypedArray(R.array.avatar)

        for (position in username.indices) {
            val user = GithubUserModel(
                '@' + username[position],
                fullname[position],
                avatar.getResourceId(position, -1),
                company[position],
                location[position],
                repository[position],
                follower[position],
                following[position],
            )
            list.add(user)
        }
        return list
    }

    private fun showRecyclerList () {
        rv_github_user_list.layoutManager = LinearLayoutManager(this)
        val listGithubUserAdapter = GithubUserListAdapter(list)
        rv_github_user_list.adapter = listGithubUserAdapter

    }
}
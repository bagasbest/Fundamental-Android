package com.bagasbest.fundamental.submission1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bagasbest.fundamental.R
import com.bagasbest.fundamental.submission1.model.GithubUserModel
import kotlinx.android.synthetic.main.activity_github_user_detail.*

class GithubUserDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_user_detail)

        val person = intent.getParcelableExtra<GithubUserModel>(EXTRA_USER) as GithubUserModel
        val fullname = person.name
        val username = person.username
        val location = person.location
        val company = person.company
        val following = person.following
        val follower = person.follower
        val repository = person.repository
        val avatar = person.avatar

        tv_user_name.text = fullname
        tv_user_username.text = username
        tv_user_location.text = location
        tv_user_company.text = company
        tv_user_following.text = "Following $following"
        tv_user_follower.text = "Follower $follower"
        tv_user_repository.text = repository
        img_user_avatar.setImageDrawable(resources.getDrawable(avatar))
    //        val text = "Name : ${person.name.toString()},\nEmail : ${person.email},\nAge : ${person.age},\nLocation : ${person.city}"
//        tv_object_received.text = text

    }
}
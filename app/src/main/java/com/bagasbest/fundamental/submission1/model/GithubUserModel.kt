package com.bagasbest.fundamental.submission1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUserModel (
    var username: String,
    var name: String,
    var avatar: Int,
    var company: String,
    var location: String,
    var repository: String,
    var follower: String,
    var following: String,
) : Parcelable

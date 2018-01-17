package com.teamwork.josehidalgo.extensions

import android.text.TextUtils
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.teamwork.josehidalgo.R

/**
 * Created by jnhidalgo on 17/1/18.
 */

fun ImageView.loadImg(imageUrl: String) {
    if (TextUtils.isEmpty(imageUrl)) {
        Picasso.with(context).load(R.mipmap.ic_launcher).into(this)
    } else {
        Picasso.with(context).load(imageUrl).into(this)
    }
}
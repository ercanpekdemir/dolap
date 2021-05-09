package com.trendyol.dolap.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.trendyol.dolap.R

@BindingAdapter( "app:src_glide")
fun ImageView?.setSrcGlide(path: String?) = this?.run {
    Glide.with(this)
        .load(path)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade())
        .error(R.drawable.error)
        .into(this)
}
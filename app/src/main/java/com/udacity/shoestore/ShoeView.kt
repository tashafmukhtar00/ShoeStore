package com.udacity.shoestore

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.databinding.ShoeViewBinding

class ShoeView(context: Context) : LinearLayout(context) {

    private var binding: ShoeViewBinding =
        DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.shoe_view, this, false)


}
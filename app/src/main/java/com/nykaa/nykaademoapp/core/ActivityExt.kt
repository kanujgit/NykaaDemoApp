package com.nykaa.nykaademoapp.core

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nykaa.nykaademoapp.NykaaApplication

fun AppCompatActivity.getAppComponent() =
    (this.application as NykaaApplication).applicationComponent

fun AppCompatActivity.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.hide() {
    visibility = View.GONE
}
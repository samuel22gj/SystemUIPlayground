package com.example.systemuiplayground

import android.app.Activity
import android.os.Build
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes

fun Int.toHexString() = Integer.toHexString(this).toUpperCase()

fun Activity.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

fun Activity.toast(@StringRes resId: Int) {
    Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
}

fun View.fitsSystemWindowsAndApply(boolean: Boolean) {
    if (fitsSystemWindows != boolean) {
        fitsSystemWindows = boolean
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) { // API 20
            requestApplyInsets()
        } else {
            requestFitSystemWindows()
        }
    }
}

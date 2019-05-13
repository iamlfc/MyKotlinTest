package iam.lfc.myapplication.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import iam.lfc.myapplication.R

open class BaseMain : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

    }

    fun Context.showToast(strMsg: String?) {

        if (TextUtils.isEmpty(strMsg)) {
            return
        } else {
            Toast.makeText(this@BaseMain, strMsg, Toast.LENGTH_SHORT).show()
        }
    }



}

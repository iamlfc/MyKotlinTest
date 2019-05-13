package iam.lfc.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import iam.lfc.myapplication.base.BaseMain
import kotlinx.android.synthetic.main.activity_img_list.*

class ImgList_A : BaseMain() {
    companion object {
        fun EnterThis(context: Context, string: String, int: Int) {
            var intent = Intent(context, ImgList_A().javaClass)
            intent.putExtra("Title", string)
            intent.putExtra("time", int)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_img_list)
        var title = intent.getStringExtra("Title")
        var time = intent.getIntExtra("time", 0)
        toolbar_iml.title = title;
        Log.d("--lfc", title + "  " + time)

        initView()
        initData()
    }

    private fun initData() {

    }

    private fun initView() {
    }


}

package iam.lfc.myapplication

import android.os.Bundle
import android.view.View
import iam.lfc.myapplication.base.BaseMain
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMain() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
        getData()
    }

    fun getData() {


    }

    fun initData() {
    }

    fun initView() {
        btn_img.text = "图片的？"
        btn_test.text = "测试的？"
        btn_img.setOnClickListener(this)
        btn_test.setOnClickListener(this)
        btn_list.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v?.id) {
            R.id.btn_img -> {
                showToast("图片")
                KotlinTest_A.EnterThis(this, "九头蛇万岁", 2);
                /* var intent = Intent()
                 intent.setClass(this@MainActivity, KotlinTest_A().javaClass)
                 startActivity(intent)*/

            }
            R.id.btn_test -> ImgList_A.EnterThis(this, "我是标题", 1)
            R.id.btn_list -> RecyclerViewTest_A.EnterThis(this, "测试Recyclerview", 1)
        }

    }

}



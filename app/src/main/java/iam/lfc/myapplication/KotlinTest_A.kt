package iam.lfc.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import iam.lfc.myapplication.base.BaseMain
import iam.lfc.myapplication.utils.LgU
import kotlinx.android.synthetic.main.activity_kontlin_test.*
import java.util.*

class KotlinTest_A : BaseMain() {
    companion object {
        fun EnterThis(context: Context, string: String, int: Int) {
            var intent = Intent(context, KotlinTest_A().javaClass)
            intent.putExtra("Title", string)
            intent.putExtra("Time", int)
            context.startActivity(intent)
        }
    }

    var title: String? = ""
    var MyTime: Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kontlin_test)
        title = intent?.getStringExtra("Title")
        MyTime = intent?.getIntExtra("Time", 0)
        initView()
        initData()

    }

    private fun initData() {
        textView.text = title;
        showToast(if (MyTime == 0) "啥也米有" else "(ノ｀Д)ノ")
        button.text = "until"
        button2.text = "downTo"
        button3.text = ".."
        button4.text = "for"
        button5.text = "when"

        button.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
    }

    private fun initView() {

    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v?.id) {
            R.id.button ->
//               until[n,m) => 即大于等于n,小于m
                for (i in 0 until 5) {
                    LgU.d(i.toString())
                }
            R.id.button2 ->
//            downTo[n,m] => 即小于等于n,大于等于m ,n > m
                for (i in 10 downTo 5) {
                    LgU.d(i.toString())
                }
            R.id.button3 ->
//                ..[n,m]=> 即大于等于n，小于等于m
                for (i in 0..10 step 2) {
                    LgU.d(i.toString())
                }
            R.id.button3 ->
//                ..[n,m]=> 即大于等于n，小于等于m

                for (i in 0..10 step 2) {
                    LgU.d(i.toString())
                }
            R.id.button4 -> {
//                ..[n, m]=> 即大于等于n，小于等于m
                val list = mutableListOf<CommonDataM>()
                for (i in 0..10)
                    list.add(CommonDataM(i.toString() + "a", i.toString() + "a", i.toString() + "a", i))

                for (item in list) {
                    LgU.d(" in " + item.value4.toString() + "  " + item.value1 + "\t" + item)

                }
                list.forEachIndexed { index, commonDataM ->
                    LgU.d("forEachIndexed " + commonDataM.value4.toString() + "  " + commonDataM.value1 + "\t" + index.toString())
                }
                /*list.forEach {
                    LgU.d(it.value4.toString() + "  " + it.value1 + "\t" + it.toString())

                }*/
            }
            R.id.button5 -> {
                var index = Random().nextInt(15)
                when (index) {
                    0, 1, 2, 3 -> showToast("第一层 " + index)
                    4, 5, 6 -> showToast("第二层 " + index)
                    7, 8, 9 -> showToast("第三层 " + index)
                    10 -> showToast("第四层 " + index)
                    else -> showToast("第五层 " + index)

                }
            }
//
        }
    }
}

package iam.lfc.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.footer.BallPulseFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import iam.lfc.myapplication.base.BaseMain
import iam.lfc.myapplication.myAdapter.TestAdapter
import kotlinx.android.synthetic.main.activity_recycler_view_test.*
import java.util.*

/**
 * recyclerview  加头加尾 加空布局
 */
class RecyclerViewTest_A : BaseMain() {
    companion object {
        fun EnterThis(context: Context, string: String, int: Int) {
            var intent = Intent(context, RecyclerViewTest_A().javaClass)
            intent.putExtra("Title", string)
            intent.putExtra("Time", int)
            context.startActivity(intent)
        }
    }

    //    var list_data = ArrayList<CommonDataM>()
    var list_data = mutableListOf<CommonDataM>()
    var pageNum = 1
    var testAdapter: TestAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_test)
        initData()
        initView()
    }

    private fun initView() {
//        smartfreshLayout  的设置
        val mClassicsHeader = ClassicsHeader(baseContext)
        mClassicsHeader.setPrimaryColor(resources.getColor(R.color.StatusColor0))//设置主题颜色
        val mClassicsFooter = BallPulseFooter(baseContext)
        mClassicsFooter.setAnimatingColor(resources.getColor(R.color.colorAccent))
        mClassicsFooter.setNormalColor(resources.getColor(R.color.colorPrimary))
        refresh_rt.setRefreshHeader(mClassicsHeader)
        refresh_rt.setRefreshFooter(mClassicsFooter)
        refresh_rt.apply {
            setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
                override fun onLoadMore(refreshLayout: RefreshLayout) {
                    pageNum++
                    getData()
                }

                override fun onRefresh(refreshLayout: RefreshLayout) {
                    pageNum = 1
                    getData()
                }

            })
        }

        rlv_rt.apply {
            testAdapter = TestAdapter(list_data, baseContext)
            testAdapter!!.addEmptyView(R.layout.item_empty)
            testAdapter!!.addHeaderView(R.layout.item_header)
            testAdapter!!.addFooterView(R.layout.item_footer)

            /*  testAdapter!!.onItemClickCallback.apply {
                  object : OnItemClickCallback {
                      override fun OnItemClickCallbackListener(t: Int, value: String) {
                          showToast("回调ing " + value)
                      }
                  }
              }*/
            testAdapter!!.setItemClickCallBack(object : OnItemClickCallback {
                override fun OnItemClickCallbackListener(t: Int, value: String) {
                    showToast("回调ing " + value)
                }
            })
            rlv_rt.layoutManager = LinearLayoutManager(baseContext)
            rlv_rt.adapter = testAdapter


        }


    }

    private fun initData() {

        for (i in 0 until Random().nextInt(5)) {
            list_data.add(CommonDataM(i.toString(), value4 = i))
        }
        /**
         * 判断集合元素，如果集合为空或者没有符号条件的元素返回false, 集合中存有一个或多个元素符合条件时返回true
         */
        list_data.any { it.value1.equals("66") }
        /**
         * 当且仅当该集合中所有元素都满足条件时，返回true；否则都返回false。
         */
        list_data.all { !TextUtils.isEmpty(it.value1) }

    }

    /**
     *   加载数据
     */
    private fun getData() {
        /*  try {
              Thread.sleep(1000)
          } catch (e: InterruptedException) {
              e.printStackTrace()
          }
  */

        if (pageNum == 1)
            list_data.clear()
        for (i in 0 until Random().nextInt(5)) {
            list_data.add(CommonDataM(i.toString(), value4 = i))
        }
        testAdapter!!.notifyDataSetChanged()
        refresh_rt.finishLoadMore()
        refresh_rt.finishRefresh()
    }
}

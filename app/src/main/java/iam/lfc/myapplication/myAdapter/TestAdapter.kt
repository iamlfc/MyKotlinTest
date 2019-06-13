package iam.lfc.myapplication.myAdapter

import android.content.Context
import android.widget.TextView
import android.widget.Toast
import iam.lfc.myapplication.CommonDataM
import iam.lfc.myapplication.OnItemClickCallback
import iam.lfc.myapplication.R
import iam.lfc.myapplication.weight.adapter.AdvancedRecyclerViewAdapter
import iam.lfc.myapplication.weight.adapter.AdvancedRecyclerViewHolder

/**
 * Created by LFC
on 2019/6/12.
 */
class TestAdapter(listData: MutableList<CommonDataM>, baseContext: Context?, type: Int = 2) : AdvancedRecyclerViewAdapter<CommonDataM>(baseContext, listData) {
//class TestAdapter : AdvancedRecyclerViewAdapter<CommonDataM>() {

    private var listData = mutableListOf<CommonDataM>()
    private var baseContext: Context? = null
    private var showType = 0// 0 正常 1 控制判断
    var onItemClickCallback: OnItemClickCallback? = null

    init {
        showType = type
        this.baseContext = baseContext
    }

    fun setItemClickCallBack(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    override fun onBindContentViewHolder(holder: AdvancedRecyclerViewHolder?, positon: Int) {
//        val tv = holder!! as HeadHolder.get(R.id.tv_top_head) as TextView
//        tv.text = positon.toString() + "唉呀妈呀脑瓜疼"
        holder!!.setText(R.id.item_tv_content, "第" + positon.toString() + "号 小宝贝")
        holder!!.itemView.setOnClickListener {
//            Toast.makeText(baseContext, positon.toString() + "body ", Toast.LENGTH_SHORT).show()
            onItemClickCallback!!.OnItemClickCallbackListener(positon, positon.toString())

        }

    }

    override fun onBindEmptyViewHolder(holder: AdvancedRecyclerViewHolder?, positon: Int) {
        val tv = holder!!.get<TextView>(R.id.tv_info_empty) as TextView
        tv.text = positon.toString() + " 苍也空井也空~~!"

    }

    override fun onBindFooterViewHolder(holder: AdvancedRecyclerViewHolder?, positon: Int) {
        val tv = holder!!.get<TextView>(R.id.tv_info_foot)
        tv.text = positon.toString() + "jio 真好看"
        tv.setOnClickListener {
            Toast.makeText(baseContext, positon.toString() + "jio 疼", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBindHeaderViewHolder(holder: AdvancedRecyclerViewHolder?, positon: Int) {
        (holder)!!.setText(R.id.tv_top_head, positon.toString() + "唉呀妈呀脑瓜疼")


    }

    override fun setContentLayout(): Int {
        return R.layout.item_myrlv
    }

}
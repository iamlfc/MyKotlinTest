package iam.lfc.myapplication

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.zhy.adapter.recyclerview.CommonAdapter
import com.zhy.adapter.recyclerview.base.ViewHolder
import iam.lfc.myapplication.Share.Data
import iam.lfc.myapplication.weight.MessagePicturesLayout

/**
 * Created by LFC
on 2019/5/14.
 */
class MyAdapter : CommonAdapter<Data> {

    /**
     *
     * 展示类型
     *
     */
    var showType: Int? = 0
    var myContext: Context? = null
    var mCallback: MessagePicturesLayout.Callback? = null
    var list_data = mutableListOf<Data>()

    constructor(context: Context?, layoutId: Int = R.layout.recycler_main_message, datas: MutableList<Data>?) : this(context, layoutId, datas, 1)

    constructor(context: Context?, layoutId: Int = R.layout.recycler_main_message, datas: MutableList<Data>?, showtype: Int) : super(context, layoutId, datas) {
        this.showType = showtype
        this.myContext = context
    }

    override fun convert(holder: ViewHolder?, t: Data?, position: Int) {
        Glide.with(myContext!!).load(t!!.avatar).into(holder!!.getView<ImageView>(R.id.i_avatar))
        holder.getView<TextView>(R.id.t_nickname).text = position.toString()
        var lay_mp: MessagePicturesLayout = holder.getView(R.id.l_pictures)
//        var uriList = mutableListOf<Uri>()
//        t.imgList!!.forEach {
//            uriList.add(Uri.parse(it))
//        }
        lay_mp.set(t.pictureThumbList, t.pictureList)
        lay_mp.setCallback(mCallback)
        holder.itemView.setOnClickListener { Toast.makeText(myContext, position.toString(), Toast.LENGTH_SHORT).show() }
    }

    fun set(dataList: MutableList<Data>?) {
        list_data.clear()
        if (dataList != null) {
            list_data.addAll(dataList)
        }
        notifyDataSetChanged()
    }
}
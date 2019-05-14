package iam.lfc.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import com.github.ielse.imagewatcher.ImageWatcher
import com.github.ielse.imagewatcher.ImageWatcherHelper
import iam.lfc.myapplication.Share.Data
import iam.lfc.myapplication.base.BaseMain
import iam.lfc.myapplication.utils.Utils
import iam.lfc.myapplication.weight.CustomLoadingUIProvider2
import iam.lfc.myapplication.weight.DecorationLayout
import iam.lfc.myapplication.weight.GlideSimpleLoader
import iam.lfc.myapplication.weight.MessagePicturesLayout
import kotlinx.android.synthetic.main.activity_img_list.*

class ImgList_A : BaseMain(), MessagePicturesLayout.Callback {


    companion object {
        fun EnterThis(context: Context, string: String, int: Int) {
            var intent = Intent(context, ImgList_A().javaClass)
            intent.putExtra("Title", string)
            intent.putExtra("time", int)
            context.startActivity(intent)
        }

        var imgList = mutableListOf<String>()
        var list_data = mutableListOf<Data>()

    }

    var iwHelper: ImageWatcherHelper? = null
    var imgAdapter: MyAdapter? = null
    var isTranslucentStatus = false
    var layDecoration: DecorationLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
            window.navigationBarColor = Color.TRANSPARENT
            isTranslucentStatus = true
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_img_list)
        var title = intent.getStringExtra("Title")
        var time = intent.getIntExtra("time", 0)
        Log.d("--lfc", title + "  " + time)

        initView()
        initData()
    }

    private fun initData() {


        imgAdapter!!.set(Data.get())

        if (true)
            return

        /*  imgList.add(Const.ImgTest1)
          imgList.add(Const.ImgTest2)
          imgList.add(Const.ImgTest3)
          imgList.add(Const.ImgTest4)
          imgList.add(Const.ImgTest5)
          imgList.add(Const.ImgTest6)
          imgList.add(Const.ImgTest7)
          imgList.add(Const.ImgTest8)
          imgList.add(Const.ImgTest9)
          imgList.add(Const.ImgTest10)
          imgList.add(Const.ImgTest11)
          imgList.add(Const.ImgTest12)
          for (i in 0..9) {
              list_data.add(ImgData(Const.ImgTest1, i, imgList.subList(0, Random().nextInt(12))))
          }
          imgAdapter!!.set(list_data)*/
    }

    private fun initView() {
        imgAdapter = MyAdapter(this, R.layout.recycler_main_message, list_data)
        imgAdapter!!.mCallback = this
        layDecoration = DecorationLayout(this)
        rlv_iml.layoutManager = LinearLayoutManager(this)

        rlv_iml.adapter = imgAdapter
        //  **************  动态 addView   **************

        iwHelper = ImageWatcherHelper.with(this, GlideSimpleLoader()) // 一般来讲， ImageWatcher 需要占据全屏的位置
                .setTranslucentStatus(if (!isTranslucentStatus) Utils.calcStatusBarHeight(this) else 0) // 如果不是透明状态栏，你需要给ImageWatcher标记 一个偏移值，以修正点击ImageView查看的启动动画的Y轴起点的不正确
                .setErrorImageRes(R.mipmap.error_picture) // 配置error图标 如果不介意使用lib自带的图标，并不一定要调用这个API
                .setOnPictureLongPressListener { v, uri, pos ->
                    // 长按图片的回调，你可以显示一个框继续提供一些复制，发送等功能
                    Toast.makeText(v.context.applicationContext, "长按了第" + (pos + 1) + "张图片", Toast.LENGTH_SHORT).show()
                }
                .setOnStateChangedListener(object : ImageWatcher.OnStateChangedListener {
                    override fun onStateChangeUpdate(imageWatcher: ImageWatcher, clicked: ImageView, position: Int, uri: Uri, animatedValue: Float, actionTag: Int) {
                        Log.e("IW", "onStateChangeUpdate [$position][$uri][$animatedValue][$actionTag]")
                    }

                    override fun onStateChanged(imageWatcher: ImageWatcher, position: Int, uri: Uri, actionTag: Int) {
                        if (actionTag == ImageWatcher.STATE_ENTER_DISPLAYING) {
                            Toast.makeText(applicationContext, "点击了图片 [$position]$uri", Toast.LENGTH_SHORT).show()
                        } else if (actionTag == ImageWatcher.STATE_EXIT_HIDING) {
                            Toast.makeText(applicationContext, "退出了查看大图", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
                .setOtherView(layDecoration)
                .addOnPageChangeListener(layDecoration)
                .setLoadingUIProvider(CustomLoadingUIProvider2()) // 自定义LoadingUI


        layDecoration!!.attachImageWatcher(iwHelper)


        //  Utils.fitsSystemWindows(isTranslucentStatus, findViewById(R.id.v_fit));
    }

    override fun onThumbPictureClick(i: ImageView?, imageGroupList: SparseArray<ImageView>?, urlList: MutableList<Uri>?) {
        iwHelper!!.show(i, imageGroupList, urlList)
        fitsSystemWindow(this, layDecoration!!)
    }

    private fun fitsSystemWindow(activity: Activity, otherView: View) {
        var adjustByRoot = false
        val content = activity.findViewById<View>(android.R.id.content)
        if (content is ViewGroup) {
            val root = content.getChildAt(0)
            if (root != null) {
                val fitsSystemWindows = ViewCompat.getFitsSystemWindows(root)
                if (fitsSystemWindows) {
                    otherView.setPadding(root.paddingLeft, root.paddingTop, root.paddingRight, root.paddingBottom)
                    adjustByRoot = true
                }
            }
        }
        if (!adjustByRoot) {
            ViewCompat.requestApplyInsets(otherView)
        }
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v!!.id) {
            R.id.floatbtn -> {
                initData()
                imgAdapter!!.set(list_data)
            }
        }
    }


}

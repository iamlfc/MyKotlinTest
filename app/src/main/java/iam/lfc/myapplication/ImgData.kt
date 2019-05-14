package iam.lfc.myapplication

/**
 * Created by LFC
on 2019/5/14.
 */
class ImgData {

    var img: String = ""
    var index: Int = 0
    var imgList = mutableListOf<String>()

    constructor(img: String, index: Int, imgList: MutableList<String>) {
        this.img = img
        this.index = index
        this.imgList = imgList
    }
}
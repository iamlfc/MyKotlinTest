package iam.lfc.myapplication

/**
 * Created by LFC
on 2019/5/11.
 */
class CommonDataM {
    var value1: String = ""
    var value2: String = ""
    var value3: String = ""
    var value4: Int = 0

    constructor()
    constructor(value1: String, value2: String = "b", value3: String = "c", value4: Int) {
        this.value1 = value1
        this.value2 = value2
        this.value3 = value3
        this.value4 = value4
    }

}
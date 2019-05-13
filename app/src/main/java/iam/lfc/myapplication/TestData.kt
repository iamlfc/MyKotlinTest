package iam.lfc.myapplication

import java.io.Serializable

/**
 * Created by LFC
on 2019/5/11.
 */
data class CommonData(
        var `data`: Data,
        var code: Int,
        var msg: String
)

data class Data(
        var abnormal: String,
        var abnormalimg: String,
        var auth: String,
        var avatar: String,
        var beginaddress: String,
        var beginaliasname: String,
        var begincity: Int,
        var begindistrict: Int,
        var beginlat: String,
        var beginlng: String,
        var beginprovince: Int,
        var bjfwfprice: Int,
        var bupid: Int,
        var bupname: String,
        var buppaystatus: Int,
        var bxdimg: String,
        var bxdyxq: String,
        var charger: Int,
        var chargerData: ChargerData,
        var createtime: String,
        var cyz: String,
        var dahpimg: String,
        var device: String,
        var did: Int,
        var distance: Int,
        var driverid: Int,
        var driverphone: String,
        var emergency: Int,
        var emergencyData: EmergencyData,
        var endaddress: String,
        var endaliasname: String,
        var endcity: Int,
        var enddistrict: Int,
        var endlat: String,
        var endlng: String,
        var endprovince: Int,
        var enterprisename: String,
        var fwfprice: Int,
        var hgz: String,
        var id: Int,
        var ifoffline: Int,
        var img: String,
        var isauto: Int,
        var isblm: Int,
        var isdelete: Int,
        var isinvoice: Int,
        var isinvoiceb: Int,
        var jsz: String,
        var memberauth: String,
        var name: String,
        var newprice: String,
        var number: Int,
        var oldprice: String,
        var orderno: String,
        var overnumber: Int,
        var paystatus: Int,
        var phone: String,
        var pid: Int,
        var price: String,
        var processCurr: ProcessCurr,
        var processlist: List<Processlist>,
        var project: String,
        var servicePrice: Int,
        var sfzh: String,
        var status: Int,
        var strange: String,
        var strangelat: String,
        var strangelng: String,
        var transport_category: Int,
        var transport_category_title: String,
        var transportation_price: Int,
        var truckid: Int,
        var trucknumber: String,
        var txzimg: String,
        var type: Int,
        var ucharger: Int,
        var uid: Int,
        var updatetime: String,
        var upid: Int,
        var uppaystatus: Int,
        var valuation_method: Int,
        var valuation_method_title: String,
        var vehicle_type: Int,
        var vehicle_type_title: String,
        var volume: String,
        var weight: String,
        var xszimg: String,
        var yccl_address: String,
        var yccl_aliasname: String,
        var yccl_cljg: Int,
        var yccl_flag: Int,
        var yccl_lat: String,
        var yccl_lng: String,
        var yccl_priceflag: Int,
        var yccl_time: String,
        var yszimg: String
) : Serializable

data class EmergencyData(
        var id: Int,
        var name: String,
        var phone: String
)

data class ChargerData(
        var id: Int,
        var name: String,
        var phone: String
)

data class Processlist(
        var abnormal: String,
        var abnormalimg: String,
        var createtime: String,
        var id: Int,
        var orderid: Int,
        var status: Int,
        var strange: String,
        var strangelat: String,
        var strangelng: String,
        var uid: Int
)

data class ProcessCurr(
        var abnormal: String,
        var abnormalimg: String,
        var createtime: String,
        var id: Int,
        var orderid: Int,
        var status: Int,
        var strange: String,
        var strangelat: String,
        var strangelng: String,
        var uid: Int
) : Serializable
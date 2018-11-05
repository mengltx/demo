package com.pose.demo.common

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:10:05
 *
 * */

class RestultBody<T>{

    private val SUCCESS:Int = 1

    private val FAIL:Int = 0

    private val NO_PERMISSION  = 2

    var message:String ="success"
    get()=field
    set(message){
        field = message
    }

    var code:Int = SUCCESS
    get() = field
    set(code) {
        field = code
    }

     var data: T? =null
        get() = field
        set(data) {
            field = data
        }


}
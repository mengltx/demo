package com.pose.demo.dto

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/11/1
 * Time:16:53
 *
 * */
data class Result<T>(
        var recordCount:Int?=null,
        val success: Boolean,
        val message: String,
        var data:T?=null
)
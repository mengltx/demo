package com.pose.demo.dto

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/11/1
 * Time:16:25
 *
 * */

data class ProjectInDto(
        var page:Int?=null,
        var size:Int?=null,
        var orderby:String?=null,
        var direction:String?=null,
        var projectNum:String?=null,
        var projectName:String?=null
)
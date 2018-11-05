package com.pose.demo.dto

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:15:44
 *
 * */

data class RolePermissionDto(

        var roleId:Int?=null,

        var permissionId:Int?=null,

        var permissionName:String?=null,

        var description :String?=null,

        var url :String?=null,

        var pid:Int?=null

)
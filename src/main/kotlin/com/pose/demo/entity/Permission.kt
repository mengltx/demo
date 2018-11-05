package com.pose.demo.entity

import javax.persistence.*

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:15:20
 *
 * */
@Entity
@Table(name = "t_permission")
data class Permission(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var permissionId:Int?=null,

        var permissionName:String?=null,

        var permissionLabel:String?=null,
        var description :String?=null,

        var url :String?=null,

        var pid:Int?=null
)
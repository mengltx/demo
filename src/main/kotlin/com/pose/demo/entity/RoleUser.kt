package com.pose.demo.entity

import javax.persistence.*

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:12:04
 *
 * */
@Entity
@Table(name = "t_role_user")
data class RoleUser(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int?=null,

        var userId:Int?=null,

        var roleId:Int?=null
)
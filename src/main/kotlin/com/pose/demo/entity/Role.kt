package com.pose.demo.entity

import javax.persistence.*

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:12:02
 *
 * */

@Entity
@Table(name = "t_role")
data class Role(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var roleId:Int?=null,

        var roleName:String?=null
)
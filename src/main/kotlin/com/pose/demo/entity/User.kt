package com.pose.demo.entity

import java.util.*
import javax.persistence.*

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:9:57
 *
 * */

@Entity
@Table(name="t_user")
data class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Int?=null,
        var username:String?=null,
        var loginname:String?=null,
        var password:String?=null,
        var createDate: Date?=null,
        var email:String?=null,
        var tel:String?=null)


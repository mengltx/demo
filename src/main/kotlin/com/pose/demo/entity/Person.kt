package com.pose.demo.entity

import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Id

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/11/1
 * Time:10:35
 *
 * */

@Document(collection = "Person")
data class Person(
        @Id
        var id:String?=null,
        var name:String?=null
        )
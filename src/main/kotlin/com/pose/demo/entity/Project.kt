package com.pose.demo.entity

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
import javax.persistence.Id

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/11/1
 * Time:13:47
 *
 * */

@Document(collection = "Project")
data class Project(
        @Id
        var id:String?=null,
        var projectNum:String?=null,
        var projectName:String?=null,
        var biddingUnit:String?=null,
        var projectLock:Boolean?=null,
        var projectDesc:String?=null,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
        var createTime:Date?=null
)
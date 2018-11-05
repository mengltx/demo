package com.pose.demo.dao

import com.pose.demo.entity.Person
import org.springframework.data.mongodb.repository.MongoRepository

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/11/1
 * Time:10:46
 *
 * */
interface PersonRepository:MongoRepository<Person,Int>{


}
package com.pose.demo.dao

import com.pose.demo.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:10:25
 *
 * */
interface UserRepository: JpaRepository<User, Int>{

    fun findByusername(username:String):User
}
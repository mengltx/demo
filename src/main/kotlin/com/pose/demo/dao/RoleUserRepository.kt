package com.pose.demo.dao

import com.pose.demo.entity.Role
import com.pose.demo.entity.RoleUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:12:53
 *
 * */

interface RoleUserRepository:JpaRepository<RoleUser,Int>{



}
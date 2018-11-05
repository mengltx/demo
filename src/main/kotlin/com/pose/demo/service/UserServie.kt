package com.pose.demo.service

import com.pose.demo.dao.UserRepository
import com.pose.demo.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:10:27
 *
 * */

@Service
class UserService(){

    @Autowired
    lateinit var userRepository:UserRepository

    //新增
    fun addUser(user:User):User{

        return userRepository.save(user)
    }
    //删除
    fun delUser(user:User){

        var orginUser = userRepository.findById(user.id!!).get()
        userRepository.delete(orginUser);
    }

    //修改
    fun updateUser(user: User){
       // userRepository.
    }
    //根据ID 查询
    fun findById(userId:Int):User{
        return userRepository.findById(userId).get();
    }

    //查询全部
    fun findAll():List<User>{
        return userRepository.findAll();
    }

    //分页查询
}
package com.pose.demo.controller

import com.pose.demo.common.RestultBody
import com.pose.demo.dao.RoleRepository
import com.pose.demo.dao.RoleUserRepository
import com.pose.demo.entity.Role
import com.pose.demo.entity.User
import com.pose.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.*

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:10:05
 *
 * */


@RestController
class UserControler{

    @Autowired
    private lateinit var userService:UserService;

    @Autowired
    private lateinit var roleRepository: RoleRepository;

    /**
     * 根据ID 查询
     */
    @RequestMapping(value = "/user/{id}")
    fun getUser(@PathVariable id:Int):RestultBody<User>{
        var user = User(1,"管理员","admin","1234", Date(),"122343@12324.com","1233413456765")
        var resultBody = RestultBody<User>()
        resultBody.data = user
        return resultBody

    }
    @RequestMapping(value = "/role/{id}")
    fun getRole(@PathVariable id:Int):List<Role>{
       return  roleRepository.userRoles(id);
    }

    /**
     *新增
     */

    @RequestMapping(value = "/user/add",method = arrayOf(RequestMethod.POST))
    fun addUser(user: User):User{
        user.createDate=Date()
        return userService.addUser(user);
    }


    /**
     *删除
     */

    @RequestMapping(value = "/user/del",method = arrayOf(RequestMethod.DELETE))
    fun delUser(user: User){
        userService.delUser(user)
    }
}
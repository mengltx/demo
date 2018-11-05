package com.pose.demo.service.impl

import com.pose.demo.service.RbacService
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import javax.servlet.http.HttpServletRequest

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/29
 * Time:10:09
 *
 * */

class RbacServiceImpl:RbacService{
    override fun hasPermission(request: HttpServletRequest, authentication: Authentication) {

        val principal = authentication.principal
        val hasPermission : Boolean = false
        val username = (principal as UserDetails).username

        if (principal is UserDetails){
            val username  = (principal as UserDetails).username


            /**
             * 1.查询当前URL　所需要的权限
             * 2.查询用户拥有的权限
             * 3.做权限匹配
             */

            //当前用户的所有权限
            authentication.authorities
        }



    }

}
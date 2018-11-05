package com.pose.demo.service

import org.springframework.security.core.Authentication
import java.net.PasswordAuthentication
import javax.servlet.http.HttpServletRequest

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/29
 * Time:10:05
 *
 * */

interface RbacService{
    fun hasPermission(request:HttpServletRequest,authentication: Authentication)
}
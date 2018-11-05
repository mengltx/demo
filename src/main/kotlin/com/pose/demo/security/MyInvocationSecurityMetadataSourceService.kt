package com.pose.demo.security

import com.pose.demo.dao.PermissionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheConfig
import org.springframework.context.annotation.Configuration
import org.springframework.security.access.ConfigAttribute
import org.springframework.security.access.SecurityConfig
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource
import org.springframework.security.web.FilterInvocation
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.stereotype.Service


/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:16:27
 *
 * */

@Service
class MyInvocationSecurityMetadataSourceService : FilterInvocationSecurityMetadataSource {

    @Autowired
    lateinit var permissionRepository: PermissionRepository


    override fun getAllConfigAttributes(): MutableCollection<ConfigAttribute> {
        return mutableListOf()
    }

    override fun supports(clazz: Class<*>?): Boolean {
        return true
    }


    override fun getAttributes(`object`: Any?): MutableCollection<ConfigAttribute> {
        //val url = (`object` as FilterInvocation).requestUrl

        val request = (`object` as FilterInvocation).httpRequest
        //查询所有权限--可升级为缓存
        var permissions = permissionRepository.findAll()
        var permissionLabels = mutableSetOf<String>()
        var matcher: AntPathRequestMatcher?=null
        for (permission in permissions){
            matcher = AntPathRequestMatcher(permission.url)

            if(matcher.matches(request)){
                permissionLabels.add(permission.permissionLabel!!)
            }
        }

        println("当前拥有的权限$permissionLabels")

        var cas :MutableCollection<ConfigAttribute> = arrayListOf()

        for(permissionLabel in permissionLabels){
            cas.add(SecurityConfig(permissionLabel))
        }

        return cas


    }

}
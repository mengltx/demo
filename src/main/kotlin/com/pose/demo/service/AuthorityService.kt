package com.pose.demo.service

import com.pose.demo.dao.PermissionRepository
import com.pose.demo.dao.RoleRepository
import com.pose.demo.dao.UserRepository
import com.pose.demo.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.core.userdetails.User as SecurityUser

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:12:40
 *
 * */
class AuthorityService: UserDetailsService{


    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    lateinit var permissionRepository: PermissionRepository

    @Autowired
    private lateinit var roleRepository: RoleRepository

    override fun loadUserByUsername(username: String?): UserDetails {

        //查询用户
        var user:User = userRepository.findByusername(username!!)

        //查询用户角色
        var userRoles = roleRepository.userRoles(user.id!!)
        if(user == null){
            throw  UsernameNotFoundException("用户不存在")
        }
        //查询权限
        var roleIds :MutableList<Int?> = mutableListOf()
        for(role in userRoles){
            roleIds.add(role.roleId)
        }

        var permissions = permissionRepository.queryByRoles(roleIds)
        //将用户加入到authorities中
        var authorities:MutableList<SimpleGrantedAuthority> = mutableListOf()
        for(permission in permissions){
            authorities.add(SimpleGrantedAuthority("${permission.permissionLabel}"))
            println(permission)
        }

        return SecurityUser(user.username,user.password,authorities)

    }

}
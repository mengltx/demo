package com.pose.demo.entity

import javax.persistence.*

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:15:23
 *
 * */

@Entity
@Table(name="t_role_permission")
data class RolePermission(

        /**
         * 主键ID
         */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Int?=null,

        /**
         * 角色ID
         */
        var roleId:Int?=null,

        /**
         * 权限ID
         */
        var permissionId:Int?=null
)
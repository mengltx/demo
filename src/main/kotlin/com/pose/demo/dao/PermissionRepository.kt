package com.pose.demo.dao

import com.pose.demo.entity.Permission
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:15:57
 *
 * */

interface PermissionRepository : JpaRepository<Permission,Int>{

    @Query("select * from t_permission t1 inner join t_role_permission t2 on t1.permission_id = t2.permission_id where t2.role_id in ?1",nativeQuery = true)
    fun queryByRoles(roleIds:List<Int?>):List<Permission>

}
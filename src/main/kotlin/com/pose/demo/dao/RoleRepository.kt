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
 * Time:13:45
 *
 * */
interface RoleRepository : JpaRepository<Role, Int> {

    @Query("select t1.role_id,t1.role_name  from t_role t1 inner join t_role_user t2 on t1.role_id= t2.role_id where t2.user_id = :userId ",nativeQuery=true)
    fun userRoles(@Param("userId")userId: Int):List<Role>
}
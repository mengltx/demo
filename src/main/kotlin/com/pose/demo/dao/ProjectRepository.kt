package com.pose.demo.dao

import com.pose.demo.dto.ProjectInDto
import com.pose.demo.entity.Project
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.query.Param

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/11/1
 * Time:13:53
 *
 * */

interface ProjectRepository:MongoRepository<Project,String>{

    /**
     * 根据项目名称和项目编号查询
     */

    fun findByProjectNameOrProjectNum(projectName:String?,projectNum:String?):List<Project>
}
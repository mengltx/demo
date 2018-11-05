package com.pose.demo.service

import com.pose.demo.dto.ProjectInDto
import com.pose.demo.dto.Result
import com.pose.demo.entity.Person
import com.pose.demo.entity.Project
import java.lang.Exception

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/11/1
 * Time:13:54
 *
 * */
interface ProjectService{

    /**
     * add  new project
     */
    fun addProject(project:Project):Project

    fun  findProject(projectInDto: ProjectInDto): Result<List<Project>>

    fun recordCount():Long
}
package com.pose.demo.controller

import com.pose.demo.dto.ProjectInDto
import com.pose.demo.dto.Result
import com.pose.demo.entity.Project
import com.pose.demo.service.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.math.ceil

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/11/1
 * Time:14:05
 *
 * */

@RestController
@RequestMapping("/api/project")
class ProjectController{

    @Autowired
    lateinit var projectService: ProjectService

    @RequestMapping(value = "/add",method = arrayOf(RequestMethod.POST))
    fun addProject(@RequestBody project:Project):Project{

        println(project)
        project.createTime =Date()
        return projectService.addProject(project)
    }

    @GetMapping("/query")
    fun findProject( projectInDto:ProjectInDto ):Result<List<Project>>{

        println(projectInDto)

        return projectService.findProject(projectInDto)
    }
}
package com.pose.demo

import com.pose.demo.dao.PermissionRepository
import com.pose.demo.dao.PersonRepository
import com.pose.demo.dao.ProjectRepository
import com.pose.demo.entity.Person
import com.pose.demo.entity.Project
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class DemoApplicationTests {


    @Autowired
    lateinit var permissionRepository: PermissionRepository

    @Autowired
    lateinit var personRepository: PersonRepository

    @Autowired
    lateinit var projectRepository: ProjectRepository

    @Test
    fun contextLoads() {
    }

    @Test
    fun permissionForRoles(){

        var roleIds = arrayListOf<Int?>(1,3)
        var permissionForRoles =permissionRepository.queryByRoles(roleIds)


        for(permission in permissionForRoles){
            println(permission)
            println("${permission.permissionId}:${permission.permissionName}")
        }
    }

    @Test
    fun testMongo(){
        var project = Project()
        project.projectNum="0001"
        projectRepository.save(project)
    }

    @Test
    fun testGetMongo(){
        var project:List<Project> = projectRepository.findAll();

        println(project)
    }

}

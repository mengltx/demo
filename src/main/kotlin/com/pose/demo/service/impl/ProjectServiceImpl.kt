package com.pose.demo.service.impl

import com.pose.demo.dao.ProjectRepository
import com.pose.demo.dto.ProjectInDto
import com.pose.demo.dto.Result
import com.pose.demo.entity.Project
import com.pose.demo.service.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service
import java.util.regex.Pattern








/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/11/1
 * Time:13:54
 *
 * */
@Service
class ProjectServiceImpl: ProjectService{
    override fun recordCount():Long {
       return  projectRepository.count()
    }

    @Autowired
    private lateinit var mongoTemplate: MongoTemplate
    @Autowired
    lateinit var projectRepository: ProjectRepository

    override fun addProject(project: Project): Project{
        return projectRepository.save(project)
    }
    override fun findProject(projectInDto: ProjectInDto): Result<List<Project>> {

        //用来封装所有条件的对象
        var criteriaList = mutableListOf<Criteria>()

        //用来构建条件
        val query = Query()

        //项目编号
        if(!projectInDto.projectNum.isNullOrEmpty()){
            //val pattern = Pattern.compile("^.*"+projectInDto.projectNum+".*$", Pattern.CASE_INSENSITIVE)
            val pattern = Pattern.compile(".*?" + projectInDto.projectNum + ".*")
            criteriaList.add(Criteria.where("projectNum").regex(projectInDto.projectNum+"" ))
        }

        //项目名称
        if(!projectInDto.projectName.isNullOrEmpty()){
            val pattern = Pattern.compile("^.*"+projectInDto.projectName+".*$", Pattern.CASE_INSENSITIVE)
            criteriaList.add(Criteria.where("projectName").regex(pattern))
        }

        if(criteriaList.isNotEmpty()){
            query.addCriteria(Criteria().orOperator(*criteriaList.toTypedArray()))
        }

        //查询总页数
        val recordCount= mongoTemplate.find(query, Project::class.java).count()


        //设置排序
        val sort = if(!projectInDto.direction.isNullOrEmpty() && !projectInDto.orderby.isNullOrEmpty()){

            Sort(Sort.Direction.fromString(projectInDto.direction!!), "projectNum")

        }else{
            //设置默认排序
            Sort(Sort.Direction.DESC, "projectNum")
        }

        //分页+排序
        val pageable = PageRequest(projectInDto.page!!-1,projectInDto.size!!,sort)
        query.with(pageable)

        //查询
        var projectList = mongoTemplate.find(query, Project::class.java)

        return Result(recordCount,true,"success",projectList)
    }

}
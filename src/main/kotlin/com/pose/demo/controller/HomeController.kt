package com.pose.demo.controller

import com.pose.demo.common.Msg
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.ResponseBody



/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:14:17
 *
 * */

@Controller
class HomeController{

    @RequestMapping("/")
    fun index(model:Model):String{
        var  msg: Msg =   Msg("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "home";
    }

    @RequestMapping("/user/add")
    @ResponseBody
    fun hello(): String {
        return "hello admin + ni 可以新增用户"
    }


}
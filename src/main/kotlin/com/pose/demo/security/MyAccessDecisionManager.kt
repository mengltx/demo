package com.pose.demo.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.access.AccessDecisionManager
import org.springframework.security.access.ConfigAttribute
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:17:15
 *
 * */
@Service
class MyAccessDecisionManager: AccessDecisionManager {
    override fun decide(authentication: Authentication?, `object`: Any?, configAttributes: MutableCollection<ConfigAttribute>?) {
        if(null== configAttributes || configAttributes.isEmpty()) {
            return;
        }
        var c:ConfigAttribute
        var needRole:String
        configAttributes.iterator()
        var iter: MutableIterator<ConfigAttribute> = configAttributes.iterator()
        while(iter.hasNext()){
            c = iter.next()
            needRole = c.attribute

            for(ga in authentication!!.authorities){
                if(needRole.trim() == ga.authority){
                    return;
                }
            }
        }

        throw Exception("no right") as Throwable;

    }

    override fun supports(attribute: ConfigAttribute?): Boolean {
       return true
    }

    override fun supports(clazz: Class<*>?): Boolean {
        return true
    }

}
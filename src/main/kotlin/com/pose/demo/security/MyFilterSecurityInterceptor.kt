package com.pose.demo.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.access.SecurityMetadataSource
import org.springframework.security.access.intercept.AbstractSecurityInterceptor
import org.springframework.security.access.intercept.InterceptorStatusToken
import org.springframework.security.web.FilterInvocation
import org.springframework.stereotype.Service
import javax.servlet.*

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:16:24
 *
 * */

@Service
class  MyFilterSecurityInterceptor: AbstractSecurityInterceptor() , Filter {


    @Autowired
    private lateinit var securityMetadataSource: MyInvocationSecurityMetadataSourceService

    @Autowired
    fun setMyAccessDecisionManager(myAccessDecisionManager:MyAccessDecisionManager ){
        super.setAccessDecisionManager(myAccessDecisionManager)
    }

    override fun getSecureObjectClass(): Class<*> {
        return FilterInvocation::class.java
    }


    override fun obtainSecurityMetadataSource(): SecurityMetadataSource {
        return this.securityMetadataSource
    }

    override fun destroy() {
    }

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        var fi:FilterInvocation = FilterInvocation(request,response,chain)

        fi.chain.doFilter(request,response)
        //invoke(fi)
    }

    override fun init(filterConfig: FilterConfig?) {
    }


    fun invoke(fi:FilterInvocation){
        var token: InterceptorStatusToken =super.beforeInvocation(fi)
        try {
            fi.chain.doFilter(fi.request,fi.response)
        }finally {
            super.afterInvocation(token,null)
        }


    }


}
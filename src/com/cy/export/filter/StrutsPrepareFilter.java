package com.cy.export.filter;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class StrutsPrepareFilter extends StrutsPrepareAndExecuteFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) req;
        if(request.getRequestURL().toString().contains("/ws")){//默认情况下所有的webservice访问时都被struts2的这个拦截器给拦截了，所以
            //在监听到这个webservice的时候就放行
            chain.doFilter(req,res);
        }else {
            super.doFilter(req, res, chain);
        }

    }
}

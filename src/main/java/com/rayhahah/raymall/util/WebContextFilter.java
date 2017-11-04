package com.rayhahah.raymall.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/11/2
 * @fuction
 */
public class WebContextFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Headers","Authentication");

        filterChain.doFilter(servletRequest, response);
    }

    @Override
    public void destroy() {

    }
}

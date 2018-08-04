package com.gycheng.bootdemo.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Order(1)
@WebFilter(filterName = "log4jfilter", urlPatterns = "/*")
public class Log4jFilter implements Filter {
    private Logger logger;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger = LoggerFactory.getLogger(Log4jFilter.class);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        //TODO：用户ID
        String userId =  httpRequest.getRemoteUser();
        String ipAddr = httpRequest.getRemoteAddr();

        MDC.put("ip", ipAddr);
        MDC.put("uid", userId);
        logger.info(MDC.get("ip"));

        chain.doFilter(request, response);

        MDC.remove("ip");
        MDC.remove("uid");
    }

    @Override
    public void destroy() {

    }
}

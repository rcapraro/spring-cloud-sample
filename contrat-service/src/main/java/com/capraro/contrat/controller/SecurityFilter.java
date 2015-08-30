package com.capraro.contrat.controller;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * This filter displays a fake security header trasnmitted by Zuul.
 * Created by Richard Capraro on 30/08/2015.
 */
public class SecurityFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String header = ((HttpServletRequest) servletRequest).getHeader("X-Auth-Token");
        System.out.println("header = " + header);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

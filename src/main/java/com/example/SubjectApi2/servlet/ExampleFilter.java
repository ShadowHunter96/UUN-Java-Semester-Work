package com.example.SubjectApi2.servlet;

/**
 * Created by User: Vu
 * Date: 30.06.2024
 * Time: 11:59
 */
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ExampleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Filter logic here
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
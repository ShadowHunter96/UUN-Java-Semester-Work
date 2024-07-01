package com.example.SubjectApi2.servlet;

/**
 * Created by User: Vu
 * Date: 30.06.2024
 * Time: 12:03
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ExampleListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Initialization logic here
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Cleanup logic here
    }
}

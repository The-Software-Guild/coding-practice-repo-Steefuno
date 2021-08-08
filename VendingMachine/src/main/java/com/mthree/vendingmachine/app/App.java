/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 04 Aug 2021
 */

package com.mthree.vendingmachine.app;

import com.mthree.vendingmachine.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Steven
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext appContext;
        Controller controller;
        
        appContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        controller = appContext.getBean("controller", Controller.class);
        
        controller.run();
    }
}

package com.sg.booktracker;

import com.sg.booktracker.controller.BookController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Kyle David Rudy
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.sg.booktracker");
        appContext.refresh();

        BookController controller = appContext.getBean("bookController", BookController.class);
        controller.run();
    }
}

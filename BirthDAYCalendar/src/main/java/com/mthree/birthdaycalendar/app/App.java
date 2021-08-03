/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 03 Aug 2021
 */

package com.mthree.birthdaycalendar.app;

import com.mthree.birthdaycalendar.controller.Controller;
import com.mthree.birthdaycalendar.ui.View;
import com.mthree.birthdaycalendar.ui.UIConsoleImplementation;

/**
 * 
 * @author Steven
 */
public class App {
    public static void main(String[] args) {
        Controller controller;
        View view;
        UIConsoleImplementation ui;
        
        ui = new UIConsoleImplementation();
        view = new View(ui);
        controller = new Controller(view);
        
        controller.run();
    }
}

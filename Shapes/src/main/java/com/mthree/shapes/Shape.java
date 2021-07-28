/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 28 Jul 2021
 */
package com.mthree.shapes;

/**
 *
 * @author Steven
 */
abstract class Shape {
    String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    public abstract double getArea();
    public abstract double getPerimeter();
    
    public String getColor() {
        return this.color;
    }
}

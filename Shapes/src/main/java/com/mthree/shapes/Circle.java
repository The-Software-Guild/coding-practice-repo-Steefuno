/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 
 */
package com.mthree.shapes;

/**
 *
 * @author Steven
 */
public class Circle extends Shape {
    public static double PI = 3.141592;
    final private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    /**
     * Calculates the area of this circle
     * @return the perimeter of this circle
     */
    @Override
    public double getArea() {
        double area;
        
        area = PI * radius * radius;
        return area;
    }
    
    /**
     * Calculates the perimeter of this circle
     * @return the perimeter of this circle
     */
    @Override
    public double getPerimeter() {
        double perimeter;
        
        perimeter = 2 * PI * radius;
        return perimeter;
    }
}

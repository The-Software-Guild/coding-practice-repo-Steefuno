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
public class Rectangle extends Shape {
    final private double length;
    final private double width;
    
    /**
     * Constructs a new Rectangle given the color, length, and width
     * @param color     the color of this rectangle
     * @param length    the length of the tall side
     * @param width     the length of the wide side
     */
    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }
    
    /**
     * Calculates the area of this rectangle
     * @return the perimeter of this rectangle
     */
    @Override
    public double getArea() {
        double area;
        
        area = length * width;
        return area;
    }
    
    /**
     * Calculates the perimeter of this rectangle
     * @return the perimeter of this rectangle
     */
    @Override
    public double getPerimeter() {
        double perimeter;
        
        perimeter = 2 * (length + width);
        return perimeter;
    }
}

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
public class Square extends Shape {
    final private double length;
    
    /**
     * Constructs a new Square given the color and length
     * @param color     the color of this square
     * @param length    the length of one side
     */
    public Square(String color, double length) {
        super(color);
        this.length = length;
    }
    
    /**
     * Calculates the area of this square
     * @return the perimeter of this square
     */
    @Override
    public double getArea() {
        double area;
        
        area = length * length;
        return area;
    }
    
    /**
     * Calculates the perimeter of this square
     * @return the perimeter of this square
     */
    @Override
    public double getPerimeter() {
        double perimeter;
        
        perimeter = 4 * length;
        return perimeter;
    }
}

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
public class Triangle extends Shape {
    final private double sideA, sideB, sideC;
    
    /**
     * Constructs a new Triangle given the color and the length of the 3 sides
     * @param color     the color of the triangle
     * @param sideA     the length of sideA
     * @param sideB     the length of sideB
     * @param sideC     the length of sideC
     */
    public Triangle(String color, double sideA, double sideB, double sideC) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    /**
     * Calculates the area of this triangle
     * @return the perimeter of this triangle
     */
    @Override
    public double getArea() {
        double area, perimeter;
        
        perimeter = getPerimeter();
        area = Math.sqrt(perimeter * (perimeter - sideA) * (perimeter - sideB) * (perimeter - sideC));
        return area;
    }
    
    /**
     * Calculates the perimeter of this triangle
     * @return the perimeter of this triangle
     */
    @Override
    public double getPerimeter() {
        double perimeter;
        
        perimeter = sideA + sideB + sideC;
        return perimeter;
    }
}

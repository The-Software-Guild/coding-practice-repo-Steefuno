package com.sg.jdbctcomplexexample.entity;

import java.util.Objects;

/**
 *
 * @author kylerudy
 */
public class Employee {
    int id;
    String firstName;
    String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (obj.getClass() != Employee.class) {
            return false;
        }
        
        Employee other = (Employee) obj;
        return (other.getId() == id) &&
            (other.getFirstName().equals(firstName)) &&
            (other.getLastName().equals(lastName))
        ;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.firstName);
        hash = 67 * hash + Objects.hashCode(this.lastName);
        return hash;
    }
}

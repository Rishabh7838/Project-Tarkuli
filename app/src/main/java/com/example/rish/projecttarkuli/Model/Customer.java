package com.example.rish.projecttarkuli.Model;

public class Customer {
    public String Location;
    public String Name;

    public Customer(String location, String name) {
        Location = location;
        Name = name;
    }

    public Customer() {
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

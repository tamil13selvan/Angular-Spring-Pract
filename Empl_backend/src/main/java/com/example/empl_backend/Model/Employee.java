package com.example.empl_backend.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
    private String name;
    private String email;

    private String experience;
    private String tech;

    public Employee() {
    }

    public Employee(String name, String email, String designation, String experience, String tech) {
        this.name = name;
        this.email = email;
        this.experience = experience;
        this.tech = tech;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", experience='" + experience + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
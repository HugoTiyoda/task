package com.tracknme.task.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Employee extends AbstractEmployeeToGenerateId {


    private String gender;

    private Integer age; //mandatory
    private String name; //mandatory
    private String cep; //mandatory

    private String street;

    private String neighborhood;
    private String city;
    private String state;

    public Employee() {
    }

    public Employee(String name, String cep, Integer age) {
        this.name = name;
        this.cep = cep;
        this.age = age;
    }

    public Employee(String gender, Integer age, String name,
                    String cep, String street, String neighborhood,
                    String city, String state) {

        this.gender = gender;
        this.age = age;
        this.name = name;
        this.cep = cep;
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
    }


    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getCep() {
        return cep;
    }

    public String getStreet() {
        return street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }
}

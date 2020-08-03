package com.example.shinjitsu.entities;

public class StudentEntity {

    private String name;
    private int age;
    private String responsible;
    private String street;
    private String neighborhood;
    private String city;
    private String state;
    private int number;
    private String complement;
    private String cellphone;
    private String email;
    private String phone;
    private boolean disease;
    private boolean chronicDisease;
    private boolean surgery;
    private int id;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isDisease() {
        return disease;
    }

    public void setDisease(boolean disease) {
        this.disease = disease;
    }

    public boolean isChronicDisease() {
        return chronicDisease;
    }

    public void setChronicDisease(boolean chronicDisease) {
        this.chronicDisease = chronicDisease;
    }

    public boolean isSurgery() {
        return surgery;
    }

    public void setSurgery(boolean surgery) {
        this.surgery = surgery;
    }
}

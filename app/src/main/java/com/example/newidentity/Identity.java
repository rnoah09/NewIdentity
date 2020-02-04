package com.example.newidentity;

import java.lang.reflect.Array;

public class Identity {

    private String name;
    private String surname;
    private String gender;
    private String region;
    private String age;
    private String title;
    private String phone;
    private String email;
    private String password;
    private String photo;
    private Birthday birthday;
    private CreditCard credit_card;

    public Identity(){

    }
    public Birthday getBirthday() {
        return birthday;
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }

    public CreditCard getCreditCard() {
        return credit_card;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.credit_card = creditCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }



}

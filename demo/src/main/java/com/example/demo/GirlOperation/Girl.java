package com.example.demo.GirlOperation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Girl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer girlID;

    private Integer age;

    private String cupSize;

    private String email;

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getGirlID() {
        return girlID;
    }

    public void setGirlID(Integer girlID) {
        this.girlID = girlID;
    }


    public Girl(){

    }

    public Integer getAge() {
        return age;
    }

    public String getCupSize() {
        return cupSize;
    }



    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}

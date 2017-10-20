package com.test1;

import java.util.Date;

public class Users {
    private int id;
    private String name;
    private int age;
    private Date Birthday;

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }
    //必须要有一个空的构造函数，否则查询的时候返回结果类型时会报没有相应的构造函数错误。
    public Users()
    {

    }
    public Users(int id,String name,int age,Date birthday){
        this.id=id;
        this.name=name;
        this.age=age;
        this.Birthday=birthday;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", Birthday=" + Birthday +
                '}';
    }
}

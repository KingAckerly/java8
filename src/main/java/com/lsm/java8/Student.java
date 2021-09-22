package com.lsm.java8;

public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private boolean isPass;
    private Integer score;

    public Student() {
    }

    public Student(Integer id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Student(Integer id, String name, String sex, Integer age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Student(Integer id, String name, String sex, Integer age, boolean isPass) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isPass = isPass;
    }

    public Student(Integer id, String name, String sex, Integer age, boolean isPass, Integer score) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isPass = isPass;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public Student setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Student setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }

    public boolean isPass() {
        return isPass;
    }

    public Student setPass(boolean pass) {
        isPass = pass;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public Student setScore(Integer score) {
        this.score = score;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", isPass=" + isPass +
                ", score=" + score +
                '}';
    }
}

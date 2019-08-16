package com.aaa.group8.entity;

public class User {
    private  Integer bu_id;
    private String bu_username;
    private  String bu_password;
    private  String bu_sex;
    private  Long bu_tel;
    private String bu_address;
    private String bu_hiredate;
    private Integer br_id;
    private String br_name;

    public String getBr_name() {
        return br_name;
    }

    public void setBr_name(String br_name) {
        this.br_name = br_name;
    }

    public Integer getBr_id() {
        return br_id;
    }

    public void setBr_id(Integer br_id) {
        this.br_id = br_id;
    }

    public Integer getBu_id() {
        return bu_id;
    }

    public void setBu_id(Integer bu_id) {
        this.bu_id = bu_id;
    }

    public String getBu_username() {
        return bu_username;
    }

    public void setBu_username(String bu_username) {
        this.bu_username = bu_username;
    }

    public String getBu_password() {
        return bu_password;
    }

    public void setBu_password(String bu_password) {
        this.bu_password = bu_password;
    }

    public String getBu_sex() {
        return bu_sex;
    }

    public void setBu_sex(String bu_sex) {
        this.bu_sex = bu_sex;
    }

    public Long getBu_tel() {
        return bu_tel;
    }

    public void setBu_tel(Long bu_tel) {
        this.bu_tel = bu_tel;
    }

    public String getBu_address() {
        return bu_address;
    }

    public void setBu_address(String bu_address) {
        this.bu_address = bu_address;
    }

    public String getBu_hiredate() {
        return bu_hiredate;
    }

    public void setBu_hiredate(String bu_hiredate) {
        this.bu_hiredate = bu_hiredate;
    }

    @Override
    public String toString() {
        return "User{" +
                "bu_id=" + bu_id +
                ", bu_username='" + bu_username + '\'' +
                ", bu_password='" + bu_password + '\'' +
                ", bu_sex='" + bu_sex + '\'' +
                ", bu_tel=" + bu_tel +
                ", bu_address='" + bu_address + '\'' +
                ", bu_hiredate='" + bu_hiredate + '\'' +
                ", br_id=" + br_id +
                ", br_name='" + br_name + '\'' +
                '}';
    }
}

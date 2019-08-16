package com.aaa.group8.entity;


/**
 * 客户Admin表的实体类
 */
public class GAdmin {
    private Integer ba_id;
    private String ba_zhanghao;
    private String ba_password;
    private String ba_tel;

    public Integer getBa_id() {
        return ba_id;
    }

    public void setBa_id(Integer ba_id) {
        this.ba_id = ba_id;
    }

    public String getBa_zhanghao() {
        return ba_zhanghao;
    }

    public void setBa_zhanghao(String ba_zhanghao) {
        this.ba_zhanghao = ba_zhanghao;
    }

    public String getBa_password() {
        return ba_password;
    }

    public void setBa_password(String ba_password) {
        this.ba_password = ba_password;
    }

    public String getBa_tel() {
        return ba_tel;
    }

    public void setBa_tel(String ba_tel) {
        this.ba_tel = ba_tel;
    }

    @Override
    public String toString() {
        return "GAdmin{" +
                "ba_id=" + ba_id +
                ", ba_zhanghao='" + ba_zhanghao + '\'' +
                ", ba_password='" + ba_password + '\'' +
                ", ba_tel='" + ba_tel + '\'' +
                '}';
    }
}

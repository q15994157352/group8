package com.aaa.group8.entity;

public class MDome {
    private Integer id;
    private String type;
    private String dateline;
    private double money;
    private double money2;

    @Override
    public String toString() {
        return "MDome{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", dateline='" + dateline + '\'' +
                ", money=" + money +
                ", money2=" + money2 +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateline() {
        return dateline;
    }

    public void setDateline(String dateline) {
        this.dateline = dateline;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney2() {
        return money2;
    }

    public void setMoney2(double money2) {
        this.money2 = money2;
    }
}

package com.aaa.group8.entity;

public class LInformation {
    private Integer bci_id;
    private String bci_name;
    private String bci_type;
    private Integer bci_business;
    private String bci_bankcard;
    private String bdi_name;
    private String bdi_sex;
    private Integer bdi_tel;
    private Double bli_money;

    public Integer getBci_id() {
        return bci_id;
    }

    public void setBci_id(Integer bci_id) {
        this.bci_id = bci_id;
    }

    public String getBci_name() {
        return bci_name;
    }

    public void setBci_name(String bci_name) {
        this.bci_name = bci_name;
    }

    public String getBci_type() {
        return bci_type;
    }

    public void setBci_type(String bci_type) {
        this.bci_type = bci_type;
    }

    public String getBci_bankcard() {
        return bci_bankcard;
    }

    public void setBci_bankcard(String bci_bankcard) {
        this.bci_bankcard = bci_bankcard;
    }

    public String getBdi_name() {
        return bdi_name;
    }

    public void setBdi_name(String bdi_name) {
        this.bdi_name = bdi_name;
    }

    public Integer getBci_business() {
        return bci_business;
    }

    public void setBci_business(Integer bci_business) {
        this.bci_business = bci_business;
    }

    public String getBdi_sex() {
        return bdi_sex;
    }

    public void setBdi_sex(String bdi_sex) {
        this.bdi_sex = bdi_sex;
    }

    public Integer getBdi_tel() {
        return bdi_tel;
    }

    public void setBdi_tel(Integer bdi_tel) {
        this.bdi_tel = bdi_tel;
    }

    public Double getBli_money() {
        return bli_money;
    }

    public void setBli_money(Double bli_money) {
        this.bli_money = bli_money;
    }
    @Override
    public String toString() {
        return "LInformation{" +
                "bci_id=" + bci_id +
                ", bci_name='" + bci_name + '\'' +
                ", bci_type='" + bci_type + '\'' +
                ", bci_business=" + bci_business +
                ", bci_bankcard='" + bci_bankcard + '\'' +
                ", bdi_name='" + bdi_name + '\'' +
                ", bdi_sex='" + bdi_sex + '\'' +
                ", bdi_tel=" + bdi_tel +
                ", bli_money=" + bli_money +
                '}';
    }
}

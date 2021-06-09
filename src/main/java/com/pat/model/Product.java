package com.pat.model;

public class Product {
    int id;
    String name;
    int price;
    int amount;
    String detail;
    int cat_id;

    public Product() {
    }

    public Product(String name, int price, int amount, String detail, int cat_id) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.detail = detail;
        this.cat_id = cat_id;
    }

    public Product(int id, String name, int price, int amount, String detail, int cat_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.detail = detail;
        this.cat_id = cat_id;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }
}

package com.javaweb.session;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-16-22:36
 */
public class Customer {

    private String name;
    private String address;

    private String cardType;
    private String card;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Customer() {
    }

    public Customer(String name, String address, String cardType, String card) {
        this.name = name;
        this.address = address;
        this.cardType = cardType;
        this.card = card;
    }
}

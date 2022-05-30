package com.example.gdms;

public class Pay {

    // attributes
    private int payID;
    private String cardOwner;
    private String crdNumber;
    private String expDate;
    private String cvv;

    // default constructor
    public Pay() {
    }

    // parameterized constructor
    public Pay(int payID, String cardOwner, String crdNumber, String expDate, String cvv) {
        this.payID = payID;
        this.cardOwner = cardOwner;
        this.crdNumber = crdNumber;
        this.expDate = expDate;
        this.cvv = cvv;
    }

    // parameterized constructor
    public Pay(String cardOwner, String crdNumber, String expDate, String cvv) {
        this.cardOwner = cardOwner;
        this.crdNumber = crdNumber;
        this.expDate = expDate;
        this.cvv = cvv;
    }


    // getters & setters
    public int getPayID() {
        return payID;
    }

    public void setPayID(int payID) {
        this.payID = payID;
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner;
    }

    public String getCrdNumber() {
        return crdNumber;
    }

    public void setCrdNumber(String crdNumber) {
        this.crdNumber = crdNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}

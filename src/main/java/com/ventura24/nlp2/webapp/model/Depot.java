package com.ventura24.nlp2.webapp.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by josete on 3/1/15.
 */
public class Depot {

    private Long userId;
    private Date drawDate;
    private String product;
    private Status status;
    private BigDecimal amount;

    public Depot(){
        this.userId = null;
        this.drawDate = new Date();
        this.product = "";
        this.status = Status.En_Juego;
        this.amount = new BigDecimal(0);
    }

    public Depot(Long userId,Date drawDate, String product, Status status, BigDecimal amount) {
        this.userId = userId;
        this.drawDate = drawDate;
        this.product = product;
        this.status = status;
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(Date drawDate) {
        this.drawDate = drawDate;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

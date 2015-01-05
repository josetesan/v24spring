package com.ventura24.nlp2.webapp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jsanc on 5/01/15.
 */
public class GProduct implements Serializable
{

    private Long productId;
    private Long productTypeId;
    private Long bettorId;
    private Long bettorTypeId;
    private Long subscriptionId;
    private Long paymentStateId;
    private Long firstDrawId;
    private Long lastDrawId;
    private Long externalId;
    private BigDecimal amount;
    private Long duration;
    private Date lastModified;
    private Date creationDate;


    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public Long getBettorId()
    {
        return bettorId;
    }

    public void setBettorId(Long bettorId)
    {
        this.bettorId = bettorId;
    }

    public Long getBettorTypeId()
    {
        return bettorTypeId;
    }

    public void setBettorTypeId(Long bettorTypeId)
    {
        this.bettorTypeId = bettorTypeId;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public Long getDuration()
    {
        return duration;
    }

    public void setDuration(Long duration)
    {
        this.duration = duration;
    }

    public Long getExternalId()
    {
        return externalId;
    }

    public void setExternalId(Long externalId)
    {
        this.externalId = externalId;
    }

    public Long getFirstDrawId()
    {
        return firstDrawId;
    }

    public void setFirstDrawId(Long firstDrawId)
    {
        this.firstDrawId = firstDrawId;
    }

    public Long getLastDrawId()
    {
        return lastDrawId;
    }

    public void setLastDrawId(Long lastDrawId)
    {
        this.lastDrawId = lastDrawId;
    }

    public Date getLastModified()
    {
        return lastModified;
    }

    public void setLastModified(Date lastModified)
    {
        this.lastModified = lastModified;
    }

    public Long getPaymentStateId()
    {
        return paymentStateId;
    }

    public void setPaymentStateId(Long paymentStateId)
    {
        this.paymentStateId = paymentStateId;
    }

    public Long getProductId()
    {
        return productId;
    }

    public void setProductId(Long productId)
    {
        this.productId = productId;
    }

    public Long getProductTypeId()
    {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId)
    {
        this.productTypeId = productTypeId;
    }

    public Long getSubscriptionId()
    {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId)
    {
        this.subscriptionId = subscriptionId;
    }
}

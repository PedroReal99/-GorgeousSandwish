package com.isep.gorgeoussandwich.model;

import java.util.Date;

public class DeliveryDate {

    private Date deliveryDate;

    public DeliveryDate(){

    }

    public DeliveryDate(Date deliveryDate){
        this.deliveryDate=deliveryDate;
    }

    public Date getDeliveryDate(){
        return deliveryDate;
    }

    public void setDate(Date deliveryDate){ this.deliveryDate=deliveryDate; }

}

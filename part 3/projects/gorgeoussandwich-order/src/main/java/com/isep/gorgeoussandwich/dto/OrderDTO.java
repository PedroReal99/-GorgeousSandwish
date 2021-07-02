package com.isep.gorgeoussandwich.dto;

import com.isep.gorgeoussandwich.model.DeliveryDate;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class OrderDTO {

    private long userId;

    private Collection<Integer> sandwichIdCollection;

    private Collection<Integer> quantityCollection;

    private DeliveryDate deliveryDate;

    public OrderDTO(long userId,Collection<Integer> sandwichIdCollection,Collection<Integer> quantityCollection,DeliveryDate deliveryDate){
        this.userId=userId;
        this.sandwichIdCollection=sandwichIdCollection;
        this.quantityCollection=quantityCollection;
        /*Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.format(d);*/
        this.deliveryDate=deliveryDate;
    }

    public OrderDTO(){}

    public long getUserId(){
        return userId;
    }

    public void setUserId(long userId){ this.userId=userId; }

    public Collection<Integer> getSandwichIdCollection(){
        return sandwichIdCollection;
    }

    public void setSandwichIdCollection(Collection<Integer> sandwichIdCollection){ this.sandwichIdCollection=sandwichIdCollection; }

    public Collection<Integer> getQuantityCollection(){
        return quantityCollection;
    }

    public void setQuantityCollection(Collection<Integer> quantityCollection){ this.quantityCollection=quantityCollection; }

    public DeliveryDate getDeliveryDate(){
        return deliveryDate;
    }

    public void setDeliveryDate(DeliveryDate deliveryDate){ this.deliveryDate=deliveryDate; }

}

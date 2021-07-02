package com.isep.gorgeoussandwich.model;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "orderr")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="userId")
    private long userId;

    @ElementCollection
    private Collection<Integer> sandwichIdCollection;

    @ElementCollection
    private Collection<Integer> quantityCollection;

    @Column(name = "date")
    private Date deliveryDate;

    public Order(long userId,Collection<Integer> sandwichIdCollection,Collection<Integer> quantityCollection,Date deliveryDate){
        this.userId=userId;
        this.sandwichIdCollection=sandwichIdCollection;
        this.quantityCollection=quantityCollection;
        /*Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.format(d);
        this.date=d;*/
        this.deliveryDate=deliveryDate;
    }

    public Order(){}

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

    public Date getDeliveryDate(){
        return deliveryDate;
    }

    public void setDate(Date deliveryDate){ this.deliveryDate=deliveryDate; }

}

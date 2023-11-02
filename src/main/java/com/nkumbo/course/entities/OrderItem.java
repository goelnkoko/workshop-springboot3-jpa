package com.nkumbo.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nkumbo.course.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantitiy;
    private Double price;
    public OrderItem(){}

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        setProduct(product);
    }

    public OrderItem(Order order, Product product, Integer quantitiy, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantitiy = quantitiy;
        this.price = price;
    }

    public Integer getQuantitiy() {
        return quantitiy;
    }

    public void setQuantitiy(Integer quantitiy) {
        this.quantitiy = quantitiy;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
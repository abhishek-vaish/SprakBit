/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 11-06-2020
 *   Time: 11:24 AM
 */

package com.social.app.model;


import javax.persistence.*;

@Entity
@Table(name = "user_purchase_records")
public class UserPurchaseRecord {

    @Column(name = "integrients")
    private String integrients;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    @Id
    @Column(name = "id")
    private int userId;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "id")
    private UserRecords userRecords;


    public UserPurchaseRecord() {
    }

    @Override
    public String toString() {
        return "UserPurchaseRecord{" +
                ", integrients='" + integrients + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", userId=" + userId +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIntegrients() {
        return integrients;
    }

    public void setIntegrients(String integrients) {
        this.integrients = integrients;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

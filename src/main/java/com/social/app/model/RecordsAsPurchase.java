/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 14-06-2020
 *   Time: 11:27 AM
 */

package com.social.app.model;

import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.*;

@Entity
@Table(name = "user_records")
@SecondaryTable(name = "user_purchase_records", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class RecordsAsPurchase {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "integrients", table = "user_purchase_records")
    private String intregients;

    @Column(name = "quantity", table = "user_purchase_records")
    private Integer quantity;

    @Column(name = "price", table = "user_purchase_records")
    private Integer price;

    public RecordsAsPurchase() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntregients() {
        return intregients;
    }

    public void setIntregients(String intregients) {
        this.intregients = intregients;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 11-06-2020
 *   Time: 11:20 AM
 */

package com.social.app.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_records")
public class UserRecords {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private Double phoneNumber;

    @Column(name = "address")
    private String address;

    @OneToOne(mappedBy = "userRecords")
    private UserPurchaseRecord userPurchaseRecord;

    public UserRecords() {
    }

    @Override
    public String toString() {
        return "UserRecords{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                '}';
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

    public Double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserPurchaseRecord getUserPurchaseRecordList() {
        return userPurchaseRecord;
    }

    public void setUserPurchaseRecordList(UserPurchaseRecord userPurchaseRecord) {
        this.userPurchaseRecord = userPurchaseRecord;
    }
}

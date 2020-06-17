/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 11-06-2020
 *   Time: 05:26 AM
 */


package com.social.app.dao;

import com.social.app.model.RecordsAsPurchase;

import java.util.List;


public interface DAOInterface {

    void saveUser(RecordsAsPurchase recordsAsPurchase);

    List<RecordsAsPurchase> getUser();

    void delete(int id);

    List<RecordsAsPurchase> search(String firstName);



}

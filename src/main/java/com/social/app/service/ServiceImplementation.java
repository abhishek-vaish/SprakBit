/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 11-06-2020
 *   Time: 05:27 AM
 */

package com.social.app.service;

import com.social.app.dao.DAOInterface;
import com.social.app.dao.DAOInterface;
import com.social.app.model.RecordsAsPurchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceImplementation implements ServiceInterface {

    private DAOInterface daoInterface;

    @Autowired
    public ServiceImplementation(DAOInterface daoInterface) {
        this.daoInterface = daoInterface;
    }


    @Override
    @Transactional
    public void saveUser(RecordsAsPurchase recordsAsPurchase) {
        daoInterface.saveUser(recordsAsPurchase);
    }

    @Override
    @Transactional
    public List<RecordsAsPurchase> getUser() {
        return daoInterface.getUser();
    }

    @Override
    @Transactional
    public void delete(int id) {
        daoInterface.delete(id);
    }

    @Override
    @Transactional
    public List<RecordsAsPurchase> search(String firstName) {
        return daoInterface.search(firstName);
    }
}

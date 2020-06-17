/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 11-06-2020
 *   Time: 05:26 AM
 */

package com.social.app.dao;

import com.social.app.model.RecordsAsPurchase;
import com.social.app.model.UserPurchaseRecord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DAOImplementation implements DAOInterface {

    private EntityManager entityManager;

    @Autowired
    public DAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void saveUser(RecordsAsPurchase recordsAsPurchase) {
        Session session = entityManager.unwrap(Session.class);
        session.save(recordsAsPurchase);
    }

    @Override
    @Transactional
    public List<RecordsAsPurchase> getUser() {
        Session session = entityManager.unwrap(Session.class);
        Query<RecordsAsPurchase> recordsAsPurchaseQuery = session.createQuery("select u from RecordsAsPurchase u ", RecordsAsPurchase.class);
        List<RecordsAsPurchase> recordsAsPurchase = recordsAsPurchaseQuery.getResultList();
        return recordsAsPurchase;

    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        RecordsAsPurchase recordsAsPurchase = session.get(RecordsAsPurchase.class, id);
        session.delete(recordsAsPurchase);
    }

    @Override
    public List<RecordsAsPurchase> search(String firstName) {
        Session session = entityManager.unwrap(Session.class);
        Query<RecordsAsPurchase> query = session.createQuery("select r from RecordsAsPurchase r where r.firstName =: firstName", RecordsAsPurchase.class);
        List<RecordsAsPurchase> list = query.getResultList();
        return list;
    }
}

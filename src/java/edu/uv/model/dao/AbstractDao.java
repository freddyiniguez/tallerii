package edu.uv.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import java.util.List;
import org.hibernate.SessionFactory;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
public abstract class AbstractDao {
    public Session session;
    private Transaction tx;
    SessionFactory sf = null;
   
    public AbstractDao() {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
    }

    protected void save(Object obj) {
        try {
            startOperation();
            session.saveOrUpdate(obj);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            session.close();
        }
    }
    protected void update(Object obj) {
        try {
            startOperation();
            session.saveOrUpdate(obj);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            session.close();
        }
    }
    protected void delete(Class clazz,int id) {
        Object obj = null;
        try {
            startOperation();
            obj = session.load(clazz, id);
            session.delete(obj);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            session.close();
        }
    }
    
    protected Object find(Class clazz, int id) {
        Object obj = null;
        sf = HibernateUtil.getSessionFactory();
        sf.openSession();
        obj = session.get(clazz, id);
        session.close();
        if (obj!=null){

        }
        else
            return null;
        
        return obj;
    }

    protected List findAll(Class clazz) {
        List objects = null;
        try {
            startOperation();
            Query query = session.createQuery("from " + clazz.getName());
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            session.close();
        }
        return objects;
    }
    protected List costumQuery(Class clazz,String q) {
        List objects = null;
        try {
            startOperation();
            Query query = session.createQuery("from "+clazz.getName()+" "+q);
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            session.close();
        }
        return objects;
    }
    protected void handleException(HibernateException e) throws DataAccessLayerException  {
        tx.rollback();
        throw new DataAccessLayerException(e);
    }

    protected void startOperation() throws HibernateException {
        session = sf.openSession();
        tx = session.beginTransaction();
    }
}
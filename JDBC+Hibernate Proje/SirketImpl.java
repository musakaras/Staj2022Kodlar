package com.uniyaz.dao.impl;

import com.uniyaz.entity.Category;
import com.uniyaz.entity.Sirket;
import com.uniyaz.entity.Sube;
import com.uniyaz.helper.HibernateHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class SirketImpl {

    public List<Sirket> findAllSirket() {

        List<Sirket> sirketList = new ArrayList<Sirket>();
        try {
            Session session = HibernateHelper.getSessionFactory().openSession();
            String hql = "Select sube from Sube  sube LEFT JOIN sirket.sube sirket ";
            Query query = session.createQuery(hql);
            sirketList = query.list();
            return sirketList;

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Sirket addSirket(Sirket sirket) {
        try {
            Session session = HibernateHelper.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(sirket);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return sirket;
    }


    public Boolean deleteSirket(Long id) {
        try {
            Session session = HibernateHelper.getSessionFactory().openSession();
            Transaction transaction =  session.beginTransaction();
            //buradaki x hql için parametre anlamına gelir.
            String hql = "Delete From Sirket sirket Where sirket.id = :x";
            Query query = session.createQuery(hql);
            query.setParameter("x", id);
            int result = query.executeUpdate();
            transaction.commit();
            session.close();

            if (result > 0) {
                return Boolean.TRUE;
            }
            else {
                return Boolean.FALSE;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }


    public void deleteSirkteTwo(Sirket sirket) {
        try {
            Session session = HibernateHelper.getSessionFactory().openSession();
            Transaction transaction =  session.beginTransaction();
            session.delete(sirket);
            transaction.commit();
            session.close();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }


    public Sirket updateSirket(Sirket  sirket) {
        try {
            Session session = HibernateHelper.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Sirket selectedSirket =  session.get(Sirket.class,sirket.getId());
            selectedSirket.setName(sirket.getName());
            session.update(selectedSirket);
            transaction.commit();
            session.close();
            return selectedSirket;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
    


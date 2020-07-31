/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Conference;
import java.util.*;

/**
 *
 * @author Admin
 */

import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class ConferenceDAO {
    private Session session = null;
//    public static void main(String args[]){
//        List <Conference> l = getAll();
//        for (int i = 0; i < l.size(); i++)
//            System.out.println(l.get(i).getConferenceName());
//    }
    
//    public static List<Conference> getAll(){
    public List<Conference> getAll(){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            List<Conference> list = session.createCriteria(Conference.class).list();
            return list;
        } catch (HibernateException e){
            return null;
        } finally {
            session.close();
        }
    }
   public Conference getUserByID(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            List<Conference> list = null;
            list = session.createCriteria(Conference.class).add(Restrictions.eq("conference_id", id)).list();
            return list.get(0);
        }catch (HibernateException e) {
                return null;
        } finally {
            session.close();
        }
    }
}
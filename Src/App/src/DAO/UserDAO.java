/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.User;
import java.util.*;

/**
 *
 * @author Admin
 */

import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UserDAO {
    private Session session = null;
    
    public boolean save(User user){
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {              
            session.save(user);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }
    
//    public User checkExistUser(Conference conference, User user) {
//        session = HibernateUtil.getSessionFactory().openSession();
//        Attendance attendance = (Attendance) session.createCriteria(Attendance.class)
//                .add(Restrictions.and(Restrictions.eq("conference", conference),
//                        Restrictions.eq("user", user))).uniqueResult();
//        session.close();
//        return attendance;
//    }
    
    public String findNamebyID(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            List<User> list = null;
            list = session.createCriteria(User.class).add(Restrictions.eq("user_id", id)).list();
            if (list.size() == 0)
                return null;
            return list.get(0).getFirstName() + " " + list.get(0).getLastName();
        }catch (HibernateException e) {
            return String.valueOf(e);
        } finally {
            session.close();
        }
    }
    
    public Boolean checkPassword(String username, String generatedPassword){
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            List<User> list = null;
            list = session.createCriteria(User.class).add(Restrictions.eq("username", username)).list();
            String pw = "";
            if (list.size() != 0)
                pw = list.get(0).getPassword();
            if (pw.equals(generatedPassword))
                return true;
            return false;
        }catch (HibernateException e) {
//            return String.valueOf(e);
                return false;
        } finally {
            session.close();
        }
    }
}

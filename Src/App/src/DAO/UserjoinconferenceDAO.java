/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.*;
import model.Userjoinconference;
import model.Conference;

/**
 *
 * @author Admin
 */

import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class UserjoinconferenceDAO {
     private Session session = null;
     
     public String getListAttendance(Conference cf){
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("Viet Anh");
        try {
                System.out.println("Viet Anh");
                String Attendances = null;
                List<Userjoinconference> list = session.createCriteria(Userjoinconference.class).add(Restrictions.eq("conference", cf)).list();
                System.out.println(list.size());
                for (int i = 0; i < list.size(); i++){
                    if (Attendances == null)
                        Attendances = list.get(i).getUser().getLastName() + " " + list.get(i).getUser().getFirstName();
                    else
                        Attendances += ", " + list.get(i).getUser().getLastName() + " " + list.get(i).getUser().getFirstName() + " " ;
                }
                System.out.println(Attendances);
                return Attendances;
            } catch (HibernateException e) {
                System.out.println(String.valueOf(e));
                return String.valueOf(e);
            } finally {
                session.close();
        }
     }
     
}

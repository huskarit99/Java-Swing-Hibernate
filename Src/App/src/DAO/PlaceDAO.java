/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Place;
import java.util.*;
/**
 *
 * @author Admin
 */

import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class PlaceDAO {
    private Session session = null;
    
//    public String getPlaceName(){
//        try{
//            session = HibernateUtil.getSessionFactory().openSession();
//            String name = session.createCriteria(Place.class).add(Restrictions.eq("place_id", id)).toString();
//            return name;
//            
//        } catch (HibernateException e){
//            return null;
//        } finally {
//            session.close();
//        }
//    }
}

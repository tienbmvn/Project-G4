/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g4.east2west.model;

import g4.east2west.hibernate.objectl.PackageTours;
import g4.east2west.hibernate.objectl.TypePackage;
import g4.east2west.hibernate.until.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Tien
 */
public class DataManager {

    private Session sf;
    List<PackageTours> listItem;

    public DataManager() {
        sf = HibernateUtil.getSessionFactory().openSession();
        listItem = new ArrayList<>();
    }

    public List<PackageTours> getListATC() {
        String hql = "FROM PackageTours P WHERE P.typePackage = 'ATC' ORDER BY NEWID()";
        Query query = sf.createQuery(hql);
        listItem = query.setMaxResults(7).list();

        return listItem;
    }

    public List<PackageTours> getListCWT() {
        String hql = "FROM PackageTours P  WHERE P.typePackage = 'CWT' ORDER BY NEWID()";
        Query query = sf.createQuery(hql);
        listItem = query.setMaxResults(7).list();
        return listItem;
    }

    public TypePackage findTypePackage(String id) {
        sf.beginTransaction();
        TypePackage type = (TypePackage) sf.get(TypePackage.class, id);
        sf.getTransaction().commit();
        return type;
    }

    public List<PackageTours> getListPHS() {
        String hql = "FROM PackageTours P WHERE P.typePackage = 'PHS' ORDER BY NEWID()";
        Query query = sf.createQuery(hql);
        listItem = query.setMaxResults(7).list();
        return listItem;
    }

    public List<PackageTours> getListPackage(String type) {
        String hql = "FROM PackageTours P WHERE P.typePackage =" + "'" + type + "'";
        Query query = sf.createQuery(hql);
        listItem = query.list();
        return listItem;
    }
    
    public List<PackageTours> getListPackageByContry(String country) {
        String hql = "FROM PackageTours P WHERE P.touristPlace =" + "'" + country +"'";
        Query query = sf.createQuery(hql);
        listItem = query.list();
        return listItem;
    }
    
      public List<PackageTours> getListPackageAll(String country,String type,int price) {
        String hql = "FROM PackageTours P WHERE P.typePackage =" + "'" + type + "' AND "+"P.touristPlace="+"'"+country+"' AND "+"P.tourisPrice<"+price;
        Query query = sf.createQuery(hql);
        listItem = query.list();
        return listItem;
    }
      
  
}

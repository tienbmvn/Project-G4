/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g4.east2west.model;

import g4.east2west.hibernate.objectl.PackageTours;
import g4.east2west.hibernate.until.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tien
 */
public class Test {

    private Session sf;
    List<PackageTours> listItem;
    public Test() {
         sf = HibernateUtil.getSessionFactory().openSession();
          listItem = new ArrayList<>();
    }

    public static void main(String[] args) {
//        System.out.println(new Test().getRowCount()+"");
//        List<PackageTours> ls = new Test().getListProduct();
//        for (PackageTours object : ls) {
//            System.out.println(object.getTouristName());
//        }
        
        DataManager mn = new DataManager();
        List<PackageTours> ls = mn.getListPackage("PHS");
        for (PackageTours object : ls) {
            System.out.println(object.getTouristPlace());
            System.out.println(object.getCityCountry());
        }
    }

   public List<PackageTours> getListProduct() {
        Transaction tx = sf.beginTransaction();
        listItem = sf.createCriteria(PackageTours.class).list();
        tx.commit();
        sf.close();
        return listItem;
    }

    public int getRowCount() {
        Query q = sf.createQuery("from PackageTours");
        List<PackageTours> ls = q.list();
        System.out.println("Row count is" + ls.size());
        return ls.size();
    }
}

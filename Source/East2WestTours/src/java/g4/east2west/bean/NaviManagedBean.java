/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package g4.east2west.bean;

import g4.east2west.hibernate.objectl.PackageTours;
import g4.east2west.hibernate.objectl.TypePackage;
import g4.east2west.model.DataManager;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author Tien
 */
@ManagedBean
@SessionScoped
public class NaviManagedBean {

    private DataManager manager;
    private List<PackageTours> listPk;
    private TypePackage nameType;

   

   
    public TypePackage getNameType() {
        return nameType;
    }

    public void setNameType(TypePackage nameType) {
        this.nameType = nameType;
    }
    
//    @ManagedProperty(value="#{param.type}")
//    private String type;
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
      
    public List<PackageTours> getListPk() {
        return listPk;
    }

    public void setListPk(List<PackageTours> listPk) {
        this.listPk = listPk;
    }
    
    public NaviManagedBean() {
        manager = new DataManager();
      
    }
    
//    public String naviPackage(String type){
//        listPk=manager.getListPackage(type);
//        return "list.xhtml";
//    }
      public String naviPackage(String type){
        listPk=manager.getListPackage(type);
        nameType = manager.findTypePackage(type);
        return "list?faces-redirect=true";
    }
      
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package g4.east2west.bean;

import g4.east2west.hibernate.objectl.PackageTours;
import g4.east2west.model.DataManager;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Tien
 */
@ManagedBean
@RequestScoped
public class NaviManagedBean {

    private DataManager manager;
    private List<PackageTours> listPk;
      @ManagedProperty(value="#{param.type}")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
      
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
      public List<PackageTours> naviPackage(){
        listPk=manager.getListPackage(type);
        return listPk;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g4.east2west.bean;

import g4.east2west.hibernate.objectl.PackageTours;
import g4.east2west.model.DataManager;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Tien
 */
@ManagedBean
@SessionScoped
public class SeachManagedBean {

    private String country;
     private String countryIndex;
    private String type;
    private String name;
    private String price;
    private List<PackageTours> list;
    private List<PackageTours> listDefault;
    private DataManager manager;
    private List<PackageTours> lsNew;

    public String getCountry() {
        return country;
    }

    public String getCountryIndex() {
        return countryIndex;
    }

    public void setCountryIndex(String countryIndex) {
        this.countryIndex = countryIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PackageTours> getList() {
        return list;
    }

    public void setList(List<PackageTours> list) {
        this.list = list;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public SeachManagedBean() {
        manager = new DataManager();
        lsNew = new ArrayList<>();
    }

    public String listPackage() {
        list = manager.getListPackageAll(country, type, Integer.parseInt(price));
        listDefault=list;
        return "listpackage?faces-redirect=true";
    }

    public void listPackageS() {
        list = manager.getListPackageAll(country, type, Integer.parseInt(price));
        listDefault=list;
    }

    public void findPackageByName() {
        list = listDefault;
        if(!lsNew.isEmpty()){
            lsNew.clear();
        }
        for (PackageTours packageTours : list) {
            if (packageTours.getTouristName().contains(name)) {
                lsNew.add(packageTours);
            }
        }
        list = lsNew;

    }
 public String findPackageContry() {
        list= manager.getListPackageByContry(countryIndex);
        return "listpackage?faces-redirect=true";

    }
}

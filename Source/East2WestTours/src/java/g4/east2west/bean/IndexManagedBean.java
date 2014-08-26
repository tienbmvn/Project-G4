/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g4.east2west.bean;

import g4.east2west.hibernate.objectl.PackageTours;
import g4.east2west.model.DataManager;
import java.util.List;

/**
 *
 * @author Tien
 */
public class IndexManagedBean {

    private DataManager manager;

    /**
     * Creates a new instance of IndexManagedBean
     */
    public IndexManagedBean() {
        manager = new DataManager();
    }

    public List<PackageTours> listATC() {
        return manager.getListATC();
    }

    public List<PackageTours> listCWT() {
        return manager.getListCWT();
    }

    public List<PackageTours> listPHS() {
        return manager.getListPHS();
    }
}

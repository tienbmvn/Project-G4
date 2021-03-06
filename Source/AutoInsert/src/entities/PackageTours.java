package entities;
// Generated Aug 25, 2014 11:51:24 AM by Hibernate Tools 3.6.0


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * PackageTours generated by hbm2java
 */
public class PackageTours  implements java.io.Serializable {


     private int touristId;
     private String typePackage;
     private String touristName;
     private String touristPlace;
       private String cityCountry;
     private String touristDescription;
     private int tourisPrice;
     private String tourisDuration;
     private String imagesTouris;
     private Set packageInfos = new HashSet(0);

    public PackageTours() {
    }

	
    public PackageTours(int touristId, String typePackage, String touristName, String touristPlace, String touristDescription, int tourisPrice, String tourisDuration) {
        this.touristId = touristId;
        this.typePackage = typePackage;
        this.touristName = touristName;
        this.touristPlace = touristPlace;
        this.touristDescription = touristDescription;
        this.tourisPrice = tourisPrice;
        this.tourisDuration = tourisDuration;
    }
    public PackageTours(int touristId, String typePackage, String touristName, String touristPlace, String touristDescription, int tourisPrice, String tourisDuration, String imagesTouris, Set packageInfos) {
       this.touristId = touristId;
       this.typePackage = typePackage;
       this.touristName = touristName;
       this.touristPlace = touristPlace;
       this.touristDescription = touristDescription;
       this.tourisPrice = tourisPrice;
       this.tourisDuration = tourisDuration;
       this.imagesTouris = imagesTouris;
       this.packageInfos = packageInfos;
    }

    public String getCityCountry() {
        return cityCountry;
    }

    public void setCityCountry(String cityCountry) {
        this.cityCountry = cityCountry;
    }
   
    public int getTouristId() {
        return this.touristId;
    }
    
    public void setTouristId(int touristId) {
        this.touristId = touristId;
    }
    public String getTypePackage() {
        return this.typePackage;
    }
    
    public void setTypePackage(String typePackage) {
        this.typePackage = typePackage;
    }
    public String getTouristName() {
        return this.touristName;
    }
    
    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }
    public String getTouristPlace() {
        return this.touristPlace;
    }
    
    public void setTouristPlace(String touristPlace) {
        this.touristPlace = touristPlace;
    }
    public String getTouristDescription() {
        return this.touristDescription;
    }
    
    public void setTouristDescription(String touristDescription) {
        this.touristDescription = touristDescription;
    }
    public int getTourisPrice() {
        return this.tourisPrice;
    }
    
    public void setTourisPrice(int tourisPrice) {
        this.tourisPrice = tourisPrice;
    }
    public String getTourisDuration() {
        return this.tourisDuration;
    }
    
    public void setTourisDuration(String tourisDuration) {
        this.tourisDuration = tourisDuration;
    }
    public String getImagesTouris() {
        return this.imagesTouris;
    }
    
    public void setImagesTouris(String imagesTouris) {
        this.imagesTouris = imagesTouris;
    }
    public Set getPackageInfos() {
        return this.packageInfos;
    }
    
    public void setPackageInfos(Set packageInfos) {
        this.packageInfos = packageInfos;
    }




}



/**
 * Created by nashm on 29/03/2017.
 */
import javax.persistence.*;
@Entity
@Table (name="geocitiesdata")
public class citydata {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "country")
    private String country;
    @Column(name = "region")
    private String region;
    @Column(name = "city")
    private String city;
    @Column(name = "lattitude")
    private String latitude;
    @Column(name = "longitude")
    private String longitude;

    public citydata(int id, String co, String re, String ci, String pc, float lat1, float v){}

    public citydata(int id, String co, String re, String ci, String lat, String lon){
        this.id = id;
        this.country = co;
        this.region = re;
        this.city = ci;
        this.latitude = lat;
        this.longitude = lon;
    }


/***********Setters********************/

    public void setId(int newid){
        this.id = newid;
    }
    public void setCountry(String co){
        this.country = co;
    }

    public void setRegion(String re){
        this.region = re;
    }

    public void setCity(String ci){
        this.city = ci;
    }



    public void setLatitude(String la){
        this.latitude = la;
    }

    public void setLongitude(String lo){
        this.longitude = lo;
    }


/*************************************/

/**************Getters****************/
    public int getId(){
        return id;
    }

    public String getCountry(){
        return country;
    }

    public String getRegion(){
        return region;
    }

    public String getCity(){
        return city;
    }

    public String getLatitude(){
        return latitude;
    }

    public String getLongitude(){
        return longitude;
    }

/*************************************/
}

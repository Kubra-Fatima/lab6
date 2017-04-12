/**
 * Created by Hp-pc on 4/5/2017.
 */
public class Citiesdata {
    private int id;
    private String country;
    private String region;
    private String city;
    // private String postalCode;
    private String latitude;
    private String longitude;
    // private String metroCode;
    // private String areaCode;

    public String getcountry() {
        return country;
    }

    public void setcountry(String country) {
        this.country = country;
    }

    public String getregion() {
        return region;
    }

    public void setregion(String region) {
        this.region = region;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getcity() {
        return city;
    }

    public void setcity(String city) {
        this.city = city;
    }

   /* public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }*/

    public String getlatitude() {
        return latitude;
    }

    public void setlatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getlongitude() {
        return longitude;
    }

    public void setlongitude(String longitude) {
        this.longitude = longitude;
    }

}

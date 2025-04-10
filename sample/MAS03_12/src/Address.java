import java.io.Serializable;

public class Address implements Serializable {
    private String street;
    private String city;
    private String zip;

    public Address(String street, String city, String zip) {
        setStreet(street);
        setCity(city);
        setZip(zip);
    }

    public void setCity(String city) {
        if(city == null || city.isBlank()){
            throw new IllegalArgumentException("City cannot be null or blank");
        }
        this.city = city;
    }

    public void setZip(String zip) {
        if(zip == null || zip.isBlank()){
            throw new IllegalArgumentException("Zip cannot be null or blank");
        }
        this.zip = zip;
    }

    public void setStreet(String street) {
        if(street == null || street.isBlank()){
            throw new IllegalArgumentException("Street cannot be null or blank");
        }
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }
}

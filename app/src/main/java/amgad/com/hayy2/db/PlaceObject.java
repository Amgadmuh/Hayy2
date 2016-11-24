package amgad.com.hayy2.db;


/**
 * Created by Amgad on 21-Nov-16.
 */

//custom object for place, gonna have all the fields and methods needed to operate on a given place
public class PlaceObject {

    private String type;
    private String name;
    private String description;
    private String commissionedBy;
    private String dateHijriFrom;
    private String dateHijriTo;
    private String dateGregorianFrom;
    private String dateGregorianTo;
    private String imageName;
    private String latitude;
    private String longitude;

    //constructor for when I only want to instantiate the name and type
    //better performance
    public PlaceObject(String type, String name) {
        this.type = type;
        this.name = name;
    }

    // full constructor
    public PlaceObject(String type, String name,String description, String commissionedBy,
                       String dateHijriFrom,  String dateHijriTo, String dateGregorianFrom,
                       String dateGregorianTo, String imagePath, String latitude, String longitude) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.commissionedBy = commissionedBy;
        this.dateHijriFrom = dateHijriFrom;
        this.dateHijriTo = dateHijriTo;
        this.dateGregorianFrom = dateGregorianFrom;
        this.dateGregorianTo = dateGregorianTo;
        this.imageName = imagePath;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public String getType() {
        return type;
    }

    public void setType(String word) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getCommissionedBy() {
        return commissionedBy;
    }

    public String getDateHijriFrom() {
        return dateHijriFrom;
    }

    public String getDateHijriTo() {
        return dateHijriTo;
    }

    public String getDateGregorianFrom() {
        return dateGregorianFrom;
    }

    public String getDateGregorianTo() {
        return dateGregorianTo;
    }

    public String getImageName() {return imageName;}
    public String getLatitude() {return latitude;}

    public String getLongitude() {return longitude;}

}

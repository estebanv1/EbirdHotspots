package co.ebird.hotspot.models;

public class BirdData {

    private String strName;
    private String strObservations;
    private String strPhotos;
    private String strSounds;
    private String strDate;

    public BirdData(String strName, String strObservations, String strPhotos, String strSounds) {
        this.strName = strName;
        this.strObservations = strObservations;
        this.strPhotos = strPhotos;
        this.strSounds = strSounds;
    }

    public BirdData(String strName, String strObservations, String strPhotos, String strSounds, String strDate) {
        this.strName = strName;
        this.strObservations = strObservations;
        this.strPhotos = strPhotos;
        this.strSounds = strSounds;
        this.strDate = strDate;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrObservations() {
        return strObservations;
    }

    public void setStrObservations(String strObservations) {
        this.strObservations = strObservations;
    }

    public String getStrPhotos() {
        return strPhotos;
    }

    public void setStrPhotos(String strPhotos) {
        this.strPhotos = strPhotos;
    }

    public String getStrSounds() {
        return strSounds;
    }

    public void setStrSounds(String strSounds) {
        this.strSounds = strSounds;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }
}

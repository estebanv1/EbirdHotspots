package co.ebird.hotspot.models;

public class BirdData {

    private String name;
    private String observations;
    private String photos;
    private String sounds;
    private String date;

    public BirdData(String name, String observations, String photos, String sounds, String date) {
        this.name = name;
        this.observations = observations;
        this.photos = photos;
        this.sounds = sounds;
        this.date = date;
    }

    public BirdData() {
    }

    public String getName() {
        return name;
    }

    public String getObservations() {
        return observations;
    }

    public String getPhotos() {
        return photos;
    }

    public String getSounds() {
        return sounds;
    }

    public String getDate() {
        return date;
    }
}

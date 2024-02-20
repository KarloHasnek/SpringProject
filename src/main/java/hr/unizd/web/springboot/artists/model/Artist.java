package hr.unizd.web.springboot.artists.model;

public class Artist {

    private Integer id;
    private String name;
    private String album;
    private String iconLocation;

    public Artist() {
    }

    public Artist(Integer id, String name, String album, String iconLocation) {
        this.id = id;
        this.name = name;
        this.album = album;
        this.iconLocation = iconLocation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getIconLocation() {
        return iconLocation;
    }

    public void setIconLocation(String iconLocation) {
        this.iconLocation = iconLocation;
    }
}

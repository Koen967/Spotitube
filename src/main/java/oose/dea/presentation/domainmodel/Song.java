package oose.dea.presentation.domainmodel;

/**
 * Created by koen on 24-3-2017.
 */
public class Song extends Track {
    private String album;

    public Song(String performer, String title, String url, int duration, String album) {
        super(performer, title, url, duration);
        this.album = album;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void getPlayCount(){}

    public void getPublicationDatePrintable(){}

    public void getDescription(){}

}

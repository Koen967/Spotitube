package oose.dea.presentation.domainmodel;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by koen on 24-3-2017.
 */
public class Video extends Track {
    private int playCount;
    private Calendar publicationDate;
    private String description;

    public Video(String performer, String title, String url, int duration, int playCount, Calendar publicationDate, String description) {
        super(performer, title, url, duration);
        this.playCount = playCount;
        this.publicationDate = publicationDate;
        this.description = description;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public Calendar getPublicationDate() {
        return publicationDate;
    }

    public String getPublicationDatePrintable() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        return sdf.format(publicationDate.getTime());
    }

    public void setPublicationDate(Calendar publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void getAlbum(){}
}

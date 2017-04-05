package oose.dea.presentation.domainmodel;

/**
 * Created by koen on 24-3-2017.
 */
public class Track {
    private String performer;
    private String title;
    private String url;
    private int duration;
    private boolean offlineAvailable;

    public Track(String performer, String title, String url, int duration) {
        this.performer = performer;
        this.title = title;
        this.url = url;
        this.duration = duration;
    }

    public void toggle() {
        this.setOfflineAvailable(!offlineAvailable);
    }

    public boolean isOfflineAvailable() {
        return this.offlineAvailable;
    }

    public void setOfflineAvailable(boolean offlineAvailable) {
        this.offlineAvailable = offlineAvailable;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

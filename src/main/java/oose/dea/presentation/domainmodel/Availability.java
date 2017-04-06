package oose.dea.presentation.domainmodel;

/**
 * Created by koen on 24-3-2017.
 */
public class Availability {
    private boolean offlineAvailable;
    private Track track;

    public Availability(boolean offlineAvailable, Track track) {
        this.offlineAvailable = offlineAvailable;
        this.track = track;
    }

    public void toggle() {
        this.offlineAvailable = !offlineAvailable;
    }

    public boolean isOfflineAvailable() {
        return offlineAvailable;
    }

    public void setOfflineAvailable(boolean offlineAvailable) {
        this.offlineAvailable = offlineAvailable;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}

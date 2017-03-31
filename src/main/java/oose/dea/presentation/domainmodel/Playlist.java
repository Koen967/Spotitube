package oose.dea.presentation.domainmodel;

import java.util.ArrayList;

/**
 * Created by koen on 24-3-2017.
 */
public class Playlist {
    private String ownerName;
    private String playlistName;
    private ArrayList<Availability> availabilities = new ArrayList<Availability>();

    public Playlist(String ownerName, String playlistName) {
        this.ownerName = ownerName;
        this.playlistName = playlistName;
    }

    public void addTrack(Track track) {
        //TODO IMPLEMENT
        //Object doorsturen naar de service met de taak addTrack
    }

    public void changeName(String name) {
        //TODO IMPLEMENT
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public ArrayList<Availability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(ArrayList<Availability> availabilities) {
        this.availabilities = availabilities;
    }
}

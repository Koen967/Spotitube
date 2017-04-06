package oose.dea.service;

import oose.dea.dataAccess.PlaylistDAO;
import oose.dea.presentation.domainmodel.*;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by koen on 24-3-2017.
 */
@Dependent
public class PlaylistService {

    @Inject
    PlaylistDAO dao;

    public List<Playlist> getPlaylistsFromOwner(String ownerName) {
        return  dao.getPlaylistsFromOwner(ownerName);
    }

    public void updatePlaylistName(String ownerName, String oldName, String newName) {
        dao.updatePlaylistName(ownerName, oldName, newName);
    }

    public void addTrackToPlaylist(String title, String performer, String playlistName, String ownerName) {
        dao.addTrackToPlaylist(title, performer, playlistName, ownerName);
    }

    public Playlist getPlaylist(String ownerName, String playlistName) {
        return dao.getPlaylist(ownerName, playlistName);
    }

    public List<Availability> getTracksInPlaylist(String ownerName, String playlistName) {
        return dao.getTracksInPlaylist(ownerName, playlistName);
    }

    public void deletePlaylist(String ownerName, String playlistName) {
        dao.deletePlaylist(ownerName, playlistName);
    }

    public void addPlaylist(String ownerName, String playlistName) {
        dao.addPlaylist(ownerName, playlistName);
    }

    public void setDao(PlaylistDAO dao) {
        this.dao = dao;
    }
}

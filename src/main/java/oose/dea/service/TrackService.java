package oose.dea.service;

import oose.dea.dataAccess.TrackDAO;
import oose.dea.dataAccess.TrackDAOImpl;
import oose.dea.presentation.domainmodel.Track;

import javax.enterprise.context.Dependent;

import java.util.List;

/**
 * Created by koen on 27-3-2017.
 */
@Dependent
public class TrackService {

    TrackDAO dao = new TrackDAOImpl();

    public List<Track> getTracksNotInPlaylist(String ownerName, String playlistName) {
        return dao.getTracksNotInPlaylist(ownerName, playlistName);
    }

    public List<Track> getTracksNotInPlaylistSearch(String ownerName, String playlistName, String search) {
        return dao.getTracksNotInPlaylistSearch(ownerName, playlistName, search);
    }
}

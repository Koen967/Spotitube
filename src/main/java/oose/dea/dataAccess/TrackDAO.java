package oose.dea.dataAccess;

import oose.dea.presentation.domainmodel.Track;

import java.util.List;

/**
 * Created by koen on 27-3-2017.
 */
public interface TrackDAO {
    List<Track> getTracksNotInPlaylist(String ownerName, String playlistName);
    List<Track> getTracksNotInPlaylistSearch(String ownerName, String name, String search);
    List<Track> getTracks();
    List<Track> getTracksSearch(String search);
}

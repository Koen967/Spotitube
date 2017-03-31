package oose.dea.dataAccess;

import oose.dea.presentation.domainmodel.Playlist;

import java.util.List;

/**
 * Created by koen on 24-3-2017.
 */
public interface PlaylistDAO {
    List<Playlist> getPlaylistsFromOwner(String ownerName);
    void updatePlaylistName(String ownerName, String oldName, String newName);
    void addTrackToPlaylist(String title, String performer, String playlistName, String ownerName);

    Playlist getPlaylist(String ownerName, String playlistName);
}

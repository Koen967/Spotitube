package oose.dea.service;

import oose.dea.dataAccess.PlaylistDAO;
import oose.dea.dataAccess.PlaylistDAOImpl;
import oose.dea.presentation.domainmodel.Playlist;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koen on 24-3-2017.
 */
public class PlaylistService {

    PlaylistDAO dao = new PlaylistDAOImpl();

    public List<Playlist> getPlaylistsFromOwner(String ownerName) {
        return  dao.getPlaylistsFromOwner(ownerName);
//        List<Playlist> playlistList = new ArrayList<Playlist>();
//        Playlist playlist = new Playlist("Koen", "Playlist1");
//        Playlist playlist1 = new Playlist("Koen", "Playlist2");
//        playlistList.add(playlist);
//        playlistList.add(playlist1);
//        return playlistList;
    }

    public void updatePlaylistName(String ownerName, String oldName, String newName) {
        dao.updatePlaylistName(ownerName, oldName, newName);
    }
}

package oose.dea.service;

import oose.dea.dataAccess.PlaylistDAO;
import oose.dea.presentation.domainmodel.Playlist;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by koen on 24-3-2017.
 */
public class PlaylistService {
    @Inject
    PlaylistDAO dao;

    public List<Playlist> getPlaylistsFromOwner(String ownerName) {
        return  dao.getPlaylistsFromOwner(ownerName);
    }
}

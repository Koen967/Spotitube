/*
package oose.dea.service;

import oose.dea.dataAccess.PlaylistDAO;
import oose.dea.presentation.domainmodel.Playlist;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

*/
/**
 * Created by koen on 3-4-2017.
 *//*

@RunWith(MockitoJUnitRunner.class)
public class TestPlaylistService {

    @Mock
    PlaylistDAO playlistDAO;

    PlaylistService service;

    @Before
    public void init() {
        service = new PlaylistService();
        service.setDao(playlistDAO);
    }

    @Test
    public void testGetPlaylistsFromOwner() {
        List<Playlist> playlistList = new ArrayList<Playlist>();
        Playlist playlist = new Playlist("test", "list");
        playlistList.add(playlist);

        when(playlistDAO.getPlaylistsFromOwner(anyString())).thenReturn(playlistList);

        Assert.assertEquals(playlistList, service.getPlaylistsFromOwner("test"));
    }

    @Test
    public void testUpdatePlaylistName() {
        doNothing().when(playlistDAO).updatePlaylistName("test", "old", "new");
        service.updatePlaylistName("test", "old", "new");
    }

    @Test
    public void testAddTrackToPlaylist() {
        doNothing().when(playlistDAO).addTrackToPlaylist("title", "performer", "playlistName", "ownerName");
        service.addTrackToPlaylist("title", "performer", "playlistName", "ownerName");
    }

    @Test
    public void testGetPlaylist() {
        Playlist playlist = new Playlist("test", "list");

        when(playlistDAO.getPlaylist(anyString(), anyString())).thenReturn(playlist);

        Assert.assertEquals(playlist, service.getPlaylist("test", "test"));
    }

}
*/

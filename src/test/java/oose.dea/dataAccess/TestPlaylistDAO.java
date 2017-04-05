//package oose.dea.dataAccess;
//
//import oose.dea.dataAccess.databaseConnection.DatabaseConnection;
//import oose.dea.presentation.domainmodel.Playlist;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
///**
// * Created by koen on 3-4-2017.
// */
//@RunWith(MockitoJUnitRunner.class)
//public class TestPlaylistDAO {
//
//    @Mock
//    DatabaseConnection connection;
//
//    PlaylistDAO dao;
//
//    @Before
//    public void init(){
//        dao = new PlaylistDAOImpl();
//        dao.setConn(connection);
//    }
//
//    @Test
//    public void testGetPlaylistsFromOwner() {
//        List<Playlist> playlistList = new ArrayList<Playlist>();
//        Playlist playlist = new Playlist("test", "list");
//        playlistList.add(playlist);
//        try {
//            when(connection.getConnection().prepareStatement(anyString())).thenReturn(connection.getConnection().prepareStatement("TEST"));
//
////            Assert.assertEquals(playlistList, dao.getPlaylistsFromOwner("Test"));
//            doNothing().when(connection).getConnection().prepareStatement(anyString());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
////        Assert.assertEquals(playlistList, dao.getPlaylistsFromOwner("test"));
//    }
//
//    @Test
//    public void testUpdatePlaylistName() {
//
//        try {
//            PreparedStatement preparedStatement = connection.getConnection().prepareStatement("TEST");
//
//            when(connection.getConnection().prepareStatement(anyString())).thenReturn(preparedStatement);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        dao.updatePlaylistName("test", "old", "new");
//    }
//}

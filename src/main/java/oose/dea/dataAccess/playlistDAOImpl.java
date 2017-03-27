package oose.dea.dataAccess;

import oose.dea.dataAccess.databaseConnection.DatabaseConnection;
import oose.dea.presentation.domainmodel.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koen on 24-3-2017.
 */
public class PlaylistDAOImpl implements PlaylistDAO {
    DatabaseConnection connection = new DatabaseConnection();
    Connection conn = connection.getConnection();

    public List<Playlist> getPlaylistsFromOwner(String ownerName) {
        List<Playlist> playlists = new ArrayList<Playlist>();
        try{
            PreparedStatement preparedStatement;
            String query = "SELECT playlistName FROM Playlist WHERE ownerName = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, ownerName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String playlistName = rs.getString("playlistName");
                Playlist playlist = new Playlist(ownerName, playlistName);
                playlists.add(playlist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return playlists;
    }

    public void updatePlaylistName(String ownerName, String oldName, String newName) {
        try{
            PreparedStatement preparedStatement;
            String query = "UPDATE Playlist SET playlistName = ? WHERE ownerName = ? AND playlistName = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, ownerName);
            preparedStatement.setString(3, oldName);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

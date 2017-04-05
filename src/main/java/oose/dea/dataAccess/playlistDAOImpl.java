package oose.dea.dataAccess;

import oose.dea.dataAccess.databaseConnection.DatabaseConnection;
import oose.dea.presentation.domainmodel.Playlist;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koen on 24-3-2017.
 */
@Dependent
public class PlaylistDAOImpl implements PlaylistDAO {

    @Inject
    DatabaseConnection connection;

    public List<Playlist> getPlaylistsFromOwner(String ownerName) {
        List<Playlist> playlists = new ArrayList<Playlist>();
        try {
            PreparedStatement preparedStatement;
            String query = "SELECT playlistName FROM Playlist WHERE ownerName = ?";
            preparedStatement = connection.getConnection().prepareStatement(query);
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
        try {
            PreparedStatement preparedStatement;
            String query = "UPDATE Playlist SET playlistName = ? WHERE ownerName = ? AND playlistName = ?";
            preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, ownerName);
            preparedStatement.setString(3, oldName);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTrackToPlaylist(String title, String performer, String playlistName, String ownerName) {
        try {
            PreparedStatement preparedStatement;
            String query = "INSERT INTO Availability VALUES (?, ?, ?, ?, 0)";
            preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, ownerName);
            preparedStatement.setString(2, playlistName);
            preparedStatement.setString(3, performer);
            preparedStatement.setString(4, title);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Playlist getPlaylist(String ownerName, String playlistName) {
        try {
            PreparedStatement preparedStatement;
            String query = "SELECT playlistName FROM Playlist WHERE ownerName = ? AND playlistName = ?";
            preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, ownerName);
            preparedStatement.setString(2, playlistName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ownerName = rs.getString("ownerName");
                playlistName = rs.getString("playlistName");
                Playlist playlist = new Playlist(ownerName, playlistName);
                return playlist;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setConn(DatabaseConnection conn) {
        this.connection = conn;
    }
}

package oose.dea.dataAccess;

import oose.dea.dataAccess.databaseConnection.DatabaseConnection;
import oose.dea.presentation.domainmodel.Playlist;
import oose.dea.presentation.domainmodel.Song;
import oose.dea.presentation.domainmodel.Track;
import oose.dea.presentation.domainmodel.Video;

import javax.enterprise.context.Dependent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by koen on 27-3-2017.
 */
@Dependent
public class TrackDAOImpl implements TrackDAO {
    DatabaseConnection connection = new DatabaseConnection();
    Connection conn = connection.getConnection();

    public List<Track> getTracksNotInPlaylist(String ownerName, String playlistName) {
        List<Track> tracks = new ArrayList<Track>();
        try{
            CallableStatement cs = this.conn.prepareCall("{call spd_getTracksNotInPlaylist(?, ?)}");
            cs.setString(1, ownerName);
            cs.setString(2, playlistName);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                String performer = rs.getString("performer");
                String title = rs.getString("title");
                int duration = rs.getInt("duration");

                if (rs.getString("album") != null) {
                    String album = rs.getString("album");
                    Song song = new Song(performer, title, null, duration, album);
                    tracks.add(song);
                } else {
                    int playCount = rs.getInt("playCount");
                    Calendar publicationDate = Calendar.getInstance();
                    publicationDate.setTime(rs.getDate("publicationDate"));
                    String description = rs.getString("description");
                    Video video = new Video(performer, title, null, duration, playCount, publicationDate, description);
                    tracks.add(video);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tracks;
    }
}

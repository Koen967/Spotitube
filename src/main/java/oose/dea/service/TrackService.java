package oose.dea.service;

import oose.dea.dataAccess.TrackDAO;
import oose.dea.dataAccess.TrackDAOImpl;
import oose.dea.presentation.domainmodel.Song;
import oose.dea.presentation.domainmodel.Track;
import oose.dea.presentation.domainmodel.Video;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by koen on 27-3-2017.
 */
public class TrackService {

    TrackDAO dao = new TrackDAOImpl();

    public List<Track> getTracksNotInPlaylist(String ownerName, String playlistName) {
        return dao.getTracksNotInPlaylist(ownerName, playlistName);
//        List<Track> trackList = new ArrayList<Track>();
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2017, 05, 12);
//        Track track1 = new Song("Koen", "Titel", "www.www.com.com", 234, "Albinium");
//        Track track2 = new Video("Mama", "MamaMia", "was.sad.wes", 113, 234, calendar, "Description");
//        trackList.add(track1);
//        trackList.add(track2);
//        return trackList;
    }
}

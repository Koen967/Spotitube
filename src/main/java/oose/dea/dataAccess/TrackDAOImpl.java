package oose.dea.dataAccess;

import oose.dea.presentation.domainmodel.Song;
import oose.dea.presentation.domainmodel.Track;
import oose.dea.presentation.domainmodel.Video;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

import javax.enterprise.context.Dependent;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by koen on 27-3-2017.
 */
@Dependent
public class TrackDAOImpl implements TrackDAO {

    public List<Track> getTracksNotInPlaylist(String ownerName, String playlistName) {
        List<Track> tracks = new ArrayList<Track>();
        try {
            URL url = new URL("http://localhost:3000/tracks/" + ownerName + "/" + playlistName);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            int status = con.getResponseCode();
            InputStream in = new BufferedInputStream(con.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            JSONArray myResponse = new JSONArray(result);
            System.out.println(myResponse);
            getTracksFromResponse(tracks, myResponse);
            in.close();
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tracks;
    }

    public List<Track> getTracksNotInPlaylistSearch(String ownerName, String playlistName, String search) {
        List<Track> tracks = new ArrayList<Track>();

        try {
            URL url = new URL("http://localhost:3000/tracks/" + ownerName + "/" + playlistName + "?filter=" + search);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            int status = con.getResponseCode();
            InputStream in = new BufferedInputStream(con.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            JSONArray myResponse = new JSONArray(result);
            System.out.println(myResponse);
            getTracksFromResponse(tracks, myResponse);
            in.close();
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tracks;
    }

    private void getTracksFromResponse(List<Track> tracks, JSONArray myResponse) {
        for (int i = 0; i < myResponse.length(); i++) {
            if (myResponse.getJSONObject(i).has("album")) {
                Track track = new Song(myResponse.getJSONObject(i).getString("performer"), myResponse.getJSONObject(i).getString("title"), myResponse.getJSONObject(i).getString("url"), myResponse.getJSONObject(i).getInt("duration"), myResponse.getJSONObject(i).getString("album"));
                tracks.add(track);
            } else if (myResponse.getJSONObject(i).has("playCount")) {
                String publicationDateString = myResponse.getJSONObject(i).get("publicationDate").toString();
                Calendar publicationDate = Calendar.getInstance();
                publicationDate.set(2018, 03, 15);
                Track track = new Video(myResponse.getJSONObject(i).getString("performer"), myResponse.getJSONObject(i).getString("title"), myResponse.getJSONObject(i).getString("url"), myResponse.getJSONObject(i).getInt("duration"), myResponse.getJSONObject(i).getInt("playCount"), publicationDate, myResponse.getJSONObject(i).getString("description"));
                tracks.add(track);
            }
        }
    }
}

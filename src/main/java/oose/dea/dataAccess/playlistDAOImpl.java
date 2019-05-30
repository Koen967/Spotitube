package oose.dea.dataAccess;

import oose.dea.presentation.domainmodel.*;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

import javax.annotation.ManagedBean;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by koen on 24-3-2017.
 */
@ManagedBean
public class PlaylistDAOImpl implements PlaylistDAO {

    public List<Playlist> getPlaylistsFromOwner(String ownerName) {
        List<Playlist> playlists = new ArrayList<Playlist>();
        try {
            URL url = new URL("http://localhost:3000/playlists/" + ownerName);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            int status = con.getResponseCode();
            InputStream in = new BufferedInputStream(con.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            JSONArray myResponse = new JSONArray(result);
            for (int i = 0; i < myResponse.length(); i++) {
                Playlist playlist = new Playlist(myResponse.getJSONObject(i).getString("ownerName"), myResponse.getJSONObject(i).getString("playlistName"));
                playlists.add(playlist);
            }
            in.close();
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return playlists;
    }

    public void updatePlaylistName(String ownerName, String oldName, String newName) {
        try {
            URL url = new URL("http://localhost:3000/playlists/" + ownerName + "/" + oldName);
            String json = "{ \"newPlaylistName\": \"" + newName + "\" }";
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestMethod("PUT");
            OutputStream os = con.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();
            int status = con.getResponseCode();
            InputStream in = new BufferedInputStream(con.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            in.close();
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTrackToPlaylist(String title, String performer, String playlistName, String ownerName) {
        try {
            URL url = new URL("http://localhost:3000/playlists/" + ownerName + "/" + playlistName + "/songs");
            String json = "{ \"title\": \"" + title + "\", \"performer\": \"" + performer + "\" }";
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestMethod("PUT");
            OutputStream os = con.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();
            int status = con.getResponseCode();
            InputStream in = new BufferedInputStream(con.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            in.close();
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Availability> getTracksInPlaylist(String ownerName, String playlistName) {
        List<Availability> availabilities = new ArrayList<Availability>();
        try {
            URL url = new URL("http://localhost:3000/playlists/" + ownerName + "/" + playlistName + "/songs");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            int status = con.getResponseCode();
            InputStream in = new BufferedInputStream(con.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            JSONArray myResponse = new JSONArray(result);
            for (int i = 0; i < myResponse.length(); i++) {
                if (myResponse.getJSONObject(i).has("album")) {
                    Track track = new Song(myResponse.getJSONObject(i).getString("performer"), myResponse.getJSONObject(i).getString("title"), myResponse.getJSONObject(i).getString("url"), myResponse.getJSONObject(i).getInt("duration"), myResponse.getJSONObject(i).getString("album"));
                    Availability availability = new Availability(myResponse.getJSONObject(i).getBoolean("offlineAvailable"), track);
                    availabilities.add(availability);
                } else  {
                    String publicationDateString = myResponse.getJSONObject(i).get("publicationDate").toString();
                    Calendar publicationDate = Calendar.getInstance();
                    publicationDate.set(2018, 03, 15);
                    Track track = new Video(myResponse.getJSONObject(i).getString("performer"), myResponse.getJSONObject(i).getString("title"), myResponse.getJSONObject(i).getString("url"), myResponse.getJSONObject(i).getInt("duration"), myResponse.getJSONObject(i).getInt("playCount"), publicationDate, myResponse.getJSONObject(i).getString("description"));
                    Availability availability = new Availability(myResponse.getJSONObject(i).getBoolean("offlineAvailable"), track);
                    availabilities.add(availability);
                }
            }
            in.close();
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return availabilities;
    }

    public void deletePlaylist(String ownerName, String playlistName) {
        try {
            URL url = new URL("http://localhost:3000/playlists/" + ownerName + "/" + playlistName);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestMethod("DELETE");
            OutputStream os = con.getOutputStream();
            os.close();
            int status = con.getResponseCode();
            InputStream in = new BufferedInputStream(con.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            in.close();
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPlaylist(String ownerName, String playlistName) {
        try {
            URL url = new URL("http://localhost:3000/playlists/" + ownerName + "/" + playlistName);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            OutputStream os = con.getOutputStream();
            os.close();
            int status = con.getResponseCode();
            InputStream in = new BufferedInputStream(con.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            in.close();
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

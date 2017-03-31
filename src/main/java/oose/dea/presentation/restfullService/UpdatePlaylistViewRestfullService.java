package oose.dea.presentation.restfullService;

import oose.dea.presentation.domainmodel.Playlist;
import oose.dea.service.PlaylistService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by koen on 28-3-2017.
 */
@Path("/updatePlaylistView")
public class UpdatePlaylistViewRestfullService {
    @Inject
    PlaylistService service;

    @Path("/{name}")
    @GET
    @Produces("application/json")
    public String getPlaylist(@PathParam("name") String playlistName) {
        return playlistName;
    }

}

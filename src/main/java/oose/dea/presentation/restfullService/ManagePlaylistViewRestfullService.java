package oose.dea.presentation.restfullService;

import oose.dea.presentation.domainmodel.Playlist;
import oose.dea.service.PlaylistService;

import javax.inject.Inject;
import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koen on 28-3-2017.
 */
@Path("/rest")
public class ManagePlaylistViewRestfullService {
    @Inject
    PlaylistService service;


    @Path("/{ownerName}")
    @GET
    @Produces("application/json")
    public Response getPlaylistsFromOwner(@PathParam("ownerName") String ownerName) {
        List<Playlist> playlistList = service.getPlaylistsFromOwner(ownerName);

        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for (Playlist playlist:playlistList) {
            JsonObjectBuilder jObjectB = Json.createObjectBuilder().add("ownerName", playlist.getOwnerName())
                    .add("playlistName", playlist.getPlaylistName());

            arrayBuilder.add(jObjectB.build());
        }

        JsonArray array = arrayBuilder.build();

        return Response.status(200).entity(array).build();
    }

    @Path("/text/{ownerName}")
    @GET
    @Produces("text/plain")
    public Response getPlaylistsFromOwnerTxt(@PathParam("ownerName") String ownerName) {
        List<Playlist> playlistList = service.getPlaylistsFromOwner(ownerName);

        String returnValue = "test";

        for (Playlist playlist:playlistList) {
//           returnValue.concat(playlist.getOwnerName()).concat(playlist.getPlaylistName());
            returnValue = returnValue + playlist.getPlaylistName();
        }

        return Response.status(200).entity(returnValue).build();
    }

//    @Path("/{ownerName}/{playlistName}")
//    @GET
//    @Produces("application/json")
//    public Response getPlaylist(@PathParam("ownerName") String ownerName, @PathParam("playlistName") String playlistName){
//        Playlist playlist = service.getPlaylist(ownerName, playlistName);
//        return Response.status(200).entity(playlist).build();
//    }

//    @Path("text")
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String doGetHelloTxt() {
//        return "Hello world";
//    }

    @Path("json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response doGetHelloJson() {
        JsonObject jo = Json.createObjectBuilder().add("message", "hello world").build();
        return Response.status(200).entity(jo).build();
    }


//    @POST
//    @Path("json")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response doPostHelloJson(Person person) {
//        String say_what = "Hello " + person.getName();
//
//        JsonObject jo = Json.createObjectBuilder().add("message", say_what).build();
//        return Response.status(200).entity(jo).build();
//    }
}

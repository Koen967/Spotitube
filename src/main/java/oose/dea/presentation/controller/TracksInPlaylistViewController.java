package oose.dea.presentation.controller;

import oose.dea.presentation.domainmodel.Availability;
import oose.dea.presentation.domainmodel.Track;
import oose.dea.service.PlaylistService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by koen on 5-4-2017.
 */
@WebServlet("/tracksInPlaylistView")
public class TracksInPlaylistViewController extends HttpServlet {

    @Inject
    PlaylistService service;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ownerName = request.getParameter("ownerName");
        String playlistName = request.getParameter("playlistName");
        List<Availability> tracksInPlaylist = service.getTracksInPlaylist(ownerName, playlistName);
        request.setAttribute("tracksInPlaylist", tracksInPlaylist);
        request.getRequestDispatcher("tracksInPlaylistView.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getContextPath();
        if (request.getParameter("back") != null) {
            response.sendRedirect(uri + "/managePlaylistView?ownerName=" + request.getSession().getAttribute("ownerName").toString());
        }
    }
}

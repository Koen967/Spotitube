package oose.dea.presentation.controller;

import oose.dea.presentation.domainmodel.Track;
import oose.dea.service.PlaylistService;
import oose.dea.service.TrackService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by koen on 27-3-2017.
 */
@WebServlet("/trackToevoegenView")
public class TrackToevoegenViewController extends HttpServlet {

    @Inject
    TrackService trackService;
    @Inject
    PlaylistService playlistService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Track> trackList = trackService.getTracksNotInPlaylist(request.getSession().getAttribute("ownerName").toString(), request.getParameter("name"));
        request.setAttribute("trackList", trackList);
        request.getRequestDispatcher("trackToevoegenView.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getContextPath();
        if (request.getParameter("add") != null) {
            playlistService.addTrackToPlaylist(request.getParameter("title"), request.getParameter("performer"), request.getParameter("name"), request.getSession().getAttribute("ownerName").toString());
            response.sendRedirect(uri + "/trackToevoegenView?name=" + request.getParameter("name"));
        } else if (request.getParameter("back") != null) {
            response.sendRedirect(uri + "/managePlaylistView?ownerName=" + request.getSession().getAttribute("ownerName").toString());
        } else if (request.getParameter("search") != null) {

        }
    }
}

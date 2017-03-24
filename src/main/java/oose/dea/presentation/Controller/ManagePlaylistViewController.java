package oose.dea.presentation.Controller;

import oose.dea.presentation.domainmodel.Playlist;
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
 * Created by koen on 24-3-2017.
 */
@WebServlet("/managePlaylistView")
public class ManagePlaylistViewController extends HttpServlet {
    @Inject
    PlaylistService service;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ownerName = request.getParameter("ownerName");
        List<Playlist> playlistsFromOwner = service.getPlaylistsFromOwner(ownerName);
        request.setAttribute("playlistsFromOwner", playlistsFromOwner);
        request.getRequestDispatcher("managePlaylistView.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

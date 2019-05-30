package oose.dea.presentation.controller;

import oose.dea.presentation.domainmodel.Playlist;
import oose.dea.service.PlaylistService;

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

    PlaylistService service = new PlaylistService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ownerName = request.getParameter("ownerName");
        request.getSession().setAttribute("ownerName", ownerName);
        List<Playlist> playlistsFromOwner = service.getPlaylistsFromOwner(ownerName);
        request.setAttribute("playlistsFromOwner", playlistsFromOwner);
        request.getRequestDispatcher("managePlaylistView.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("playlistName");
        String uri = request.getContextPath();
        if (request.getParameter("edit") != null) {
            response.sendRedirect(uri + "/updatePlaylistView?name=" + name);
        } else if (request.getParameter("add") != null) {
            response.sendRedirect(uri + "/trackToevoegenView?name=" + name);
        } else if (request.getParameter("create") != null) {
            response.sendRedirect(uri + "/playlistToevoegenView");
        } else if (request.getParameter("delete") != null) {
            service.deletePlaylist(request.getSession().getAttribute("ownerName").toString(), request.getParameter("playlistName"));
            response.sendRedirect(uri + "/managePlaylistView?ownerName=" + request.getSession().getAttribute("ownerName").toString());
        }
    }
}

package oose.dea.presentation.controller;

import oose.dea.service.PlaylistService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by koen on 6-4-2017.
 */
@WebServlet("/playlistToevoegenView")
public class PlaylistToevoegenViewController extends HttpServlet {

    @Inject
    PlaylistService service;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("playlistToevoegenView.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getContextPath();
        if (request.getParameter("confirm") != null) {
            service.addPlaylist(request.getSession().getAttribute("ownerName").toString(), request.getParameter("playlistName"));
        }
        response.sendRedirect(uri + "/managePlaylistView?ownerName=" + request.getSession().getAttribute("ownerName").toString());
    }
}

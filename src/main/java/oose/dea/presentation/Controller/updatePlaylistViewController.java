package oose.dea.presentation.controller;

import oose.dea.service.PlaylistService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by koen on 26-3-2017.
 */
@WebServlet("/updatePlaylistView")
public class UpdatePlaylistViewController extends HttpServlet {

    PlaylistService service = new PlaylistService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playlistName = request.getParameter("name");
        request.getSession().setAttribute("playlistName", playlistName);
        request.getRequestDispatcher("updatePlaylistView.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newName = request.getParameter("newPlaylistName");
        String oldName = request.getSession().getAttribute("playlistName").toString();
        String uri = request.getContextPath();
        String ownerName = request.getSession().getAttribute("ownerName").toString();
        if (request.getParameter("confirm") != null) {
            service.updatePlaylistName(ownerName, oldName, newName);
            response.sendRedirect(uri + "/managePlaylistView?ownerName=" + ownerName);
        } else if (request.getParameter("cancel") != null) {
            response.sendRedirect(uri + "/managePlaylistView?ownerName=" + ownerName);
        }
    }
}

package oose.dea.presentation.Controller;

import oose.dea.presentation.domainmodel.Track;
import oose.dea.service.PlaylistService;
import oose.dea.service.TrackService;

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

    TrackService service = new TrackService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Track> trackList = service.getTracksNotInPlaylist(request.getSession().getAttribute("ownerName").toString(), request.getParameter("name"));
        request.setAttribute("trackList", trackList);
//        response.sendRedirect(request.getSession().getAttribute("ownerName").toString() + " + " + request.getParameter("name"));
        request.getRequestDispatcher("trackToevoegenView.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

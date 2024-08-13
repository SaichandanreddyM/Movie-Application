package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import DTO.Movies;
@WebServlet("/updatemovie")
public class UpdateMovie extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String category=req.getParameter("category");
		double rating=Double.parseDouble(req.getParameter("rating")); 
		Movies movie=new Movies(id, name, category, rating, null);
		DAO dao=new DAO();
		try {
			Movies oldmoviedata=dao.findMovieByid(id);
			movie.setImage(oldmoviedata.getImage());
			dao.updateMovie(movie, id);
			req.setAttribute("movies", dao.getallmovies());
			req.getRequestDispatcher("adminhome.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

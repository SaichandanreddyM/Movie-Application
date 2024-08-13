package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DAO.DAO;
import DTO.Admin;
import DTO.Movies;
@WebServlet("/savemovie")
@MultipartConfig(maxFileSize = 10*1024*1024)
public class Addmovie extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String category=req.getParameter("category");
		double rating=Double.parseDouble(req.getParameter("rating"));
		Part imagepart=req.getPart("image");
		byte[] image=imagepart.getInputStream().readAllBytes();
		Movies movie=new Movies(id, name, category, rating, image);
		DAO dao=new DAO();
		try {
			HttpSession session=req.getSession();
			Admin sessionadmin=(Admin) session.getAttribute("admin");
			if(sessionadmin!=null) {
			dao.addmovie(movie);
			req.setAttribute("movies", dao.getallmovies());
			req.getRequestDispatcher("adminhome.jsp").forward(req, resp);
		}
		
		
		else {
			resp.sendRedirect("adminlogin.jsp");
		}
		}
		
			catch (ClassNotFoundException | SQLException e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}

package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO;
import DTO.Admin;
import DTO.Movies;
@WebServlet("/edit")
public class Edit_Movie extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		DAO dao=new DAO(); 
		try {
			HttpSession session=req.getSession();
			Admin sessionadmin=(Admin) session.getAttribute("admin");
			if(sessionadmin!=null) {
			Movies movie=dao.findMovieByid(id);
			req.setAttribute("moviees", movie);
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
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

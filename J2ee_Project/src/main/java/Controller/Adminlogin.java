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
@WebServlet("/adminlogin1")
public class Adminlogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mail=req.getParameter("email");
		String pwd=req.getParameter("password"); 
		DAO dao=new DAO();
		try {
			Admin admin=dao.Findadminbyemail(mail);
			if(admin!=null) {
				if(admin.getApwd().equals(pwd)) {
					HttpSession session=req.getSession();
					session.setAttribute("admin", admin);
				    req.setAttribute("movies", dao.getallmovies());
					req.getRequestDispatcher("adminhome.jsp").forward(req, resp);
				}
				else {
					req.setAttribute("message", "Invalid password");
					req.getRequestDispatcher("adminlogin.jsp").forward(req, resp);
				}
				
				
			}
			else {
				req.setAttribute("message", "Invalid mail");
				req.getRequestDispatcher("adminlogin.jsp").forward(req, resp);
				
			}
			
			
			
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import DTO.Admin;
@WebServlet("/adminsignup1")
public class Adminsignup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		long contact=Long.parseLong(req.getParameter("contact"));
		String mail=req.getParameter("email");
		String pwd=req.getParameter("password");
		Admin a=new Admin(id, name, contact, mail, pwd);
		DAO dao=new DAO();
		try {
			int num=dao.Signupadmin(a);
			if(num>0) {
				resp.sendRedirect("adminlogin.jsp");
			
			}
			else {
				
				resp.sendRedirect("adminsignup.jsp");
			}
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

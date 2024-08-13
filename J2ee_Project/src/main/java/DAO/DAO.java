package DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import DTO.Admin;
import DTO.Movies;

public class DAO {
	public Connection getconnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
	}

	public int Signupadmin(Admin a) throws ClassNotFoundException, SQLException {
		Connection con = getconnection();
		PreparedStatement pst = con.prepareStatement("insert into admin values(?,?,?,?,?)");
		pst.setInt(1, a.getAid());
		pst.setString(2, a.getAname());
		pst.setLong(3, a.getAcno());
		pst.setString(4, a.getAemail());
		pst.setString(5, a.getApwd());
		return pst.executeUpdate();

	}

	public Admin Findadminbyemail(String mail) throws ClassNotFoundException, SQLException {
		Connection con = getconnection();
		PreparedStatement pst = con.prepareStatement("select * from admin where aemail=?");
		pst.setString(1, mail);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			return new Admin(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5));
		}
		return null;

	}

	public int addmovie(Movies movie) throws ClassNotFoundException, SQLException {
		Connection con = getconnection();
		PreparedStatement pst = con.prepareStatement("insert into movies values(?,?,?,?,?)");
		pst.setInt(1, movie.getMid());
		pst.setString(2, movie.getMname());
		pst.setString(3, movie.getCategory());
		pst.setDouble(4, movie.getRating());
		Blob image = new SerialBlob(movie.getImage());
		pst.setBlob(5, image);
		return pst.executeUpdate();

	}

	public int deleteMoviebyid(int id) throws ClassNotFoundException, SQLException {
		Connection con = getconnection();
		PreparedStatement pst = con.prepareStatement("delete from movies where mid=?");
		pst.setInt(1, id);
		return pst.executeUpdate();
	}

	public Movies findMovieByid(int id) throws ClassNotFoundException, SQLException {
		Connection con = getconnection();
		PreparedStatement pst = con.prepareStatement("select * from movies where mid=?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			Blob image = rs.getBlob(4);
			byte[] bytes = image.getBytes(1, (int) image.length());
			return new Movies(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), bytes);
		} else {
			return null;
		}

	}

	public int updateMovie(Movies movie, int id) throws ClassNotFoundException, SQLException {
		Connection con = getconnection();
		PreparedStatement pst = con
				.prepareStatement("update movies set mname=?,category=?,rating=?,image=? where mid=?");
		pst.setInt(5, movie.getMid());
		pst.setString(1, movie.getMname());
		pst.setString(2, movie.getCategory());
		pst.setDouble(3, movie.getRating());
		Blob image = new SerialBlob(movie.getImage());
		pst.setBlob(4, image);
		return pst.executeUpdate();

	}

	public List<Movies> getallmovies() throws ClassNotFoundException, SQLException {
		Connection con = getconnection();
		PreparedStatement pst = con.prepareStatement("select * from movies");
		List<Movies> movies = new ArrayList<>();
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Blob image = rs.getBlob(4);
			byte[] bytes = image.getBytes(1, (int) image.length());
			movies.add(new Movies(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), bytes));
		}
		return movies;

	}

}

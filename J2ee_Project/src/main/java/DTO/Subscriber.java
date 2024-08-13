package DTO;

import java.util.List;

public class Subscriber {
	private int sid;
	private String sname;
	private long scno;
	private String semail;
	private String spwd;
	List<Integer> movies;
	@Override
	public String toString() {
		return "Subscriber [sid=" + sid + ", sname=" + sname + ", scno=" + scno + ", semail=" + semail + ", spwd="
				+ spwd + ", movies=" + movies + "]";
	}
	public List<Integer> getMovies() {
		return movies;
	}
	public void setMovies(List<Integer> movies) {
		this.movies = movies;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public long getScno() {
		return scno;
	}
	public void setScno(long scno) {
		this.scno = scno;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	

}

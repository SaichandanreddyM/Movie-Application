package DTO;

public class Admin {
	private int aid;
	private String aname;
	private long acno;
	public Admin(int aid, String aname, long acno, String aemail, String apwd) {
		this.aid = aid;
		this.aname = aname;
		this.acno = acno;
		this.aemail = aemail;
		this.apwd = apwd;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public long getAcno() {
		return acno;
	}
	public void setAcno(long acno) {
		this.acno = acno;
	}
	public String getAemail() {
		return aemail;
	}
	public void setAemail(String aemail) {
		this.aemail = aemail;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	private String aemail;
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", aname=" + aname + ", acno=" + acno + ", aemail=" + aemail + ", apwd=" + apwd
				+ "]";
	}
	private String apwd;
	

}

package DTO;

import java.util.Arrays;

public class Movies {
	private int mid;
	private String mname;
    private String category;
    private double rating;
    private byte[] image;
	
	public Movies(int mid, String mname, String category, double rating, byte[] image) {
		this.mid = mid;
		this.mname = mname;
		this.category = category;
		this.rating = rating;
		this.image = image;
	}
//	public Movies() {
//		// TODO Auto-generated constructor stub
//	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Movies [mid=" + mid + ", mname=" + mname + ", category=" + category + ", rating=" + rating + ", image="
				+ Arrays.toString(image) + "]";
	}
	

}

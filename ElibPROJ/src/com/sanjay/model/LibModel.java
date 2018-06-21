package com.sanjay.model;

public class LibModel {
private int memberid;
private String fullname;
private int bookid;
private String bookname;
private String time;
private String authorname;
private int year;
private int availibleflag;
	public int getyear()
	{
		return year;
	}
	public void setyear(int year)
	{
		this.year = year;
	}
	public int getavailibleflag()
	{
		return availibleflag;
	}
	public void setavailibleflag(int avalibleflag)
	{
		this.availibleflag = avalibleflag;
	}
	public String getauthorname()
	{
		return authorname;
	}
	public void setauthorname(String authorname)
	{
		this.authorname = authorname;
	}
	public int getmemberid()
	{
		return memberid;
	}
	public void setmemberid(int memberid)
	{
		this.memberid = memberid;
	}
	public String getfullname()
	{
		return fullname;
	}
	public void setfullname(String fullname)
	{
		this.fullname = fullname;
	}
	public int getbookid()
	{
		return bookid;
	}
	public void setbookid(int bookid)
	{
		this.bookid = bookid;
	}
	public String getbookname()
	{
		return bookname;
	}
	public void setbookname(String bookname)
	{
		this.bookname = bookname;
	}
	public String gettime()
	{
		return time;
	}
	public void settime(String time)
	{
		this.time = time;
	}
}

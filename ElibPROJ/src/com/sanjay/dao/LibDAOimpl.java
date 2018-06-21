package com.sanjay.dao;
import java.util.*;
import java.sql.*;


import com.sanjay.model.*;
import com.sanjay.util.*;
public class LibDAOimpl implements LibDAO{
	private Connection conn;

	public LibDAOimpl() {
		conn = DBUTIL.initConnection();
	}
	@Override
	public void addMember( LibModel member ) {
		try {
			String timeStamp = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
			String query = "insert into members (memberid,fullname,bookid,bookname,time) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt( 1, member.getmemberid() );
			preparedStatement.setString( 2, member.getfullname() );
			preparedStatement.setInt( 3, member.getbookid() );
			preparedStatement.setString( 4, member.getbookname() );
			preparedStatement.setString(5, timeStamp);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteMember( int memberid ) {
		try {
			String query = "delete from members where memberid=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, memberid);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteBook( int bookid ) {
		try {
			String query = "delete from booklist where bookid=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, bookid);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateMember( LibModel member ) {
		try {
			String timeStamp = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
			String query = "update members set fullname=?, bookid=?, bookname=?, time=? where memberid=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, member.getfullname() );
			preparedStatement.setInt( 2, member.getbookid() );
			preparedStatement.setString( 3, member.getbookname() );
			preparedStatement.setString( 4, timeStamp );
			preparedStatement.setInt(5, member.getmemberid());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<LibModel> getAllMembers() {
		List<LibModel> members = new ArrayList<LibModel>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "SELECT * from members;" );
			while( resultSet.next() ) {
				LibModel member = new LibModel();
				member.setmemberid( resultSet.getInt( "memberid" ) );
				member.setfullname( resultSet.getString( "fullname" ) );
				member.setbookid( resultSet.getInt( "bookid" ) );
				member.setbookname( resultSet.getString( "bookname" ) );
				member.settime( resultSet.getString( "time" ) );
				members.add(member);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}
	public LibModel getMemberById(int memberid) {
		LibModel member = new LibModel();
		try {
			String query = "select * from members where memberid=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, memberid);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				member.setmemberid( resultSet.getInt( "memberid" ) );
				member.setfullname( resultSet.getString( "fullname" ) );
				member.setbookid( resultSet.getInt( "bookid" ) );
				member.setbookname( resultSet.getString( "bookname" ) );
				member.settime( resultSet.getString( "time" ) );
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	public LibModel getBookById(int bookid) {
		LibModel member = new LibModel();
		try {
			String query = "select * from booklist where bookid=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, bookid);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				member.setbookid( resultSet.getInt( "bookid" ) );
				member.setbookname( resultSet.getString( "bookname" ) );
				member.setauthorname( resultSet.getString( "authorname" ) );
				member.setavailibleflag( resultSet.getInt( "availibleflag" ) );
				member.setyear( resultSet.getInt( "year" ) );
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	@Override
	public void addBook( LibModel book ) {
		try {
			
			String query = "insert into booklist (bookid,bookname,authorname,availibleflag,year) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt( 1, book.getbookid() );
			preparedStatement.setString( 2, book.getbookname() );
			preparedStatement.setString( 3, book.getauthorname() );
			preparedStatement.setInt( 4, book.getavailibleflag() );
			preparedStatement.setInt(5, book.getyear());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<LibModel> getAllBooks() {
		List<LibModel> members = new ArrayList<LibModel>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "SELECT * from booklist;" );
			while( resultSet.next() ) {
				LibModel member = new LibModel();
				member.setbookid( resultSet.getInt( "bookid" ) );
				member.setbookname( resultSet.getString( "bookname" ) );
				member.setauthorname( resultSet.getString( "authorname" ) );
				member.setavailibleflag( resultSet.getInt( "availibleflag" ) );
				member.setyear( resultSet.getInt( "year" ) );
				members.add(member);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}
	@Override
	public void updateBook( LibModel book ) {
		try {
			String query = "update booklist set bookname=?, authorname=?, availibleflag=?, year=? where bookid=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, book.getbookname() );
			preparedStatement.setString( 2, book.getauthorname() );
			preparedStatement.setInt( 3, book.getavailibleflag() );
			preparedStatement.setInt( 4, book.getyear() );
			preparedStatement.setInt(5, book.getbookid());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

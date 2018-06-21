package com.sanjay.dao;

import java.util.List;

import com.sanjay.model.LibModel;

public interface LibDAO {
	public void addMember( LibModel member );
	public void deleteMember( int memberid );
	public void updateMember( LibModel member );
	public List<LibModel> getAllMembers();
	public LibModel getMemberById( int memberid );
	public LibModel getBookById( int bookid );
	public void addBook( LibModel book );
	public void updateBook( LibModel book );
	public void deleteBook( int bookid );
	public List<LibModel> getAllBooks();
}
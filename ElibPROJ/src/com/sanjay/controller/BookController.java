package com.sanjay.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sanjay.dao.*;
import com.sanjay.model.*;
@WebServlet("/BookController")
public class BookController extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private LibDAO dao;
public static final String LIST_MEMBER = "/listMember.jsp";
public static final String INSERT_OR_EDIT = "/member.jsp";
public static final String INSERT_BOOK = "/book.jsp";
public static final String UPDATE_BOOK = "/updatebook.jsp";
public static final String LIST_BOOK = "/listBook.jsp";

	public BookController() {
		dao = new LibDAOimpl();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );
		if( action.equalsIgnoreCase( "add" ) ) {
			forward = INSERT_BOOK;
		}
		else if( action.equalsIgnoreCase( "update" ) ) {
			forward = UPDATE_BOOK;
			int bookid = Integer.parseInt( request.getParameter("bookid") );
			LibModel member = dao.getBookById(bookid);
			request.setAttribute("member", member);
		}
		else if( action.equalsIgnoreCase( "delete" ) ) {
			forward = LIST_BOOK;
			int bookid = Integer.parseInt( request.getParameter("bookid") );
			dao.deleteBook(bookid);
			request.setAttribute("members", dao.getAllBooks() );
		}
		else if( action.equalsIgnoreCase( "showbooks" ) ) {
			try {
				forward = LIST_BOOK;
				request.setAttribute("members", dao.getAllBooks());
				
				
			}
			finally {forward = LIST_BOOK;}
		}
		RequestDispatcher view = request.getRequestDispatcher( forward );
		view.forward(request, response);
	}
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );
		LibModel book = new LibModel();
		book.setbookid( Integer.parseInt(request.getParameter( "bookid" )));
		book.setbookname( request.getParameter( "bookname" ));
		book.setauthorname( request.getParameter( "authorname" ) );
		book.setavailibleflag( Integer.parseInt(request.getParameter( "availibleflag" )) );
		book.setyear(Integer.parseInt(request.getParameter( "year" )) );
		String bookid = request.getParameter("bookid");

		if (action.equalsIgnoreCase("add"))
			
		{ dao.addBook(book);
			
		}
		else if(action.equalsIgnoreCase( "update" )){
			
			dao.updateBook(book);
		}
		
		RequestDispatcher view = request.getRequestDispatcher( LIST_BOOK );
		request.setAttribute("members", dao.getAllBooks());
		view.forward(request,response);
	}
}

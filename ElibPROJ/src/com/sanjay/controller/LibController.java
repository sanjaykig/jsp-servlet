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
@WebServlet("/LibController")
public class LibController extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private LibDAO dao;
public static final String LIST_MEMBER = "/listMember.jsp";
public static final String INSERT_OR_EDIT = "/member.jsp";
public static final String INSERT_BOOK = "/book.jsp";

	public LibController() {
		dao = new LibDAOimpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );

		if( action.equalsIgnoreCase( "delete" ) ) {
			forward = LIST_MEMBER;
			int memberid = Integer.parseInt( request.getParameter("memberid") );
			dao.deleteMember(memberid);
			request.setAttribute("members", dao.getAllMembers() );
		}
		else if( action.equalsIgnoreCase( "edit" ) ) {
			forward = INSERT_OR_EDIT;
			int memberid = Integer.parseInt( request.getParameter("memberid") );
			LibModel member = dao.getMemberById(memberid);
			request.setAttribute("member", member);
		}
		else if( action.equalsIgnoreCase( "add" ) ) {
			forward = INSERT_OR_EDIT;
		}
		else if ( action.equalsIgnoreCase( "insertbook" ))
		{
			forward = INSERT_BOOK;
		}
		else {
			forward = LIST_MEMBER;
			request.setAttribute("members", dao.getAllMembers() );
		}
		RequestDispatcher view = request.getRequestDispatcher( forward );
		view.forward(request, response);
	}
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );
		LibModel member = new LibModel();
		member.setmemberid( Integer.parseInt(request.getParameter( "memberid" )));
		member.setfullname( request.getParameter( "fullname" ));
		member.setbookid( Integer.parseInt(request.getParameter( "bookid" )) );
		member.setbookname( request.getParameter( "bookname" ) );
		String memberid = request.getParameter("memberid");

		
			dao.addMember(member);
		
		//else if(action.equalsIgnoreCase( "update" )){
			//forward = INSERT_OR_EDIT;
			//member.setmemberid( Integer.parseInt(memberid) );
			//dao.updateMember(member);
		//}
		RequestDispatcher view = request.getRequestDispatcher( LIST_MEMBER );
		request.setAttribute("members", dao.getAllMembers());
		view.forward(request, response);
	}
}

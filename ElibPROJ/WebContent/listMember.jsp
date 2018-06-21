<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE>
<html>
<style type="text/css">
	/* Place the navbar at the bottom of the page, and make it stick */
.navbar {
    background-color: #333;
    overflow: hidden;
    position: fixed;
    bottom: 0;
    width: 100%;
}
.container{
        width: 80%;
        margin: 0 auto; /* Center the DIV horizontally */
    }

 .box {
    width:700px;
    height:300px;
    background-color:#d9d9d9;
    position:fixed;
    margin-left:-350px; /* half of width */
    margin-top:-150px;  /* half of height */
    top:50%;
    left:50%;
}

    .fixed-header{
        width: 100%;
        position: fixed;        
        background: #333;
        padding: 10px 0;
        color: #fff;
        top:0%;
    }
/* Style the links inside the navigation bar */
.navbar a {
    float: left;
    display: block;
    color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    font-size: 17px;
}

/* Change the color of links on hover */
.navbar a:hover {
    background-color: #ddd;
    color: black;
}

/* Add a color to the active/current link */
.navbar a.active {
    background-color: #4CAF50;
    color: white;
}
body, html {
    height: 100%;
}

.bg { 
    /* The image used */
    background-image: url(library.jpeg);

    /* Full height */
    height: 100%; 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All members</title>
</head>
<body class="bg">
<div class="fixed-header">
        
            <h1> STUDENTS e-LIBRARY MANAGMENT PORTAL</h1>
       
    </div>
    
        
<table class ="box" border="1">
		<thead>
			<tr>
				<th>MEMBER ID</th>
				<th>FULL NAME</th>
				<th>BOOK ID</th>
				<th>BOOK NAME</th>
				<th>TIME</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${members}" var="member">
				<tr>
					<td><c:out value="${member.memberid}" /></td>
					<td><c:out value="${member.fullname}" /></td>
					<td><c:out value="${member.bookid}" /></td>
					<td><c:out value="${member.bookname}" /></td>
					<td><c:out value="${member.time}" /></td>
					<td><a
						href="LibController.do?action=edit&memberid=<c:out value="${member.memberid }"/>">Update</a></td>
					<td><a
						href="LibController.do?action=delete&memberid=<c:out value="${member.memberid }"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div class="navbar">
  <a href="LibController.do?action=add">Add Member</a>
  <a href="BookController.do?action=add">Add book</a>
  <a href="BookController.do?action=update">Update book</a>
  <a href="BookController.do?action=showbooks">List books</a>
</div>
</body>
</html>
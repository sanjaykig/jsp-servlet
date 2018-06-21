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
#myBtn {
     /* Hidden by default */
   -webkit-appearance: button;
    -moz-appearance: button;
    appearance: button;
    position: fixed; /* Fixed/sticky position */
    bottom: 20px; /* Place the button at the bottom of the page */
    right: 30px; /* Place the button 30px from the right */
    z-index: 99; /* Make sure it does not overlap */
    border: none; /* Remove borders */
    outline: none; /* Remove outline */
    background-color: red; /* Set a background color */
    color: white; /* Text color */
    cursor: pointer; /* Add a mouse pointer on hover */
    padding: 15px; /* Some padding */
    border-radius: 10px; /* Rounded corners */
    font-size: 18px; /* Increase font size */
}

#myBtn:hover {
    background-color: #555; /* Add a dark-grey background on hover */
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
<title>Show All BOOKS</title>
</head>
<body class="bg">
<div class="fixed-header">
        
            <h1> STUDENTS e-LIBRARY MANAGMENT PORTAL</h1>
       
    </div>
<table class="box" border="1">
		<thead>
			<tr>
				<th>BOOK ID</th>
				<th>BOOK NAME</th>
				<th>AUTHOR NAME</th>
				<th>AVAILIBLE FLAG</th>
				<th>YEAR</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${members}" var="member">
				<tr>
					<td><c:out value="${member.bookid}" /></td>
					<td><c:out value="${member.bookname}" /></td>
					<td><c:out value="${member.authorname}" /></td>
					<td><c:out value="${member.availibleflag}" /></td>
					<td><c:out value="${member.year}" /></td>
					<td><a
						href="BookController.do?action=update&bookid=<c:out value="${member.bookid }"/>">Update</a></td>
					<td><a
						href="BookController.do?action=delete&bookid=<c:out value="${member.bookid }"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="BookController.do?action=add">Add book</a>
		<a href="BookController.do?action=update">Update book</a>
	</p>
	<p>
	<a href="/ElibPROJ/" id="myBtn">HOME</a>
	</p>
	</body>
	</html>
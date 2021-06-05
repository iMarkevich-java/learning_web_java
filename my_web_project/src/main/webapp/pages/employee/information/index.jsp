<!DocType html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
		<title>Сделаем ваш первый бесплатный веб сайт</title>
	</head>
	<body>
		<div class="wrapper">
			<div class="header">
			    <div class="logo"><a href="">Ваш<span class="black">Сайт</span><span class="gray">.net</span></a><p>Ваш первый бесплатный веб сайт</p></div>
			</div>
			<div class="content">
				<div class="main">
                    <div class="block">
						<h3>Employee information</h3>
                        <p><img src="${pageContext.request.contextPath}/images/employeePhoto.jpg"  height="384" width="216" type="image/jpg" class="leftimg" alt=""/>
                    <div class="row">
                         <p>${employee.toString()}
                            ${developer.toString()}
                            ${manager.toString()}
                            ${qaEngineer.toString()}
                            ${address.toString()} </p>

					<div class="row">
					    <form action="${pageContext.request.contextPath}/mvc/employee/list">
					        <button type="submit">Back</button>
					    </form>
					</div>
					<div class="row">
                    	    <button type="submit" >Print</button>
                     </div>
                     </div>
                        <div class="row">
                        	<p><i>About employee</i></p>
                        </div>
                        </p>
                    </div>
				</div>
			</div>
			</div>
			<div class="footer">
				<p>&copy; Footer content <a href="#">Link footer</a></p>
			</div>
		</div>
	</body>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
    		<meta charset="utf-8">
    		<link rel="stylesheet" type="text/css" href="pages/style/style.css">
    		<title>Сделаем ваш первый бесплатный веб сайт</title>
    	</head>
    	<body>
    		<div class="wrapper">
    			<div class="header">
    				<div class="logo"><a href="">Ваш<span class="black">Сайт</span><span class="gray">.net</span></a><p>Ваш первый бесплатный веб сайт</p></div>
    				<ul class="nav">
					<li><a href="start">Home</a></li>
					<li><a href="clients">Clients</a></li>
					<li><a href="employees">Employees</a></li>
					<li><a href="developers">Developers</a></li>
					<li><a href="projects">Projects</a></li>
					<li><a href="addresses">Addresses</a></li>
					<li><a href="companies" class="active">Companies</a></li>
				</ul>
			</div>
			<div class="main">
			    <div >
			    </br>
			        <form action="registration-company" method="get">
                        <button type="submit"> Registration company</button>
                    </form>
                </br>
                </div>
			<!--Таблица-->
				<h2>Таблица компаний</h2>
    			<table class="bordered">
            	    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Company name</th>
                            <th>Company activity</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${companiesList}" var="company">
                        <tr>
                            <td>${company.companyId}</td>
                            <td>${company.companyName}</td>
                            <td>${company.companyActivity}</td>
                            <td>
                                <form action="edit-company" method="get">
                                    <input type="hidden" name="editCompanyIdParam" value="${company.companyId}"/>
                                    <input type="hidden" name="editCompanyNameParam" value="${company.companyName}"/>
                                    <input type="hidden" name="editCompanyActivityParam" value="${company.companyActivity}"/>
                                    <button type="submit"> Edit</button>
                                </form>
                            </td>
                            <td>
                                <form action="delete-company" method="get">
                                <input type="hidden" name="deleteCompanyIdParam" value="${company.companyId}"/>
                                <button type="submit"> Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
				</div>
			</div>

			<div class="footer">
				<p>&copy; Footer content <a href="#">Link footer</a></p>
			</div>
		</div>
	</body>
</html>
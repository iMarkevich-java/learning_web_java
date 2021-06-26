<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
    		<meta charset="utf-8">
    		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    		<title>Сделаем ваш первый бесплатный веб сайт</title>
    	</head>
    	<body>
    		<div class="wrapper">
    			<div class="header">
    				<div class="logo"><a href="">Ваш<span class="black">Сайт</span><span class="gray">.net</span></a><p>Ваш первый бесплатный веб сайт</p></div>
    				<ul class="nav">
					    <li><a href="${pageContext.request.contextPath}/mvc/start">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/mvc/client/list"  class="active">Clients</a></li>
                        <li><a href="${pageContext.request.contextPath}/mvc/employee/list">Employees</a></li>
                        <li><a href="${pageContext.request.contextPath}/mvc/project/list">Projects</a></li>
				    </ul>
			</div>
			<div class="main">
			    <div >
			    </br>
			        <form action="registration-client" method="get">
                        <button type="submit"> Registration client</button>
                    </form>
                </br>
                </div>
			<!--Таблица-->
				<h2>Таблица клиентов</h2>
    			<table class="bordered">
            	    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Client name</th>
                            <th>Name project</th>
                            <th>Address</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${clientsList}" var="client">
                        <tr>
                            <td>${client.id}</td>
                            <td>${client.nameClient}</td>
                            <td>${client.nameProject}</td>
                            <td>${client.address}</td>
                            <td>
                                <form action="edit-client" method="get">
                                    <input type="hidden" name="editClientIdParam" value="${client.id}" />
                                    <input type="hidden" name="editClientNameParam" value="${client.nameClient}" />
                                    <input type="hidden" name="editClientProjectNameParam" value="${client.nameProject}" />
                                    <input type="hidden" name="editClientAddressParam" value="${client.address}" />
                                    <button type="submit"> Edit</button>
                                </form>
                            </td>
                            <td>
                                <form action="delete-client" method="get">
                                <input type="hidden" name="deleteClientIdParam" value="${client.id}" />
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
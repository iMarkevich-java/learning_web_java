<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    				<ul class="nav">
					    <li><a href="${pageContext.request.contextPath}/mvc/start">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/mvc/clients/list">Clients</a></li>
                        <li><a href="${pageContext.request.contextPath}/mvc/employee/list">Employees</a></li>
                        <li><a href="${pageContext.request.contextPath}/mvc/developers/list" class="active">Developers</a></li>
                        <li><a href="${pageContext.request.contextPath}/mvc/projects/list">Projects</a></li>
                        <li><a href="${pageContext.request.contextPath}/mvc/address/list">Addresses</a></li>
                        <li><a href="${pageContext.request.contextPath}/mvc/companies/list">Companies</a></li>
				</ul>
			</div>
			<div class="main">
			<!--Таблица-->
				<h2>Список разработчиков</h2>
    			<table class="bordered">
            	    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Developer first name</th>
                            <th>Developer Surname</th>
                            <th>Developer department</th>
                            <th>Developer experience</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${developersList}" var="developer">
                        <tr>
                            <td>${developer.developerId}</td>
                            <td>${developer.getEmployee().getEmployeeFirstName()}</td>
                            <td>${developer.getEmployee().getEmployeeSurname()}</td>
                            <td>${developer.developerDepartment}</td>
                            <td>${developer.developerExperience}</td>
                            <td>
                                <form action="edit-developer" method="get">
                                    <input type="hidden" name="editDeveloperIdParam" value="${developer.developerId}" />
                                    <input type="hidden" name="editDeveloperDepartmentParam" value="${developer.developerDepartment}" />
                                    <input type="hidden" name="editDeveloperExperienceParam" value="${developer.developerExperience}" />
                                    <button type="submit"> Edit</button>
                                </form>
                            </td>
                            <td>
                                <form action="delete-developer">
                                <input type="hidden" name="deleteDeveloperIdParam" value="${developer.developerId}" />
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
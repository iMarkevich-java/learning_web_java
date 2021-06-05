<!DOCTYPE html>
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
                        <li><a href="${pageContext.request.contextPath}/mvc/employee/list" class="active">Employees</a></li>
                        <li><a href="${pageContext.request.contextPath}/mvc/developers/list">Developers</a></li>
					    <li><a href="${pageContext.request.contextPath}/mvc/projects/list">Projects</a></li>
					    <li><a href="${pageContext.request.contextPath}/mvc/address/list">Addresses</a></li>
					    <li><a href="${pageContext.request.contextPath}/mvc/companies/list">Companies</a></li>
				    </ul>
			    </div>
			    <div class="main">
			        <div >
			            </br>
			                <form action="${pageContext.request.contextPath}/mvc/employee/registration" method="get">
                                <button type="submit"> Registration employee</button>
                            </form>
                        </br>
                    </div>
			        <!--Таблица-->
				    <h2>Выборка сотрудников</h2>
    			    <table class="bordered">
            	        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Employee first name</th>
                                <th>Employee surname</th>
                                <th>Employee date of born</th>
                                <th>Employee position</th>
                                <th>Select</th>
                                <th>Select all</th>
                            </tr>
                        </thead>
                        <tbody>
                            <form id="select" action="${pageContext.request.contextPath}/mvc/employee/select" method="get">
                                <td><input name="selectEmployeeIdParam" value = "${employeeId}" size = "2"/></td>
                                <td><input name="selectEmployeeFirstNameParam" value = "${employeeFirstName}" size = "14"/></td>
                                <td><input name="selectEmployeeSurnameParam" value = "${employeeSurname}" size = "14"/></td>
                                <td><input name="selectEmployeeDateOfBornParam" value = "${employeeDateOfBorn}" type = "date" size = "14"/></td>
                                <td>
                                    <select name="selectEmployeePositionParam" form ="select" autofocus>
                                        <option disabled>Выберите должность</option>
                                        <option value="Manager">Manager</option>
                                        <option value="Developer">Developer</option>
                                        <option value="QA engineer">QA engineer</option>
                                    </select>
                                </td>
                                <td><button type="submit"> Select</button></td>
                            </form>
                            <form action="${pageContext.request.contextPath}/mvc/employee/list">
                                <td><button type="submit">All</button></td>
                            </form>
                        </tbody>
                    </table>
                <h2>Таблица сотрудников</h2>
                <table class="bordered">
                    <thead>
                         <tr>
                             <th>ID</th>
                             <th>Employee first name</th>
                             <th>Employee surname</th>
                             <th>Employee date of born</th>
                             <th>Employee position</th>
                             <th>All information</th>
                             <th>Edit</th>
                             <th>Delete</th>
                         </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${employeesList}" var="employee">
                        <tr>
                            <td>${employee.employeeId}</td>
                            <td>${employee.employeeFirstName}</td>
                            <td>${employee.employeeSurname}</td>
                            <td>${employee.employeeDateOfBorn}</td>
                            <td>${employee.employeePosition}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/mvc/employee/information" method="get">
                                    <input type="hidden" name="employeeIdParam" value="${employee.employeeId}" />
                                        <button type="submit"> All information</button>
                                </form>
                            </td>
                            <td>
                                <form action="${pageContext.request.contextPath}/mvc/employee/edit" method="get">
                                    <input type="hidden" name="editEmployeeIdParam" value="${employee.employeeId}" />
                                    <input type="hidden" name="editEmployeeFirstNameParam" value="${employee.employeeFirstName}" />
                                    <input type="hidden" name="editEmployeeSurnameParam" value="${employee.employeeSurname}" />
                                    <input type="hidden" name="editEmployeeDateOfBornParam" value="${employee.employeeDateOfBorn}" />
                                    <input type="hidden" name="editEmployeePositionParam" value="${employee.employeePosition}" />
                                    <button type="submit"> Edit</button>
                                </form>
                            </td>
                            <td>
                                <form action="${pageContext.request.contextPath}/mvc/employee/delete" method="get">
                                <input type="hidden" name="deleteEmployeeIdParam" value="${employee.employeeId}" />
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
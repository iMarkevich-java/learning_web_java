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
                        <li><a href="${pageContext.request.contextPath}/mvc/developers/list"> Developers</a></li>
                        <li><a href="${pageContext.request.contextPath}/mvc/projects/list">Projects</a></li>
                        <li><a href="${pageContext.request.contextPath}/mvc/address/list" class="active">Addresses</a></li>
                        <li><a href="${pageContext.request.contextPath}/mvc/companies/list">Companies</a></li>
				    </ul>
			</div>
			<div class="main">
			<!--Таблица-->
				<h2>Таблица адресов</h2>
    			<table class="bordered">
            	    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Country</th>
                            <th>Region</th>
                            <th>Locality</th>
                            <th>City</th>
                            <th>Street</th>
                            <th>House</th>
                            <th>Flat</th>
                            <th>Edit</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${addressesList}" var="address">
                        <tr>
                            <td>${address.addressId}</td>
                            <td>${address.getEmployee().getEmployeeFirstName()}</td>
                            <td>${address.getEmployee().getEmployeeSurname()}</td>
                            <td>${address.country}</td>
                            <td>${address.region}</td>
                            <td>${address.locality}</td>
                            <td>${address.city}</td>
                            <td>${address.street}</td>
                            <td>${address.house}</td>
                            <td>${address.flat}</td>
                            <td>
                                <form action="edit-address" method="get">
                                    <input type="hidden" name="editAddressIdParam" value="${address.addressId}" />
                                    <input type="hidden" name="editAddressCountryParam" value="${address.country}" />
                                    <input type="hidden" name="editAddressRegionParam" value="${address.region}" />
                                    <input type="hidden" name="editAddressLocalityParam" value="${address.locality}" />
                                    <input type="hidden" name="editAddressCityParam" value="${address.city}" />
                                    <input type="hidden" name="editAddressStreetParam" value="${address.street}" />
                                    <input type="hidden" name="editAddressHouseParam" value="${address.house}" />
                                    <input type="hidden" name="editAddressFlatParam" value="${address.flat}" />
                                    <button type="submit"> Edit</button>
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
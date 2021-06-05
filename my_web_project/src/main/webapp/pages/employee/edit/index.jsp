<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
    		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    		<title>Сделаем ваш первый бесплатный веб сайт</title>
    	</head>
    	<body>
    	<div class="wrapper">
            			<div class="header">
            				<div class="logo"><a href="">Ваш<span class="black">Сайт</span><span class="gray">.net</span></a><p>Ваш первый бесплатный веб сайт</p></div>
            				<ul class="nav">

        				</ul>
        			</div>

    	<div class="content">
            <div class="main">
                <div class="block">
					<h3>Изменение данных сотрудника</h3>
                    <p><img src="${pageContext.request.contextPath}/images/employeePhoto.jpg" height="384" width="216" class="leftimg">
						<div class="row">
						<form action="${pageContext.request.contextPath}/mvc/employee/edit" method="post" enctype="multipart/form-data">
						    <label><h3>Photo:</h3></label>
						    <div class="row">
						        <input type="file" name="image" id="image" accept="image/jpg" multiple="multiple">
						    </div>
						    <label><h3>Employee id:</h3></label>
                        	<div class="row">
                        	    <input name="updateEmployeeIdParam" readonly value = "${employee.employeeId}"/>
                        	</div>
							<label><h3>Employee first name:</h3></label>
							<div class="row">
							    <input name="updateEmployeeFirstNameParam" value = "${employee.employeeFirstName}"/>
							</div>
							<label><h3>Employee surname:</h3></label>
							<div class="row">
							    <input name="updateEmployeeSurnameParam" value = "${employee.employeeSurname}"/>
							</div>
							<label><h3>Employee date of born:</h3></label>
							<div class="row">
							    <input name="updateEmployeeDateOfBornParam" value = "${employee.employeeDateOfBorn}"/>
							</div>
							<label><h3>Employee position:</h3></label>
							<div class="row">
							    <input name="updateEmployeePositionParam" value = "${employee.employeePosition}"/>
							</div>
							    <button class="btn btn-danger" type="submit">Edit</button>
						</form>
						</p>

						<form action="${pageContext.request.contextPath}/mvc/employee/list" method="get">
                            <button class="btn btn-danger" type="submit">Exit</button>
                        </form>
                        </br>
						 <c:forEach items="${messageList}" var="message">
                            <br/>
                            <em><mark>${message}</mark></em>
                            <br/>
                         </c:forEach>


				</div>
				</div>
			</div>
			<div class="footer">
				<p>&copy; Footer content <a href="#">Link footer</a></p>
			</div>
		</div>
	</body>
</html>
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
    				</ul>
    			</div>
    	<div class="wrapper">
				<div class="main">
					<!--Формы-->
					<h2>Изменение данных компании</h2>
					<div class="row">
					</br>
						<form action="edit-company" method="post">
						    <label>ID:</label>
						    <div class="row">
							<input name="updateCompanyIdParam" type="text" readonly value="${editCompanyIdParam}"/>
							</div>
							<label>Company name:</label>
							<div class="row">
							<input name="updateCompanyNameParam" type="text" value="${editCompanyNameParam}"/>
							</div>
							<label>Company activity:</label>
							<div class="row">
							<input name="updateCompanyActivityParam" type="text" value="${editCompanyActivityParam}"/>
							</div>
							<button class="btn btn-danger" type="submit">Edit</button>
						</form>
						</br>
						<form action="companies" method="post">
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
		</div>
	</body>
</html>
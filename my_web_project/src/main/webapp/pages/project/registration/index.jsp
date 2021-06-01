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
					<h2>Регистрация проекта</h2>
						<div class="row">
						</br>
						<form action="registration-project" method="post">
							<label>Project name:</label>
							<div class="row">
							<input name="projectNameParam" type="text" placeholder="Input project name"></input>
							</div>
							<label>Budget project:</label>
							<div class="row">
							<input name="projectBudgetParam" type="text" placeholder="Input project budget"></input>
							</div>
							<label>Project time limit:</label>
							<div class="row">
							<input name="projectTimeLimitParam" type="text" placeholder="Input project time limit"></input>
							</div>
							<label>Project deadline:</label>
							<div class="row">
							<input name="projectDeadlineParam" type="text" placeholder="Input project deadline"></input>
							</div>
							<button class="btn btn-danger" type="submit">Add project</button>
						</form>
						</br>
						<form action="projects" method="post">
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
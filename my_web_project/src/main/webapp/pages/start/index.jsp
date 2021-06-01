<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />

		<title>Сделаем ваш первый бесплатный веб сайт</title>
	</head>
	<body>
		<div class="wrapper">
			<div class="header">
				<div class="logo"><a href="">Ваш<span class="black">Сайт</span><span class="gray">.net</span></a><p>Ваш первый бесплатный веб сайт</p></div>
				<ul class="nav">
					<li><a href="${pageContext.request.contextPath}/mvc/start" class="active">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/mvc/clients/list">Clients</a></li>
                    <li><a href="${pageContext.request.contextPath}/mvc/employee/list">Employees</a></li>
                    <li><a href="${pageContext.request.contextPath}/mvc/developers/list">Developers</a></li>
                    <li><a href="${pageContext.request.contextPath}/mvc/projects/list">Projects</a></li>
                    <li><a href="${pageContext.request.contextPath}/mvc/address/list">Addresses</a></li>
                    <li><a href="${pageContext.request.contextPath}/mvc/companies/list">Companies</a></li>
                </ul>
			</div>
			<div class="content">
				<div class="rightCol">
					<ul class="rightNav">
						<li><a href="#">Natus error sit voluptatem</a></li>
						<li><a href="#">Et veritatis quasi</a></li>
						<li><a href="#">Vitae dicta sunt explicabo</a></li>
						<li><a href="#">Nectun sed quia conseq</a></li>
						<li><a href="#">Natus error sit voluptatem</a></li>
						<li><a href="#">Vitae dicta sunt explicabo</a></li>
						<li><a href="#">Et veritatis quasi</a></li>
						<li><a href="#">Nectun sed quia conseq</a></li>
						<li><a href="#">Natus error sit voluptatem</a></li>
						<li><a href="#">Vitae dicta sunt explicabo</a></li>
					</ul>
					<div class="block">
						<h3>Lorem ipsum dolor sit</h3>
						<p><i>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.</i></p>
						<p><a href="#" class="more">Read more »</a></p>
					</div>
				</div>
				<div class="main">
					<h1>What we do</h1>
					<p>Lorem ipsum dolor sit amet, <a href="#" title="link">consectetur adipisicing elit</a>, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in <b title="bold">reprehenderit in voluptate velit</b> esse cillum dolore eu fugiat nulla pariatur. <i title="italic">Excepteur sint occaecat</i> cupidatat non proident, sunt in culpa qui officia deserunt.</p>
					<!--Изображения-->
					<h2>Примеры</h2>
					<p><img src="${pageContext.request.contextPath}/images/img1.jpg"><img src="${pageContext.request.contextPath}/images/img2.jpg"><img src="${pageContext.request.contextPath}/images/img3.jpg"></p>

					<!--Таблица-->
					<h2>Таблица счастливых клиентов</h2>
					<table class="bordered">
						<thead>
                        	<tr>
                        		<th>ID</th>
                        		<th>Client name</th>
                        		<th>Name project</th>
                        		<th>Address</th>
                        	</tr>
                        </thead>
                        <tbody>
                        	<c:forEach items="${clientsList}" var="client">
                                <tr>
                                    <td>${client.clientId}</td>
                                    <td>${client.nameClient}</td>
                                    <td>${client.nameProject}</td>
                                    <td>${client.address}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
					</table>
					<!--Формы-->
					<form action="registration-client" method="post">
						<div class="row">
							<button type="submit">Стать клиентом</button>
						</div>
					</form>
				</div>
			</div>
			<div class="footer">
				<p>&copy; Footer content <a href="#">Link footer</a></p>
			</div>
		</div>
	</body>
</html>
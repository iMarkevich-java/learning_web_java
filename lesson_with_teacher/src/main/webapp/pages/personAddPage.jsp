<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head></head>
    <body>
        <h3>Person add page</h3>
        <c:forEach items="${messageList}" var="message">
        <br/>
        ${message}
        <br/>
        </c:forEach>

         <form action="${pageContext.request.contextPath}/mvc/person/add" method="post">
            <input type="text" name="personIdParam" value="" />
            <input type="text" name="personNameParam" value="Kiril" required size="10" placeholder="Username" minlength="4" maxlength="8" pattern="[A-Za-z]{4,8}"/>
            <input type="number" name="personAgeParam" value="30" />
            <button type="submit">save</button>
         </form>

         <form action="list" method="get">
            <button type="submit">cancel</button>
         </form>

    </body>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head></head>
    <body>
        <h3>Person edit page</h3>

         <form action="${pageContext.request.contextPath}/mvc/person/edit" method="post">
            <input type="text" readonly name="updatedPersonIdParam" value="${personIdParam}" />
            <input type="text" name="updatedPersonNameParam" value="${personNameParam}" />
            <input type="text" name="updatedPersonAgeParam" value="${personAgeParam}" />
            <button type="submit">save</button>
         </form>

         <form action="list" method="get">
            <button type="submit">cancel</button>
         </form>

    </body>
</html>
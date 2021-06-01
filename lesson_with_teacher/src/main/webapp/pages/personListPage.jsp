<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head></head>
    <body>
    <h3>Person list page</h3>
    ${message}
    </br>
    </br>
    </br>
     <table border="1" class="table table-hover">
             <tr>
                 <th>ID</th>
                 <th>NAME</th>
                 <th>AGE</th>
             </tr>
             <c:forEach items="${personList}" var="person">
             <tr>
                 <td>${person.personId}</td>
                 <td>${person.name}</td>
                 <td>${person.age}</td>
                 <td>
                    <form action="${pageContext.request.contextPath}/mvc/person/edit" method="get">
                        <input type="hidden" name="editIdParam" value="${person.personId}" />
                        <input type="hidden" name="editNameParam" value="${person.name}" />
                        <input type="hidden" name="editAgeParam" value="${person.age}" />
                        <button type="submit"> edit</button>
                    </form>
                 </td>
                 <td>
                 <form action="${pageContext.request.contextPath}/mvc/person/delete" method="get">
                    <input name="deleteIdParam" type="hidden" value="${person.personId}"/>
                    <button type="submit"> delete</button>
                 </form>
                 </td>
             </tr>
             </c:forEach>
         </table>
         <form action="${pageContext.request.contextPath}/mvc/person/add" method="get">
            <button type="submit"> add person</button>
         </form>
    </body>
</html>
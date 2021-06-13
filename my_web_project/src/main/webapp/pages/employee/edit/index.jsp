<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
						    <form:form id="edit" action="${pageContext.request.contextPath}/mvc/employee/edit" method="post" enctype="multipart/form-data" modelAttribute="webParam">
                        	    <table>
                        		    <tr height="100">
                        		        <td valign="top">
                        		            <form:input path="updateEmployeeIdParam" name="updateEmployeeIdParam" type="hidden" value = "${employee.employeeId}"/>
                        		            <div class="row">
                        		            <h3>Данные:<h3>
                        		            </div>
                        		            <label>Фото:</label>
                                            <div class="row">
                                                <form:input type="file" path="updateEmployeePhotoParam" accept="image/jpg" multiple="multiple"/>
                                            </div>
                                            <label>Имя:</label>
                                            <div class="row">
                                                <form:input path="updateEmployeeFirstNameParam" name="updateEmployeeFirstNameParam" type="text" value = "${employee.employeeFirstName}" placeholder="Введите имя"/>
                                            </div>
                                            <label>Фамилия:</label>
                                            <div class="row">
                                                <form:input path="updateEmployeeSurnameParam" name="updateEmployeeSurnameParam" type="text" value = "${employee.employeeSurname}" placeholder="Введите фамилию"/>
                                            </div>
                                            <label>Дата рождения:</label>
                                            <div class="row">
                                                <form:input path="updateEmployeeDateOfBornParam" name="updateEmployeeDateOfBornParam" type="date" value = "${employee.employeeDateOfBorn}" placeholder="Введите дату рождения"/>
                                            </div>
                                            <label>Должность:</label>
                                            <div class="row">
                                                <form:select path="updateEmployeePositionParam" name="updateEmployeePositionParam" form ="edit">
                                                <option value="${employee.employeePosition}">${employee.employeePosition}</option>
                                                <option value="Manager">Manager</option>
                                                <option value="Developer">Developer</option>
                                                <option value="QA engineer">QA engineer</option>
                                                </form:select>
                                            </div>

                                                <c:set var = "manager" scope = "session" value = "Manager"/>
                                                <c:if test = "${manager == employee.employeePosition }">
                                                <label>Отдел:</label>
                                                    <div class="row">
                                                        <form:select path="updateDepartmentParam" name="updateDepartmentParam" form ="edit">
                                                        <option value="${employee.manager.managerDepartment}">${employee.manager.managerDepartment}</option>
                                                        <option value="Economic">Economic</option>
                                                        <option value="Robotic">Robotic</option>
                                                        <option value="Industrial">Industrial</option>
                                                        </form:select>
                                                    </div>
                                                <label>Стаж:</label>
                                                    <div class="row">
                                                        <form:input path="updateExperienceParam" name="updateExperienceParam" type="number" value = "${employee.manager.managerExperience}"/>
                                                    </div>
                                                </c:if>
                                                <c:set var = "developer" scope = "session" value = "Developer"/>
                                                <c:if test = "${developer == employee.employeePosition }">
                                                <label>Отдел:</label>
                                                    <div class="row">
                                                        <form:select path="updateDepartmentParam" name="updateDepartmentParam" form ="edit">
                                                        <option value="${employee.developer.developerDepartment}">${employee.developer.developerDepartment}</option>
                                                        <option value="Economic">Economic</option>
                                                        <option value="Robotic">Robotic</option>
                                                        <option value="Industrial">Industrial</option>
                                                        </form:select>
                                                    </div>
                                                <label>Стаж:</label>
                                                    <div class="row">
                                                        <form:input path="updateExperienceParam" name="updateExperienceParam" type="number" value = "${employee.developer.developerExperience}"/>
                                                    </div>
                                                </c:if>
                                                <c:set var = "qaEngineer" scope = "session" value = "QA engineer"/>
                                                <c:if test = "${qaEngineer == employee.employeePosition }">
                                                <label>Отдел:</label>
                                                    <div class="row">
                                                        <form:select path="updateDepartmentParam" name="updateDepartmentParam" form ="edit">
                                                        <option value="${employee.qaEngineer.qaEngineerDepartment}">${employee.qaEngineer.qaEngineerDepartment}</option>
                                                        <option value="Economic">Economic</option>
                                                        <option value="Robotic">Robotic</option>
                                                        <option value="Industrial">Industrial</option>
                                                        </form:select>
                                                    </div>
                                                <label>Стаж:</label>
                                                    <div class="row">
                                                        <form:input path="updateExperienceParam" name="updateExperienceParam" type="number" value = "${employee.qaEngineer.qaEngineerExperience}"/>
                                                    </div>
                                                </c:if>
                                        </td>
                                        <td valign="top">
                                           <div class="row">
                                           <h3>Адрес:<h3>
                                           </div>
                                                <form:input path="updateAddressIdParam" name="updateAddressIdParam" type="hidden" value = "${employee.address.addressId}"/>
                                           <label>Страна:</label>
                                           <div class="row">
                                               <form:input path="updateAddressCountryParam" name="updateAddressCountryParam" type="text" value = "${employee.address.country}" placeholder="Введите название страны"/>
                                           </div>
                                           <label>Область:</label>
                                           <div class="row">
                                               <form:input path="updateAddressRegionParam" name="updateAddressRegionParam" type="text" value = "${employee.address.region}" placeholder="Введите название области"/>
                                           </div>
                                           <label>Район:</label>
                                           <div class="row">
                                               <form:input path="updateAddressLocalityParam" name="updateAddressLocalityParam" type="text" value = "${employee.address.locality}" placeholder="Введите название района"/>
                                           </div>
                                           <label>Город (населенный пункт):</label>
                                           <div class="row">
                                               <form:input path="updateAddressCityParam" name="updateAddressCityParam" type="text" value = "${employee.address.city}" placeholder="Введите название города"/>
                                           </div>
                                           <label>Улица:</label>
                                           <div class="row">
                                               <form:input path="updateAddressStreetParam" name="updateAddressStreetParam" type="text" value = "${employee.address.street}" placeholder="Введите название улицы"/>
                                           </div>
                                           <label>Дом:</label>
                                           <div class="row">
                                               <form:input path="updateAddressHouseParam" name="updateAddressHouseParam" type="number" value = "${employee.address.house}" placeholder="Введите название дома"/>
                                           </div>
                                           <label>Квартира (офис):</label>
                                           <div class="row">
                                               <form:input path="updateAddressFlatParam" name="updateAddressFlatParam" type="number" value = "${employee.address.flat}" placeholder="Введите название квартиры"/>
                                           </div>
                                        </td>
                                    </tr>
                                <table>
                                <div class="row">
                                   <button class="btn btn-danger" type="submit">Edit</button>
                                </div>
                            </form:form>
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
<!DocType html>
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
            </div>
			<div class="content">
                <div class="main">
                    <div class="block">
					    <h3>Регистрация сотрудника</h3>
					    <p>
				        <div class="wrapper">
					        <form:form id="registration" action="${pageContext.request.contextPath}/mvc/employee/registration" method="post" enctype="multipart/form-data" modelAttribute="createWebParam">
					            <table >
					                <tr height="100">
					                    <td valign="top">
					                        <div class="row">
		    			                    <h3>Данные:<h3>
		    			                    </div>
			    		                    <label>Фото:</label>
                                            <div class="row">
                                                <form:input type="file" path="employeePhotoParam" accept="image/jpg" multiple="multiple"/>
                                            </div>
                                            <label>Имя:</label>
                                            <div class="row">
                                                <form:input path="employeeFirstNameParam" type="text" value = "${employeeFirstName}" placeholder="Введите имя"/>
                                            </div>
                                            <label>Фамилия:</label>
                                            <div class="row">
                                                <form:input path="employeeSurnameParam" type="text" value = "${employeeSurname}" placeholder="Введите фамилию"/>
                                            </div>
                                            <label>Дата рождения:</label>
                                            <div class="row">
                                                <form:input path="employeeDateOfBornParam" type="date" value = "${employeeDateOfBorn}"/>
                                            </div>
                                            <label>Должность:</label>
                                            <div class="row">
                                                <form:select path="employeePositionParam" form ="registration">
                                                <option disabled>Выберите должность</option>
                                                <option value="Manager">Manager</option>
                                                <option value="Developer">Developer</option>
                                                <option value="QA engineer">QA engineer</option>
                                                </form:select>
                                            </div>
                                            <label>Отдел:</label>
                                            <div class="row">
                                                <form:select path="departmentParam" form ="registration">
                                                <option disabled>Выберите тдел</option>
                                                <option value="Economic">Economic</option>
                                                <option value="Robotic">Robotic</option>
                                                <option value="Industrial">Industrial</option>
                                                </form:select>
                                            </div>
                                            <label>Стаж:</label>
                                            <div class="row">
                                                <form:input path="experienceParam" type="number" value = "${experienceParam}"/>
                                            </div>
                                        </td>
							            <td valign="top">
							                <div class="row">
                                            <h3>Адрес:<h3>
                                            </div>
                                            <label>Страна:</label>
                                            <div class="row">
                                                <form:input path="addressCountryParam" type="text" value = "${addressCountry}" placeholder="Введите название страны"/>
                                            </div>
                                            <label>Область:</label>
                                            <div class="row">
                                                <form:input path="addressRegionParam" type="text" value = "${addressRegion}" placeholder="Введите название области"/>
                                            </div>
                                            <label>Район:</label>
                                            <div class="row">
                                                <form:input path="addressLocalityParam" type="text" value = "${addressLocality}" placeholder="Введите название района"/>
                                            </div>
                                            <label>Город (населенный пункт):</label>
                                            <div class="row">
                                                <form:input path="addressCityParam" type="text" value = "${addressCity}" placeholder="Введите название города"/>
                                            </div>
                                            <label>Улица:</label>
                                            <div class="row">
                                                <form:input path="addressStreetParam" type="text" value = "${addressStreet}" placeholder="Введите название улицы"/>
                                            </div>
                                            <label>Дом:</label>
                                            <div class="row">
                                                <form:input path="addressHouseParam" type="number" value = "${addressHouse}" placeholder="Введите название дома"/>
                                            </div>
                                            <label>Квартира (офис):</label>
                                            <div class="row">
                                                <form:input path="addressFlatParam" type="number" value = "${addressFlat}" placeholder="Введите название квартиры"/>
                                            </div>
                        			    </td>
                       			    </tr>
                                <table>
                                 <div class="row">
                                    <button class="btn btn-danger" type="submit">add employee</button>
                                 </div>
                            </form:form>
                        </div>
                        <div class="row">
                            <form action="${pageContext.request.contextPath}/mvc/employee/list" method="get">
                                <button class="btn btn-danger" type="submit">Exit</button>
                            </form>
                        </div>
                    </div>
                    </p>
        			<c:forEach items="${messageList}" var="message">
                        <div class="row">
                            <em><mark>${message}</mark></em>
                        </div>
                    </c:forEach>
				</div>
			</div>
		</div>
		<div class="footer">
		    <p>&copy; Footer content <a href="#">Link footer</a></p>
		</div>
	</body>
</html>
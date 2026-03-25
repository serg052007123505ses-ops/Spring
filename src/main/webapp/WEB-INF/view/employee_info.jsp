<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Employee Info</h2>
<br>

<form:form action = "saveEmployee" modelAttribute="employee">

    <form:hidden path="id"/> <%--Скрытое поле для понимания id какого работника мы изменяем--%>

    Name <form:input path="name"/>
    <br><br>

    Surname <form:input path="surname"/>
    <br><br>

    Department <form:input path="department"/>
    <br><br>

    Salary <form:input path="salary"/>
    <br><br>
    <input type="submit" value="OK">

    <br>
    <a href="${pageContext.request.contextPath}/">Back to list</a>

</form:form>
</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Settings</h3>
<form:form action="/info" method="post" modelAttribute= "setting">
    <table>
        <tr>
            <td><b>Language: </b></td>
            <td colspan="2">
                <form:select path="language">
                    <form:options items="${languages}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><b>Page Size: </b></td>
            <td colspan="2">
                    Show:
                    <form:select path="pageSize">
                        <form:options items="${pageSizes}"></form:options>
                    </form:select>
                     email per page
            </td>
        </tr>
        <tr>
            <td><b>Spams filter: </b></td>
            <td colspan="2">
                <form:checkbox path="spam" value="1"></form:checkbox>
                Enable spams filters
            </td>
        </tr>
        <tr>
            <td><b>Signature: </b></td>
            <td colspan="2">
                <form:textarea path="signature"></form:textarea>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="update"></td>
            <td><input type="submit" value="cancle"></td>
        </tr>
    </table>
</form:form>
</body>
</html>

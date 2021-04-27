<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/search">
    <table>
        <tr>
            <td>English:</td>
            <td><input type="text" name="searchString"></td>
        </tr>
        <tr>
            <td>Mean: </td>
            <td>${result}</td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Search"></td>
        </tr>
    </table>
</form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Setting Mail</h3>
<table>
    <tr>
        <td><b>Language: </b></td>
        <td>${setting.language}</td>
    </tr>
    <tr>
        <td><b>Page Size:  </b></td>
        <td>${setting.pageSize}</td>
    </tr>
    <tr>
        <td><b>Enable Spams:  </b></td>
        <td>${setting.spam}</td>
    </tr>
    <tr>
        <td><b>Signature: </b></td>
        <td>${setting.signature}</td>
    </tr>
</table>
</body>
</html>

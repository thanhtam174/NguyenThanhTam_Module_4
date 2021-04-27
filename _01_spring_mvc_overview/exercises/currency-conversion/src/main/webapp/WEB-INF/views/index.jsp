<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Conversion</title>
</head>
<body>
<form action="/conversion">
  <table>
    <tr>
      <td>USD: </td>
      <td><input type="text" name="usd"></td>
    </tr>
    <tr>
      <td>Rate: </td>
      <td><input type="text" name="rate"></td>
    </tr>
    <tr>
      <td>VND: </td>
      <td>${vnd} </td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="OK"></td>
    </tr>
  </table>
</form>
</body>
</html>

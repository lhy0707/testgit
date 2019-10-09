<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/transfer">
  转出账户:<input type="text" name="out"><br>
  转入账户:<input type="text" name="in"><br>
  转账金额:<input type="text" name="money"><br>
  <input type="submit" value="转账">
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<html>
<head>
<title>Home</title>

</head>
<body>
	  QR CODE
 <form action="test.qr" method="get">
    <input type="text" name="url" value="http://192.168.30.135:8124/qrPractice/result.att?id=${loginUser.id}"/><button type="submit">create</button>
    <h1>${loginUser.id}</h1>
  </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form enctype="multipart/form-data" action="upload/upload.mvc" method="post">
		<input type="file" name="myfile" style="width: 450px; height: 25px" size="54" /><br/>
		<input type="submit" value="上传">
	</form>
	<form action="upload/download.mvc" method="get">
		<input type="submit" value="下载">
	</form>
</body>
</html>
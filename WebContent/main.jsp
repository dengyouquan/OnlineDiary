<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
 		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
 		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
 		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script><title>online diary login!</title>	
		<style type="text/css">
	.diary{
		background: url("images/diary.jpg");
	}
</style>
	</head>
	
	<!-- <iframe src="top.html" width="100%"  height="30%" ></iframe>
	<iframe src="left.html" width="25%"  height="100%"  ></iframe> -->

	<frameset rows="20%,80%">
		<frame src="top.jsp">
		<frameset cols="25%,75%">
			<frame src="left.jsp">
			<frame src="diarycontent.jsp" id="workSpace" name="workSpace" class="diary">
		</frameset>
	</frameset>
</html>

	
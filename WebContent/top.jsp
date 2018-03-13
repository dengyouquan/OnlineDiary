<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.iotek.entity.AuthorBean"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.top{
		margin:10;
		background: url("images/bird.jpg");
	}
	h1{
		text-align: center;
	}
	span{
		text-align: center;
	}
</style>
</head>
<body class="top">
	<div >
		<h1>欢迎使用在线日志系统</h1>
		<%-- <p>${sessionScope.AuthorBean }</p> --%>
		<span>
			<%
				AuthorBean authorBean = (AuthorBean)request.getSession().getAttribute("curUser");
				if(authorBean!=null){
					out.print("用户："+authorBean.getAnthorname()+" 登录名："+authorBean.getLoginname());
				}
			%>
		</span>
		
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
 <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
 <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script><title>online diary login!</title>
 
 <style type="text/css">
 	body{
 		background: url("images/background.jpg") no-repeat left; 
 	}
 	#main_container{
 		text-align: center;
 		margin-top: 100px;
 		margin-left: 400px;
 		margin-right: 400px;
 		padding-top:30px;
 		padding-bottom:30px;
 		background-image: url("images/bluesky.jpg");
 	}
 </style>
</head>
<body>
	<div id="main_container">
		<div>
			<h3>您好！欢迎来到本系统！</h3>
			<a href="register.jsp" class="regist">新用户注册</a>
			<a href="#" class="forget_pwd">忘记密码</a><br/>
			<!-- 记得action加上userServlet，要不然没有效果 ，错了很久才发现-->
			<form action="userServlet" method="post">
				<fieldset>
				
					<!-- <dl> 标签定义了定义列表
					<dt> （定义列表中的项目）
					<dd> （描述列表中的项目） -->
					
					<dl>
						<dt><label for="email">登录账号：</label></dt>
						<dd><input type="text" name="login" id="email" size="26"/></dd>
						<dt><label for="password">登录密码：</label></dt>
						<dd><input type="password" name="passwords"  id="passwords" size="26"/>
						<dt><label></label><br/></dt>
						<dd><input type="checkbox" name="remember" id="remember" value=""/>
								<label class="check_label">记住密码</label>
						</dd>
						<dt><label></label><br/></dt>
						<dd class="submit"><input type="submit" name="submit" id="submit" value="登录" onclick="l"/>
					</dl>
				</fieldset>
			</form>
			<%
			String messages = (String)request.getAttribute("loginError");
			if(messages!=null&&!"".equals(messages)){
				out.print(messages);
			}
			%>
		</div>
	</div>
</body>
</html>
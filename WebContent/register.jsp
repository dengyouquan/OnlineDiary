<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>user register</title>
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
 	}
 </style>
</head>
<body>
	<div id="main_container">
		<div class="login_form">
			<h3>您好！欢迎您注册成为云日记用户！</h3>
			
			<form action="registerServlet" method="post" class="niceform">
				<fieldset>
					<dl>
						<dt><label for="uname">用户姓名：</label></dt>
						<dd><input type="text" name="uname" id="uname" size="26"/></dd>
						<dt><label for="utype">用户类型：</label>
						<dd>
							<select id="utype" name="utype">
								<option value="常规用户" selected="selected">常规用户</option>
								<option value="其他用户" >其他用户</option>
							</select>
						</dd>
						<dt><label for="uaccount">用户账号：</label>
						<dd><input type="text" name="uaccount" id="uaccount" size="26"/></dd>
						<dt><label for="upassword">用户密码：</label>
						<dd><input type="text" name="upassword" id="upassword" size="26"/></dd>
						<dt><label for="uemail">电子邮箱：</label>
						<dd><input type="password" name="uemail" id="uemail" size="26"/></dd>
						<dt><label for="umemo">备注说明：</label>
						<dd><textarea id="umemo" name="umemo" rows="3" cols="24"></textarea></dd>
						
						<dt></dt>
						<dd class="submit">
							<input type="submit" name="submit" id="register" value="注册登记" onclick=""/>
							<input type="submit" name="submit" id="into" value="进入系统" onclick="login.jsp"/>
						</dd>
					</dl>
				</fieldset>
			</form>
			<%
				String messages = (String)request.getAttribute("loginError");
				if(messages!=null&&!"".equals(messages)){
					out.print(messages);
				}
				String register = (String)request.getAttribute("registerError");
				if(register!=null&&!"".equals(register)){
					out.print(register);
				}
			%>
		</div>
	</div>
</body>
</html>
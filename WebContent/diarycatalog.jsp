<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.iotek.entity.AuthorBean"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
 <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
 <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script><title>online diary login!</title>
<title>diary catalog</title>
<style type="text/css">
	body{
		background: url("images/book.jpg");
		text-align: center;
		padding-top: 30px;
		padding-bottom: 50px;
	}
	table {
		margin: auto;
	}
</style>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript">
	var xmlhttp = createXMLHttpRequest();
	function addCatalog(){
		//document.getElementById("uname").value
		var args = "uname="+document.getElementById("uname").value
		+"&utype="+document.getElementById("utype").value
		+"&umemo="+document.getElementById("umemo").value;
		var url = "catalogServlet";
		
		document.getElementById("ajax").innerHTML=url+"?"+args;
		
		xmlhttp.onreadystatechange=function()
		  {
		    if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
		    	//ajax还是什么
		      document.getElementById("ajax").innerHTML=xmlhttp.responseText;
		    }
		  }
		
		xmlhttp.open("GET",url+"?"+args,true);
		xmlhttp.send();
	}
	function test(){
		document.getElementById("ajax").innerHTML="test";
	}
</script>
</head>
<body>
	<div id="main_container">
		<div class="login_form">
			<h3>日志分类管理</h3>
			
			<form action="catalogServlet" method="post" class="niceform">
				<fieldset> 
					<dl>
						<dt><label for="uname">类别名称：</label></dt>
						<dd><input type="text" name="uname" id="uname" size="26"/></dd>
						<dt><label for="utype">类别状态：</label></dt>
						<dd>
							<select id="utype" name="utype">
								<option value="激活" selected="selected">激活</option>
								<option value="注销" >注销</option>
							</select>
						</dd>
						<dt><label for="umemo">分类备注：</label>
						<dd><textarea id="umemo" name="umemo" rows="3" cols="24"></textarea></dd>
						<dt></dt>
						<dd class="submit">
							<input type="submit" name="submit" id="submit" value="新增保存" onclick="addCatalog()"/>&nbsp;
							<input type="submit" name="submit" id="submit" value="修改保存" onclick=""/>&nbsp;
							<input type="submit" name="submit" id="submit" value="删除分类" onclick=""/>
						</dd>
					</dl>
				</fieldset>
			</form>
			<span id="ajax"></span>
			<p>
				<%
					AuthorBean authorBean = (AuthorBean)request.getSession().getAttribute("curUser");
					if(authorBean!=null){
						out.print("用户："+authorBean.getAnthorname()+" 登录名："+authorBean.getLoginname());
					}
				%>
			</p>
			<div id="catList"  class="catList">
					<table border="1">
						<thead>
							<tr>
								<th>类别名称</th>
								<th>类别状态</th>
								<th>备注说明</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox" id="manager"/></td>
								<td>管理类</td>
								<td>激活</td>
								<td>所有管理类日志</td>
							</tr>
							<tr>
								<td><input type="checkbox" id="science"/></td>
								<td>科技类</td>
								<td>激活</td>
								<td>所有科技类日志</td>
							</tr>
							<tr>
								<td><input type="checkbox" id="entertainment"/></td>
								<td>娱乐类</td>
								<td>激活</td>
								<td>所有娱乐类日志</td>
							</tr>
						</tbody>
						<tfoot></tfoot>
					</table>
				</div>
		</div>
	</div>
</body>
</html>
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
<title>diary content</title>
<style type="text/css">
	body{
		background: url("images/diary.jpg");
		text-align: center;
		padding-top: 30px;
		padding-bottom: 50px;
	}
	table {
		margin: auto;
	}
</style>
</head>
<body>
	<div id="main_container">
		<div class="login_form">
			<h3>我的日志管理</h3>
			
			<form action="diarycatalog.jsp" method="post" class="niceform">
				<fieldset>
					<dl>
						<dt><label for="dtitle">日记标题：</label></dt>
						<dd><input type="text" name="dtitle" id="dtitle" size="36"/></dd>
						<dt><label for="dtype">日记类别：</label></dt>
						<dd>
							<select id="dtype" name="dtype">
								<option value="随笔日记" selected="selected">随笔日记</option>
								<option value="网摘日记" >网摘日记</option>
								<option value="读书日记" >读书日记</option>
								<option value="其他日记" >其他日记</option>
							</select>
						</dd>
						<dt><label for="dpublish">是否公布：</label></dt>
						<dd>
							<select id="dpublish" name="dpublish">
								<option value="个人私有" selected="selected">个人私有</option>
								<option value="网络公布" >网络公布</option>
								<option value="有限分享" >有限分享</option>
								<option value="其他" >其他</option>
							</select>
						</dd>
						<dt><label for="dcontent">日志内容：</label>
						<dd><textarea id="dcontent" name="dcontent" rows="6" cols="24"></textarea></dd>
						<dt></dt>
						<dd class="submit">
							<input type="submit" name="submit" id="submit" value="新增保存" onclick=""/>&nbsp;
							<input type="submit" name="submit" id="submit" value="修改保存" onclick=""/>&nbsp;
							<input type="submit" name="submit" id="submit" value="删除分类" onclick=""/>
						</dd>
					</dl>
				</fieldset>
			</form>
		</div>
		<div id="catList"  class="catList">
					<table border="1">
						<thead>
							<tr>
								<th>标题</th>
								<th>类别</th>
								<th>状态</th>
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
</body>
</html>
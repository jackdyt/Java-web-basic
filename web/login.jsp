<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<link rel="icon" href="images/search.gif" type="img/x-ico" />
<link href="css/login.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=path%>/js/jquery-3.3.1.min.js"></script>
<body>
	<div id="top"></div> 
	<div id="main">
		<img src="images/login.jpg" id="main_bg"/>
		<div id="login_block">
			<form action="/login" method="post" id="loginForm">
				<table border="0">
					<tr>
						<td class="title">UserName:</td>
						<td class="input">
							<input type="text" name="username" id="username" class="login_input"/>
						</td>
					</tr>
					<tr>
						<td class="title">Password:</td>
						<td class="input">
							<input type="password" name="password" id="password" class="login_input"/>
						</td>
					</tr>
					<tr>
						<td class="title">User Type:</td>
						<td class="input">
							<input type="radio" name="type" value="reader" checked="checked"/>&nbsp;&nbsp;Reader&nbsp;&nbsp;
							<input type="radio" name="type" value="admin"/>&nbsp;&nbsp;Adminstrator
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input class="btn" type="submit" value="Login"/>
							<div class="btn" id="reset">Reset</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>
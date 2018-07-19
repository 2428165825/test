<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<s:form action="doLogin.action" method="post">
			用户名:<s:textfield name="name" value="" label="用户名"></s:textfield><br/>
			密&nbsp;&nbsp;&nbsp;&nbsp;码:<s:password name="password" label="密码"></s:password><br/>
			&nbsp;&nbsp;&nbsp;&nbsp;<s:checkbox name="manager" label="以管理员登录"></s:checkbox>以管理员登录<br/>
			<s:submit value="登录"></s:submit>
		</s:form>
	</div>
</body>
</html>
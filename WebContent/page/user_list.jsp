<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	使用iterator标签遍历用户集合:
			<table border="1">
  				<tr>
			    	<th>用户名</th>
    				<th>密码</th>
  				</tr>
				<s:iterator value="list">
					<tr>
						<td>
    					<s:property value="name"/>
    					</td>
    					<td>
    					<s:property value="password"/>
    					</td>
					</tr>
    			</s:iterator>
			</table>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>青鸟租房 -发布房屋信息</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<img src="images/logo.gif" />
		</div>

	</div>
	<div id="regLogin" class="wrap">
		<div class="dialog">
			<dl class="clearfix">
				<dt>新房屋信息发布</dt>
				<dd class="past">填写房屋信息</dd>

			</dl>
			<div class="box">
				<s:form action="add.action">
					<div class="infos">
						<table class="field">
							<tr>
								<td class="field">编 号：</td>
								<td><s:textfield cssClass="text" key="id" name="house.id" /></td>
							</tr>
							<tr>
								<td class="field">标 题：</td>
								<td><s:textfield cssClass="text" key="title"
										name="house.title" /></td>
							</tr>
							<tr>
								<td class="field">户 型：</td>
								<td><select class="text" name="house.type.id">
									<option value="1000">一室一厅</option>
									<option value="1001">一室两厅</option>
									<option value="1002">两室一厅</option>
									<option value="1003">两室两厅</option>
									<option value="1004">三室一厅</option>
									<option value="1005">三室两厅</option>
									<option value="1006">四室一厅</option>
									<option value="1007">四室两厅</option>
									<option value="1008">四室三厅</option>
									
									<option value="1">环河公寓</option>
									<option value="2">两室一厅一厕</option>	
									<option value="3">三室一厅一厕</option>
									<option value="4">海景房</option>
								</td>
							</tr>
							<tr>
								<td class="field">面 积：</td>
								<td><s:textfield cssClass="text" key="floorage"
										name="house.floorage" /></td>
							</tr>
							<tr>
								<td class="field">价 格：</td>
								<td><s:textfield cssClass="text" key="price"
										name="house.price" /></td>
							</tr>

							<tr>
								<td class="field">房屋发布日期：</td>
								<td><s:textfield cssClass="text" key="PUBDATE"
										name="house.pubDate" /></td>
							</tr>

							<tr>
								<td class="field">位 置：</td>
								<td>区：<select class="text" name="house.district.id">
										<option value="1001">东城区</option>
										<option value="1002">西城区</option>
										<option value="1000">丰台区</option>
										<option value="1004">海淀区</option>
										<option value="1006">朝阳区</option>
										<option value="1112">麋麓市</option>
										<option value="5510">长沙市</option>
										<option value="5551">邵东县</option>
										<option value="5630">郴州市</option>
										<option value="5634">桂阳县</option>
										<option value="5637">嘉禾县</option>
										<option value="6420">三亚市</option>
										
								</select> 街：<select class="text" name="house.streets.id">
										<option value="1000">知春路大街</option>
										<option value="1001">中关村大街</option>
										<option value="1002">学院路大街</option>
										<option value="1003">朝阳路大街</option>
										<option value="1660">荷花路</option>
										<option value="1661">东江路</option>
										<option value="1662">神话路</option>
										<option value="1663">天堂路</option>

								</select>

								</td>
							</tr>
							<tr>
								<td class="field">联系方式：</td>
								<td><s:textfield cssClass="text" key="contact"
										name="house.contact" /></td>
							</tr>
							<tr>
								<td class="field">详细信息：</td>
								<td><textarea name="house.description"></textarea></td>
							</tr>
						</table>
						<div class="buttons">
							<s:submit value="立即发布" />
						</div>
					</div>
				</s:form>
			</div>
		</div>
	</div>
	<div id="footer" class="wrap">
		<dl>
			<dt>青鸟租房 &copy; 2010 北大青鸟 京ICP证1000001号</dt>
			<dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
		</dl>
	</div>
</body>
</html>
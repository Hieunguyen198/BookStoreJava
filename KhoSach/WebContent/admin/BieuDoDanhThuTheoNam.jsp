<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<%@ include file="Nav.jsp"%>
<div class="container">
<h2 id="titleThongKe"
		style="padding-bottom: 37px; font-size: 23px; text-align: center; padding-top: 16px;">
		BIỂU ĐỒ DOANH THU THEO NĂM
	</h2>
	<%String doanhThu = (String) request.getAttribute("doanhThu");%>
	<div class="card shadow mb-4">
		<div class="card-body">
             <canvas id="line-chart" width="1500" height="450"></canvas>
             <input type="hidden" value="<%=doanhThu%>" id='doanhThu'>
</div>
</div>
        </div>
      
       
	<%@ include file="Footer.jsp"%>
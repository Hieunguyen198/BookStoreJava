<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<a><%=(int)session.getAttribute("maKhachHang")%></a>
<a><%=request.getAttribute("tenKhachHang")%></a>
<a><%=request.getAttribute("diaChi")%></a>
<a><%=request.getAttribute("email")%></a>
<a><%=request.getAttribute("soDienThoai")%></a>
<%@ include file="Footer.jsp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.AdminBEAN"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<%@ include file="Nav.jsp"%>
<%
	ArrayList<AdminBEAN> dsAdmin = (ArrayList<AdminBEAN>) request.getAttribute("dsAdmin");
%>
<div class="container">
	<div class="row shadow">
		<div class="col-sm-12">
			<div class="px-2">
				<h4 class="title mt-4 mb-5 text-center text-uppercase text-danger">Thêm	Admin</h4>
				<form action="ThemAdminSevlet" method="POST">
				<div class="row">
					<div class="form-group col-4">
						<label>Tên Đăng Nhập:</label>
						<input type="text" class="form-control" name="txtTenDangNhap">
					</div>
					<div class="form-group col-3">
						<label>Mật Khẩu:</label>
						<input type="text" class="form-control" name="txtMatKhau">
					</div>
				</div>
				<input type="submit" name="btnTao" value="Thêm"	class="btn btn-success mb-3">
				</form>
			</div>
		</div>
	</div>
</div>
	<%@ include file="Footer.jsp"%>
<%@page import="model.bean.KhachHangBEAN"%>
<%@page import="model.bean.SachBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<%@ include file="Nav.jsp"%>
<div class="container-fluid">
	<h2 style="text-align: right;">
		<a class="text-white btn btn-success mr-3"
			href="ThemSachServlet">Thêm sách</a>
	</h2>
	<h1 class="h3 mb-2 text-gray-800">Danh sách sách</h1>
	<div class="card shadow mb-4">
		<div class="card-body">
			<div class="table-responsive table-hover">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Mã khách hàng</th>
							<th>Tên khách hàng</th>
							<th>Tên đăng nhập</th>
							<th>Email</th>
							<th>Số điện thoại</th>
							<th>Địa chỉ</th>
							<th>Ngày sinh</th>
							<th>Giới tính</th>
							<th style="text-align: center;">Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<KhachHangBEAN> listKhachHang = (ArrayList<KhachHangBEAN>) request.getAttribute("dsKhachHang");
							for (KhachHangBEAN khachHang : listKhachHang) {
						%>
						<tr>
							<td><%=khachHang.getMaKhachHang()%></td>
							<td><%=khachHang.getTenKhachHang()%></td>
							<td><%=khachHang.getTenDangNhap()%></td>
							<td><%=khachHang.getEmail()%></td>
							<td><%=khachHang.getSoDienThoai()%></td>
							<td><%=khachHang.getDiaChi()%></td>
							<td><%=khachHang.getNgaySinhString()%></td>
							<%if(khachHang.isGioiTinh()){ %>
								<td>Nam</td>
							<%}else { %>
								<td>Nữ</td>
							<%} %>
							<td style="text-align: center;">
								<div class="d-flex justify-content-center align-items-center">
									<a
										onclick="return confirm('Xóa sẽ không thể khôi phục lại ?');"
										href="XoaKhachHangServlet?xoa=<%=khachHang.getMaKhachHang() %>"
										class="btn btn-danger"><i class="fas fa-trash-alt"></i></a>
								</div>
							</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<%@ include file="Footer.jsp"%>
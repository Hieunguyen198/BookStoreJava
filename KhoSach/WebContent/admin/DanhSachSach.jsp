<%@page import="model.bean.SachBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<%@ include file="Nav.jsp"%>
<%if(request.getAttribute("KtraCapNhat")!=null) {
	out.print("<script>alert('Cấp nhập sách thành công')</script>");

} %>
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
							<th>Mã sách</th>
							<th>Tên sách</th>
							<th>Ảnh</th>
							<th>Số lượng</th>
							<th>Giá</th>
							<th>Giá Khuyến mãi</th>
							<th>Tác giả</th>
							<th>Năm xuất bản</th>
							<th>Nhà xuất bản</th>
							<th>Thể loại</th>
							<th>Ngày nhập</th>
							<th>Trạng thái</th>
							<th style="text-align: center;">Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<SachBEAN> listSach = (ArrayList<SachBEAN>) request.getAttribute("dsSach");
							for (SachBEAN sach : listSach) {
						%>
						<tr id="trXoaSach<%=sach.getMaSach()%>">
							<td><%=sach.getMaSach()%></td>
							<td><%=sach.getTenSach()%></td>
							<td><img src="image/<%=sach.getAnh()%>" alt="image"
								style="width: 65px; height: 65px;"></td>
							<td><%=sach.getSoLuong()%></td>
							<td><%=sach.getGia()%></td>
							<td><%=sach.getGiaKhuyenMai()%></td>
							<td><%=sach.getTacGia()%></td>
							<td><%=sach.getNamXuatBan()%></td>
							<td><%=sach.getNhaXuatBan()%></td>
							<td><%=sach.getTenTheLoai()%></td>
							<td><%=sach.getNgayNhapSring()%></td>
							<%
								if (sach.isTrangThai()) {
							%>
							<td>Còn hàng</td>
							<%
								} else {
							%>
							<td>Hết hàng</td>
							<%
								}
							%>
							<td style="text-align: center;">
								<div class="d-flex justify-content-center align-items-center">
									<a href="SuaSachServlet?sua=<%=sach.getMaSach() %>"
										class="btn btn-success mr-3"><i class="fa fa-edit"></i></a> 
									<a style="color: #fff"
										onclick="XoaSach(<%=sach.getMaSach() %>);"
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
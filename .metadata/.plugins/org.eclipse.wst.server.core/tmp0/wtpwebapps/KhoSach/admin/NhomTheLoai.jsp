<%@page import="model.bean.TheLoaiBEAN"%>
<%@page import="model.bean.NhomTheLoaiBEAN"%>
<%@page import="model.bean.DanhMucBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<%@ include file="Nav.jsp"%>
<body>
	<%
		ArrayList<NhomTheLoaiBEAN> listTheLoai = (ArrayList<NhomTheLoaiBEAN>) request.getAttribute("list");
	%>

	<div class="container-fluid">
		<h2 style="text-align: right;">
			<a class="text-white btn btn-success mr-3" href="ThemNhomTheLoaiServlet">  Thêm nhóm thể loại
			</a>
		</h2>
		<h1 class="h3 mb-2 text-gray-800">Danh sách nhóm thể loại</h1>
		<div class="card shadow mb-4">
			<div class="card-body">
				<div class="table-responsive table-hover">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Mã thể loại</th>
								
								<th>Tên thể loại</th>
								
								<th>Tên nhóm thể loại</th>
								
								<th>Thao tác</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (NhomTheLoaiBEAN nhomTheLoaiBean : listTheLoai) {
							%>
							<tr>
								<td><%=nhomTheLoaiBean.getMaNhomTheLoai()%></td>
								<td><%=nhomTheLoaiBean.getTenNhomTheLoai()%></td>
								<td><%=nhomTheLoaiBean.getTenDanhMuc()%></td>
								<td><a
									href="SuaNhomTheLoaiServlet?maNTLSua=<%=nhomTheLoaiBean.getMaNhomTheLoai()%>"
									class="btn btn-success mr-3"> <i class="fa fa-edit"></i>
								</a> <a
									onclick="return confirm('Xóa sẽ không thể khôi phục lại ?');"
									href="XoaNhomTheLoaiServlet?maNTLXoa=<%=nhomTheLoaiBean.getMaNhomTheLoai()%>"
									class="btn btn-danger"> <i class="fas fa-trash-alt"></i></a></td>
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
</body>
</html>
<%@ include file="Footer.jsp"%>
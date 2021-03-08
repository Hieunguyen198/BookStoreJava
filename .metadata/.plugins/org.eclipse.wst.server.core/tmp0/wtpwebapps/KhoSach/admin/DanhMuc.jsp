<%@page import="model.bean.TheLoaiBEAN"%>
<%@page import="model.bean.DanhMucBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<%@ include file="Nav.jsp"%>
<html>
<body>
	<%
		ArrayList<DanhMucBEAN> list = (ArrayList<DanhMucBEAN>) request.getAttribute("list");
		if (request.getAttribute("kiemtraxoa") != null) {
			out.print("<script>alert('Xóa thành công')</script>");
		}
	%>
	<form action="DanhMucServlet"></form>

	<div class="container-fluid">
		<h2 style="text-align: right;">
			<a class="text-white btn btn-success mr-3" href="ThemDanhMucServlet"> Thêm danh mục</a>
		</h2>
		<h1 class="h3 mb-2 text-gray-800">Danh sách danh mục</h1>
		<div class="card shadow mb-4">
			<div class="card-body">
				<div class="table-responsive table-hover">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Mã danh mục</th>
								<th>Tên danh mục</th>
								<th>Thao tác</th>

							</tr>
						</thead>
						<tbody>
							<%
								for (DanhMucBEAN dmb : list) {
							%>
							<tr>
								<td><%=dmb.getMaDanhMuc()%></td>
								<td><%=dmb.getTenDanhMuc()%></td>

								<td><a
									href="SuaDanhMucServlet?maDMSua=<%=dmb.getMaDanhMuc()%>"
									class="btn btn-success mr-3"> <i class="fa fa-edit"></i>
								</a> <a
									onclick="return confirm('Xóa sẽ không thể khôi phục lại ?');"
									href="XoaDanhMucServlet?maDMXoa=<%=dmb.getMaDanhMuc()%>"
									class="btn btn-danger"> <i class="fas fa-trash-alt"></i>
								</a></td>
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
<%@page import="model.bean.TheLoaiBEAN"%>
<%@page import="model.bean.DanhMucBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<%@ include file="Nav.jsp"%>
<body>
	<%
		ArrayList<TheLoaiBEAN> list = (ArrayList<TheLoaiBEAN>) request.getAttribute("list");
		if (request.getAttribute("kiemtraxoa") != null) {
			out.print("<script>alert('Xóa thành công')</script>");
		}
		
	%>
	<form action="theLoaiServlet">
		
	</form>
	
	<div class="container-fluid">
		<h2 style="text-align: right;">
			<a class="text-white btn btn-success mr-3" href="ThemTheLoaiServlet">Thêm thể loại</a>
		</h2>
		<h1 class="h3 mb-2 text-gray-800">Danh sách thể loại</h1>
		<div class="card shadow mb-4">
			<div class="card-body">
				<div class="table-responsive table-hover">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Mã thể loại</th>
								<th>Tên Thể Loại</th>
								<th>Tên nhóm thể loại</th>
								<th>Thao tác</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (TheLoaiBEAN tlb : list) {
							%>
							<tr>
								<td><%=tlb.getMaTheLoai()%></td>
								<td><%=tlb.getTenTheLoai()%></td>
								<td><%=tlb.getTenNhomTheLoai()%></td>
								<td>
									<a href="SuaTheLoaiServlet?maTLSua=<%=tlb.getMaTheLoai()%>"
									class="btn btn-success mr-3"> <i class="fa fa-edit"></i></a>
								
									<a onclick="return confirm('Xóa sẽ không thể khôi phục lại ?');"
									href="XoaTheLoaiServlet?maTLXoa=<%=tlb.getMaTheLoai()%>"
									class="btn btn-danger"> <i class="fas fa-trash-alt"></i></a>
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
</body>
</html>
<%@ include file="Footer.jsp"%>
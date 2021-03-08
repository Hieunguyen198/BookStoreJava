<%@page import="model.bean.DanhMucBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<%@ include file="Nav.jsp"%>
<div class="container">
	<div class="row shadow">
		<div class="col-sm-12">
			<div class="px-2">
				<h4 class="title mt-4 mb-5 text-center text-uppercase text-danger">Thêm
					danh mục</h4>

				<%
					ArrayList<DanhMucBEAN> list = (ArrayList<DanhMucBEAN>) request.getAttribute("list");
					if (request.getAttribute("kiemtrathem") != null) {
						if ((int) request.getAttribute("kiemtrathem") == 0) {
							out.print("<script>alert('lỗi!!!')</script>");
						} else {
							out.print("<script>alert('Thêm thành công')</script>");
						}
					}
				%>
				<form method="POST" action="ThemDanhMucServlet" onsubmit="return kiemTraTenDanhMuc()">
					<div class="form-group">
						<label>Tên danh mục</label> <input type="text"
							class="text form-control" required="" name="txtTenDanhMuc" id ="tenDanhMuc">
							<p class="text-danger" id="resultTenDanhMuc"></p>
					</div>
					<div class="form-group">
						<button type="submit" value="them" class="btn btn-success mb-3"
							name="btnThem">Thêm</button>
						<a class="btn btn-danger ml-3 mb-3" href="DanhMucServlet"> Hủy</a>

					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="Footer.jsp"%>
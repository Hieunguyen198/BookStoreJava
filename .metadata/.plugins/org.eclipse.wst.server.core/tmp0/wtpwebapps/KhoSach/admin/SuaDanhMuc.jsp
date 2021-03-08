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
				<h4 class="title mt-4 mb-5 text-center text-uppercase text-danger">Sửa
					danh mục</h4>
				<%
				DanhMucBEAN danhMuc = (DanhMucBEAN) request.getAttribute("danhMuc");
			//	ArrayList<DanhMucBEAN> list =(ArrayList<DanhMucBEAN>)request.getAttribute("list");
					if (request.getAttribute("kiemtrasua") != null) {
						out.print("<script>alert('Sửa thành công')</script>");
					}
					
				%>
				<form method="POST" action="SuaDanhMucServlet">
					<div class="form-group">
						<label>Mã danh mục</label> <input type="text" value="<%=danhMuc.getMaDanhMuc()%>"
							class="text form-control" required="" name="txtMaDanhMuc"
							readonly>
					</div>

					<div class="form-group">
						<label>Tên danh mục</label> <input type="text" value="<%=danhMuc.getTenDanhMuc() %>"
							class="text form-control" required="" name="txtTenDanhMuc">
					</div>

					<div class="form-group">
						<button type="submit" value="sua" class="btn btn-success mb-3"
							name="btnSua">Sửa</button>
						<a class="btn btn-danger ml-3 mb-3" href="DanhMucServlet"> Hủy</a>
					</div>

				</form>
			</div>
		</div>
	</div>
</div>
<%
	//}
	//}
%>

<%@ include file="Footer.jsp"%>
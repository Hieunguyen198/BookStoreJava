<%@page import="model.bean.NhomTheLoaiBEAN"%>
<%@page import="model.bean.TheLoaiBEAN"%>
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
					nhóm thể loại</h4>
				<%
					ArrayList<NhomTheLoaiBEAN> list = (ArrayList<NhomTheLoaiBEAN>) request.getAttribute("list");
					NhomTheLoaiBEAN nhomTheLoai = (NhomTheLoaiBEAN) request.getAttribute("nhomTheLoai");
					if (request.getAttribute("kiemtrasua") != null) {
						out.print("<script>alert('Sửa thành công')</script>");
					}
				%>
				<form method="POST" action="SuaNhomTheLoaiServlet">
					<div class="form-group">
						<label>Mã nhóm thể loại </label> <input type="text"
							value="<%=nhomTheLoai.getMaNhomTheLoai()%>" class="text form-control"
							required="" name="txtMaNhomTheLoai" readonly>
					</div>

					<div class="form-group">
						<label>Tên nhóm thể loại</label> <input type="text"
							value="<%=nhomTheLoai.getTenNhomTheLoai()%>" class="text form-control"
							required="" name="txtNhomTenTheLoai">
					</div>

					<div class="form-group">
						<label>Tên danh mục: </label> 
						<select class="form-control" name="txtMaDanhMuc">
						<option value="<%=nhomTheLoai.getMaDanhMuc()%>"><%=nhomTheLoai.getTenDanhMuc()%></option>
							<%
							ArrayList<DanhMucBEAN> l = (ArrayList<DanhMucBEAN>) request.getAttribute("dsMaDanhMuc");
							for (DanhMucBEAN ds : l) {
								if(ds.getMaDanhMuc()!= nhomTheLoai.getMaDanhMuc()){
							%>
							<option value="<%=ds.getMaDanhMuc()%>"><%=ds.getTenDanhMuc()%></option>
							<%
								}
							}
							%>

						</select>

					</div>

					<div class="form-group">
						<button type="submit" value="sua" class="btn btn-success mb-3"
							name="btnSua">Sửa</button>
						<a class="btn btn-danger ml-3 mb-3" href="NhomTheLoaiServlet">Hủy</a>
					</div>

				</form>
			</div>
		</div>
	</div>
</div>


<%@ include file="Footer.jsp"%>
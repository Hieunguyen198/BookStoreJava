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
					thể loại</h4>
				<%
					ArrayList<TheLoaiBEAN> list = (ArrayList<TheLoaiBEAN>) request.getAttribute("list");
					TheLoaiBEAN theLoai = (TheLoaiBEAN) request.getAttribute("theLoai");
					if (request.getAttribute("kiemtrasua") != null) {
						out.print("<script>alert('Sửa thành công')</script>");
					}
				%>
				<form method="POST" action="SuaTheLoaiServlet">
					<div class="form-group">
						<label>Mã thể loại </label> <input type="text"
							value="<%=theLoai.getMaTheLoai()%>" class="text form-control"
							required="" name="txtMaTheLoai" readonly>
					</div>

					<div class="form-group">
						<label>Tên thể loại</label> <input type="text"
							value="<%=theLoai.getTenTheLoai()%>" class="text form-control"
							required="" name="txtTenTheLoai">
					</div>

					<div class="form-group">
						<label>Mã nhóm thể loại: </label> 
						<select class="form-control" name="txtMaNhomTheLoai">
						<option value="<%=theLoai.getMaNhomTheLoai()%>"><%=theLoai.getTenNhomTheLoai()%></option>
							<%
							ArrayList<NhomTheLoaiBEAN> l = (ArrayList<NhomTheLoaiBEAN>) request.getAttribute("dsNhomTheLoai");
							for (NhomTheLoaiBEAN ds : l)
							if(ds.getMaNhomTheLoai()!=theLoai.getMaNhomTheLoai()){
							{
							%>
							<option value="<%=ds.getMaNhomTheLoai()%>"><%=ds.getTenNhomTheLoai()%></option>
							<%
								}}
							%>

						</select>

					</div>

					<div class="form-group">
						<button type="submit" value="sua" class="btn btn-success mb-3"
							name="btnSua">Sửa</button>
						<a class="btn btn-danger ml-3 mb-3" href="TheLoaiServlet">Hủy</a>
					</div>

				</form>
			</div>
		</div>
	</div>
</div>


<%@ include file="Footer.jsp"%>
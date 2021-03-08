<%@page import="model.bean.NhomTheLoaiBEAN"%>
<%@page import="model.bean.DanhMucBEAN"%>
<%@page import="model.bean.TheLoaiBEAN"%>
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
					thể loại</h4>
				<%
					ArrayList<TheLoaiBEAN> list = (ArrayList<TheLoaiBEAN>) request.getAttribute("list");
				
					if (request.getAttribute("kiemtrathem") != null) {
						if ((int) request.getAttribute("kiemtrathem") == 0) {
							out.print("<script>alert('lỗi!!!')</script>");
						} else {
							out.print("<script>alert('Thêm thành công')</script>");
						}
					}
				%>

				<form method="POST" action="ThemTheLoaiServlet" onsubmit="return kiemTraTenTheLoai()">
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label>Tên thể loại</label> <input type="text"
									class="text form-control" required="" name="txtTenTheLoai" id = "tenTheLoai">
									<p id ="resultTenTheLoai"></p>
							</div>
						</div>

						<div class="col-sm-3">
							<div class="form-group">
								<label>Tên Nhóm thể loại: </label> <select class="form-control"
									name="txtMaNhomTheLoai">
									<%
										ArrayList<NhomTheLoaiBEAN> l = (ArrayList<NhomTheLoaiBEAN>) request.getAttribute("dsNhomTheLoai");
										for (NhomTheLoaiBEAN ds : l) {
									%>
									<option value="<%=ds.getMaNhomTheLoai()%>"><%=ds.getTenNhomTheLoai()%></option>
									<%
										}
									%>

								</select>

							</div>

						</div>
					</div>
					<div class="form-group">
						<button type="submit" value="them" class="btn btn-success mb-3"
							name="btnThem"> Thêm</button>
						<a class="btn btn-danger ml-3 mb-3" href="TheLoaiServlet"> Hủy</a>

					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="Footer.jsp"%>
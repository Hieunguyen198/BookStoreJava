<%@page import="model.bean.TheLoaiBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<%@ include file="Nav.jsp"%>
<%if(request.getAttribute("KtraThem")!=null) {
	out.print("<script>alert('Thêm sách thành công')</script>");

} %>
<div class="container">
	<div class="row shadow">
		<div class="col-sm-12">
			<div class="px-2">
				<h4 class="title mt-4 mb-5 text-center text-uppercase text-danger">Thêm
					Sách</h4>
				<form method="POST" action="XuLyThemSachServlet"
					enctype="multipart/form-data">
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label>Tên sách</label> <input type="text"
									class="text form-control" placeholder="Tên sách" required
									name="tenSach">
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label>Thể loại</label> <select name="maTheLoai"
									class="custom-select form-control" style="width: 90%;">
									<%
										ArrayList<TheLoaiBEAN> listTheLoai = (ArrayList<TheLoaiBEAN>) request.getAttribute("dsTheLoai");
										for (TheLoaiBEAN theLoai : listTheLoai) {
									%>
									<option value="<%=theLoai.getMaTheLoai()%>"><%=theLoai.getTenTheLoai()%></option>
									<%
										}
									%>
								</select>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label>Tác giả</label> <input type="text"
									class="text form-control" placeholder="Tác giả" required
									name="tacGia">
							</div>
						</div>
					</div>
					<div class="row p-2 pt-3">
						<div class="col-sm-5">
							<div class="form-group">
								<label>Hình Ảnh</label> <input type="file" class="form-control"
									required name="anh" placeholder="">
							</div>
						</div>
						<div class="col-sm-3">
							<label>Giá</label> 
							<input type="number" class="form-control"
								name="gia" placeholder="Giá" required>
						</div>
						<div class="col-sm-4">
							<label>Giá Khuyến Mãi</label> <input type="number"
								class="form-control" name="giaKhuyenMai"
								placeholder="Giá khuyến mãi" required>
						</div>
						
					</div>
					<div class="row p-2 pt-3">
						<div class="col-sm-3">
							<label>Năm xuất bản</label> <input type="number"
								class="form-control" name="namXuatBan"
								placeholder="Năm xuất bản" required>
						</div>
						<div class="col-sm-5">
							<label>Nhà xuất bản</label> <input type="text"
								class="form-control" name="nhaXuatBan" placeholder="Nhà xuất bản"
								required>
						</div>
						<div class="col-sm-4">
							<label>Số Lượng</label> <input type="number" class="form-control"
								name="soLuong" placeholder="số Lượng" required>
						</div>
					</div>
					<div class="form-group">
						<label>Mô tả:</label>

						<textarea id="content" class="form-control" name="moTa"
							placeholder="Mô tả" rows="15"></textarea>
					</div>

					<button type="submit" class="btn btn-success mb-3" name="subThem">Thêm</button>
					<a class="btn btn-danger ml-3 mb-3" href="SachServlet">Hủy</a>
				</form>
			</div>

		</div>

	</div>
</div>
<%@ include file="Footer.jsp"%>
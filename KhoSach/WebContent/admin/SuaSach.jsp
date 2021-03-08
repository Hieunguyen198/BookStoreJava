<%@page import="model.bean.SachBEAN"%>
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
				<h4 class="title mt-4 mb-5 text-center text-uppercase text-danger">Sửa
					Sách</h4>
				<form method="POST" action="XuLySuaSachServlet"
					enctype="multipart/form-data">
					<div class="row">
						<%
							SachBEAN sach = (SachBEAN) request.getAttribute("sach");
						%>
						<div class="col-sm-1">
							<div class="form-group">
								<label>Mã sách</label> <input type="text"
									class="text form-control" value="<%=sach.getMaSach()%>"
									readonly name="maSach">
							</div>
						</div>
						<div class="col-sm-5">
							<div class="form-group">
								<label>Tên sách</label> <input type="text"
									class="text form-control" placeholder="Tên sách"
									value="<%=sach.getTenSach()%>" required name="tenSach">
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label>Thể loại</label> <select name="maTheLoai"
									class="custom-select form-control" style="width: 90%;">
									<option value="<%=sach.getMaTheLoai()%>"><%=sach.getTenTheLoai()%></option>
									<%
										ArrayList<TheLoaiBEAN> listTheLoai = (ArrayList<TheLoaiBEAN>) request.getAttribute("dsTheLoai");
										for (TheLoaiBEAN theLoai : listTheLoai) {
											if (sach.getMaTheLoai() != theLoai.getMaTheLoai()) {
									%>
									<option value="<%=theLoai.getMaTheLoai()%>"><%=theLoai.getTenTheLoai()%></option>
									<%
										}
										}
									%>
								</select>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label>Tác giả</label> <input type="text"
									class="text form-control" value="<%=sach.getTacGia()%>"
									placeholder="Tác giả" required name="tacGia">
							</div>
						</div>
					</div>
					<div class="row p-2 pt-3">
						<div class="col-sm-6">
							<div class="form-group">
								<label>Hình Ảnh</label>
								<div style="display: inline-flex;">
									<input style="margin-right: 7px; width: 365px;" type="file"
										class="form-control" value="<%=sach.getAnh()%>" name="anh"
										placeholder="">
									<div class="text-center p-2 border rounded bg-white"
										style="margin-top: -42px;">
										<img style="width: 80px;" alt=""
											src="image/<%=sach.getAnh()%>">
									</div>

								</div>
								<input type="hidden" class="form-control" name="diaChiAnh"
									placeholder="Giá" value="<%=sach.getAnh()%>" readonly>
							</div>
						</div>
						<div class="col-sm-3">
							<label>Giá</label> <input type="number" class="form-control"
								name="gia" placeholder="Giá" value="<%=sach.getGia()%>" required>
						</div>
						<div class="col-sm-3">
							<label>Giá Khuyến Mãi</label> <input type="number"
								class="form-control" name="giaKhuyenMai"
								value="<%=sach.getGiaKhuyenMai()%>" placeholder="Giá khuyến mãi"
								required>
						</div>

					</div>
					<div class="row p-2 pt-3">
						<div class="col-sm-3">
							<label>Năm xuất bản</label> <input type="number"
								class="form-control" name="namXuatBan"
								value="<%=sach.getNamXuatBan()%>" placeholder="Năm xuất bản"
								required>
						</div>
						<div class="col-sm-5">
							<label>Nhà xuất bản</label> <input type="text"
								value="<%=sach.getNhaXuatBan()%>" class="form-control"
								name="nhaXuatBan" placeholder="Nhà xuất bản" required>
						</div>
						<div class="col-sm-4">
							<label>Số Lượng</label> <input type="number" class="form-control"
								value="<%=sach.getSoLuong()%>" name="soLuong"
								placeholder="số Lượng" required>
						</div>
					</div>
					<div class="row p-2 pt-3">
						<div class="col-sm-4">
							<label>Ngày nhập</label> <input type="text"
								value="<%=sach.getNgayNhapSring()%>" class="form-control"
								name="ngayNhap" placeholder="Năm xuất bản" readonly>
						</div>
						<div class="col-sm-5">
							<label>Trạng thái</label> <br>
							<%
								if (sach.isTrangThai() == true) {
							%>
							<input type="radio" checked="checked" name="trangThai"
								value="true"> <label style="margin-right: 10px;">Còn
								hàng</label> <input type="radio" name="trangThai" value="false"><label>Hết
								hàng</label>

							<%
								} else {
							%>
							<input type="radio" name="trangThai" value="true"><label style="margin-right: 10px;"
								for="true">Còn hàng</label> <input type="radio"
								checked="checked" name="trangThai" value="false"> <label
								for="false">Hết hàng</label>
							<%
								}
							%>
						</div>
					</div>
					<div class="form-group">
						<label>Mô tả:</label>

						<textarea id="content" class="form-control" name="moTa"
							placeholder="Mô tả" rows="15"><%=sach.getMoTa()%></textarea>
					</div>

					<button type="submit" class="btn btn-success mb-3" name="subSua">Cập
						nhập</button>
					<a class="btn btn-danger ml-3 mb-3" data-dismiss="modal">Hủy</a>
				</form>
			</div>

		</div>

	</div>
</div>
<%@ include file="Footer.jsp"%>
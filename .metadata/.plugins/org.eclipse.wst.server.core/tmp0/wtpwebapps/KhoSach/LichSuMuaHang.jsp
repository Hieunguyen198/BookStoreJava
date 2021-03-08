<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.bean.LichSuMuaHangBEAN"%>
<%@page import="model.bean.ChiTietDonHangBEAN"%>
<%@page import="java.util.ArrayList"%>
<div class="information-right-content tab-pane fade" id="lichSuMuaHang">
	<div class="information-right-content-title">
		<h5>LỊCH SỬ MUA HÀNG</h5>
	</div>
	<hr>
	<%
		ArrayList<Integer> maHoaDon = new ArrayList<Integer>();
	%>
	<div class="row lichSuMuaHang_content">
		<div class="col-12">
			<label style="font: bold;">Đã duyệt</label>
			<table class="table table-bordered table_lichSu">
				<thead>
					<tr>
						<th>STT</th>
						<th>Tổng Số Lượng</th>
						<th>Tổng Tiền</th>
						<th>Ngày Mua</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%   DecimalFormat formatter2 = new DecimalFormat("###,###,###.00");
						ArrayList<LichSuMuaHangBEAN> ds = (ArrayList<LichSuMuaHangBEAN>) request.getAttribute("dslsmhdd");
						int i = 1;
						for (LichSuMuaHangBEAN lsu : ds) {
							maHoaDon.add(lsu.getMaHoaDon());
					%>
					<tr>
						<td>
							<%
								out.print(i);
							%>
						</td>
						<td><%=lsu.getTongSoLuong()%></td>
						<td style="color: red; font: bold"><%=formatter2.format(lsu.getTongTien())%>
							VNĐ</td>
						<td><%=lsu.getNgayMua()%></td>
						<td><button type="button" class="btn btn-success"
								style="align: center;" data-toggle="modal"
								data-target="#chiTietHoaDon<%=lsu.getMaHoaDon()%>">Chi
								tiết</button></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<div class="col-12">
			<label>Đang chờ duyệt</label>
			<table class="table table-bordered table_lichSu" id="myTable">
				<thead>
					<tr>
						<th>STT</th>
						<th>Tổng Số Lượng</th>
						<th>Tổng Tiền</th>
						<th>Ngày Mua</th>
						<th></th>
				</thead>
				<tbody>
					<%
						
						ArrayList<LichSuMuaHangBEAN> ds1 = (ArrayList<LichSuMuaHangBEAN>) request.getAttribute("dslsmhcd");
						i = 1;
						for (LichSuMuaHangBEAN lsu : ds1) {
							maHoaDon.add(lsu.getMaHoaDon());
					%>
					<tr id="trXoaDonHang<%=lsu.getMaHoaDon()%>">
						<td>
							<%
								out.print(i);
							%>
						</td>
						<td><%=lsu.getTongSoLuong()%></td>
						<td style="color: red; font: bold"><%=formatter2.format(lsu.getTongTien())%>
							VNĐ</td>
						<td><%=lsu.getNgayMua()%></td>
						<td><button class="btn btn-success" data-toggle="modal"
								data-target="#chiTietHoaDon<%=lsu.getMaHoaDon()%>">Chi
								tiết</button>
							<button class="btn btn-danger"
								onclick="deleteRow(<%=lsu.getMaHoaDon()%>)" id="subHuyDon">
								<a> Hủy đơn</a>
							</button></td>
					</tr>
					<%
						i++;
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%
	for (Integer j : maHoaDon) {
%>
<div class="modal fade" id="chiTietHoaDon<%out.print(j);%>">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 700px;padding: 15px">

			<!-- Modal Header -->
			<div class="modal-header" >
				<h4 class="modal-title" style="color: #ff5800;">CHI TIẾT HÓA
					ĐƠN MUA HÀNG</h4>
				<button type="button" class="close" data-dismiss="modal">×</button>
			</div>
			<div class="row lichSuMuaHang_content">
				<div class="col-12">
					<table class="table table-bordered table_lichSu">
						<thead>
							<tr>
								<th>STT</th>
								<th>Tên sách</th>
								<th>Anh</th>
								<th>Số lượng</th>
								<th>Giá</th>
								<th>Thành tiền</th>
							</tr>
						</thead>
						<tbody>
							<%
								ArrayList<ChiTietDonHangBEAN> listChiTiet = (ArrayList<ChiTietDonHangBEAN>) request
											.getAttribute("dsct");
									int k = 1;
									for (ChiTietDonHangBEAN chiTiet : listChiTiet) {
										if (chiTiet.getMaHoaDon() == j) {
							%>
							<tr>
								<td>
									<%
										out.print(k);
													k++;
									%>
								</td>
								<td><%=chiTiet.getTenSach()%></td>
								<td><img style="width: 50px;" src="image/<%=chiTiet.getAnh()%>"></td>
								<td><%=chiTiet.getSoLuong()%></td>
								<td style="color: red; font: bold"><%=chiTiet.getGia()%></td>
								<td style="color: red; font: bold"><%=chiTiet.thanhTien()%></td>
							</tr>
							<%
								}
									}
							%>
						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>
</div>
<%}%>
<%@page import="model.bean.ChiTietHoaDonBEAN"%>
<%@page import="model.bean.HoaDonBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<%@ include file="Nav.jsp"%>
<div class="container">
	<div class="row shadow">
		<div class="col-sm-12">
			<div class="px-2">
				<h4 class="title mt-4 mb-5 text-center text-uppercase text-danger">Danh Sách Hóa Đơn</h4>
				<div class="container-fluid">
<%int maHoaDon =0; %>
	 <div class="card shadow mb-4">
		<div class="card-body">
			<div class="table-responsive table-hover">
				<table class="table table-bordered" id="dataTable" width="100%"	cellspacing="0">
					<thead>
						<tr>
							<th>Mã hóa đơn</th>
							<th>Mã khách hàng</th>
							<th>Trạng thái</th>
							<th>Ngày lập</th>
							<th>Phương thức thanh toán</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<%String phuongThuc,trangThai,txtDuyet;
					ArrayList<HoaDonBEAN> listHoaDon = (ArrayList<HoaDonBEAN>)request.getAttribute("listHoaDon");
					for(HoaDonBEAN hoaDon: listHoaDon){
						maHoaDon =hoaDon.getMaHoaDon();
						if(hoaDon.isTrangThai()==1)	{
						    trangThai="Đã duyệt";
						}
						else if(hoaDon.isTrangThai()==2){
						    trangThai="Trả đơn";
						}else{
						    trangThai = "Chưa duyệt";
						    }
						if(hoaDon.getPhuongThucThanhToan()==1) phuongThuc="Thanh toán khi nhận hàng";
						else phuongThuc="Thanh toán qua thẻ";
						%>
						<tr id="trXoaDonHang<%=hoaDon.getMaHoaDon()%>" >
							<td><%=hoaDon.getMaHoaDon() %></td>
							<td><%=hoaDon.getMaKhachHang() %></td>
							<td id="trangThai<%=hoaDon.getMaHoaDon()%>"><%=trangThai%></td>
							<td><%=hoaDon.getNgayLap() %></td>
							<td><%=phuongThuc %></td>
							<td style="text-align: center;">
								<div class="d-flex justify-content-center align-items-center">
									<a style="margin-right: 3px;"  class="btn btn-info" onclick="clickChiTiet(<%=hoaDon.getMaHoaDon() %>)" data-toggle="modal" data-target="#chiTiet<%=maHoaDon%>"><i class="fas fa-info-circle"></i></a>
									<a style="margin-right: 3px;" class="btn btn-danger" onclick="deleteRow(<%=hoaDon.getMaHoaDon() %>)" name="btnXoa" ><i class="fas fa-trash-alt"></i></a>
									<a style="margin-right: 3px;" class="btn btn-success" onclick="clickDuyet(<%=hoaDon.getMaHoaDon() %>)" ><i class="fas fa-check-circle"></i></a>
									<a class="btn btn-warning" onclick="clickTraDon(<%=hoaDon.getMaHoaDon() %>)" ><i class="fas fa-undo-alt"></i></a>
								</div>
							</td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%for(HoaDonBEAN ctHoaDon: listHoaDon){ %>
		<div class="modal fade" id="chiTiet<%=ctHoaDon.getMaHoaDon() %>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				    <div class="modal-dialog modal-lg">
				        <div class="modal-content">
				            <div class="modal-header">
				            	<h4 class="modal-title" id="myModalLabel">Chi tiết hóa đơn</h4>
				                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
				                </button>                 
				            </div>
				            <div class="modal-body">
				                <table class="table table-bordered">
				                    <thead>
				                        <tr>
				                            <th>Mã hóa đơn</th>
				                            <th>Mã sách</th>
				                            <th>Tên sách</th>
				                            <th>Ảnh</th>
				                            <th>Số lượng</th>
				                            <th>Giá</th>
				                            <th>Tổng tiền</th>
				                        </tr>
				                    </thead>
				                    <tbody id="trChiTiet<%=ctHoaDon.getMaHoaDon()%>">
				                    </tbody>
				                </table>
				               
				            </div>
				            <div class="modal-footer">
				                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				            </div>
				        </div>
				    </div>
				</div><%} %>
	</div>
			</div>
		</div>
	</div>
</div>

	<%@ include file="Footer.jsp"%>
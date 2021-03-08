<%@page import="model.bean.KhachHangBEAN"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<body>
	<%
	    if (request.getAttribute("thongbao") != null) {
	%>
	<div class="alert alert-danger">
		<strong>Thất bại!</strong> Thông tin quý khách điền không đúng!.
	</div>
	<%
	    }
	%>
<section class="product-detail bg-gray py-5">
	<div class="container">
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb text-capitalize bg-white">
				<li class="breadcrumb-item"><a href="index.html"
					class="text-purple font-15pt">trang chủ</a></li>
				<li class="breadcrumb-item active font-15pt">xác nhận</li>
			</ol>
		</nav>
		<div class="row">
			<div class="col-sm-12 col-md-5 col-lg-4">
				<div class="card sticky-top">
					<div class="card-header font-18pt font-title bg-white py-2 px-3">Thông
						tin đơn hàng</div>
					<%
					    for(GioHangBEAN g : gio){TongTien =TongTien + (g.getGia()*g.getSoLuong());
					%>
					<div class="card-body cart-cofirm-container py-0">
						<div class="cart-confirm-item d-flex">
							<div class="cart-confirm-img">
								<img src="image/<%=g.getAnh()%>" class="img-fluid">
							</div>
							<div
								class="cart-confirm-title line-height-one font-14pt text-capitalize">
								<%=g.getTenSach()%>
							</div>
							<div class="cart-confirm-quantity line-height-one font-14pt">
								<%=g.getSoLuong()%>
							</div>
							<div
								class="cart-confirm-price line-height-one text-right font-14pt">
								<%=g.getGia()%>
								đ
							</div>
						</div>
					</div>
					<%
					    }
					%>
					<div class="card-footer py-2 px-3">
						<div
							class="cart-confirm-footer d-flex align-items-center justify-content-between">
							<div class="cart-confirm-footer-title font-title">Thành
								tiền</div>
							<div class="cart-confirm-footer-price text-danger font-title"><%=TongTien%>
								đ
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-12 col-md-7 col-lg-8">
				<div class="card customer-info">
				<% KhachHangBEAN khb = (KhachHangBEAN) request.getAttribute("KhachHang") ;%>
					<div class="card-header font-title font-18pt bg-white py-2 px-3">Thông
						tin khách hàng</div>
					<div class="card-body py-2 px-3">
						<form action="ThanhToanServlet" method="GET">
							<div class="row">
								<div class="col-sm-12 col-md-6 col-lg-6 form-group">
									<label class="d-block w-100 font-15pt font-title">Tên
										khách hàng:<span class="text-danger font-title ml-1">(*)</span>
									</label> <input type="text" class="form-control"
										value="<%=khb.getTenKhachHang()%>" name="tenKhachHang" required>
								</div>
								<div class="col-sm-12 col-md-6 col-lg-6 form-group">
									<label class="d-block w-100 font-15pt font-title">Số
										điện thoại:<span class="text-danger font-title ml-1">(*)</span>
									</label> <input type="text" class="form-control" inputmode="numberic"
										value="<%=khb.getSoDienThoai()%>" name="soDienThoai" required>
								</div>
								<div class="col-sm-12 col-md-6 col-lg-6 form-group">
									<label class="d-block w-100 font-15pt font-title">Địa
										chỉ:<span class="text-danger font-title ml-1">(*)</span>
									</label> <input type="text" class="form-control"
										value="<%=khb.getDiaChi()%>" name="diaChi" required>
								</div>
								<div class="col-sm-12 col-md-6 col-lg-6 form-group">
									<label class="d-block w-100 font-15pt font-title">Email:<span
										class="text-danger font-title ml-1">(*)</span></label> <input
										value="<%=khb.getEmail()%>" type="email" class="form-control"
										name="email" required>
								</div>
								<div class="col-sm-12 col-md-12 col-lg-12 form-group">
									<label class="d-block w-100 font-15pt font-title">Ghi
										chú:</label>
									<textarea class="form-control" rows="4" name="note"></textarea>
								</div>
								<div class="col-sm-12 col-md-12 col-lg-12 form-group">
									<label class="d-block w-100 font-15pt font-title">Phương
										thức thanh toán:<span class="text-danger font-title ml-1">(*)</span>
									</label> <select class="form-control " name="phuongThucThanhToan">
										<option value="1">Thanh toán khi giao hàng</option>
										<option value="2">Thanh toán qua thẻ</option>
									</select>
									<div class=" col-sm-12 col-md-12 col-lg-12 text-right">
										<label class="w-100"></label>
										<button type="submit" style="background: #ff5800;"
											class="btn btn-warning ml mb-5 font-title text-uppercase"
											name="send--customer">xác nhận đặt hàng</button>
									</div>
								</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<%@ include file="Footer.jsp"%>
<%@page import="model.bean.GioHangBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<section class="product-detail bg-gray py-5"
	style="padding-top: 0px !important">
	<div class="container">
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb text-capitalize bg-white">
				<li class="breadcrumb-item"><a style="color: #000" href="/KhoSach"
					class="text-purple font-15pt">trang chủ</a></li>
				<li style="color: #ff5800" class="breadcrumb-item active font-15pt">giỏ hàng</li>
			</ol>
		</nav>
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<%
					if (gio.isEmpty()) {
				%>
				<div class="cart-empty text-center">
					<img src="image/cart-empty.png" class="img-fluid cart-empty-img">
					<div class="font-title my-2 text-capitalize">giỏ hàng trống</div>
					<a style="background: #ff5800;" href="/KhoSach"
						class="btn btn-purple font-title my-2 text-uppercase">mua sản
						phẩm</a>
				</div>
				<%
					} else {
				%>
				<div
					class="nav-table-item nav-table-left position-absolute text-center">
					<i class="far fa-chevron-left fa-2x text-white"></i>
				</div>
				<div
					class="nav-table-item nav-table-right position-absolute text-center">
					<i class="far fa-chevron-right fa-2x text-white"></i>
				</div>
				<div class="table-scroll position-relative"
					style="overflow-x: auto;" id="listCart">
					<table id="table"
						class="table table-hover table-striped bg-white table-bordered table-cart mb-0"
						id="Cart">
						<thead>
							<th style="text-align: center"
								class="font-title font-15pt font-weight-normal nowrap-text">Tên
								sản phẩm</th>
							<th style="text-align: center"
								class="font-title font-15pt font-weight-normal nowrap-text">Hình
								ảnh</th>
							<th style="text-align: center"
								class="font-title font-15pt font-weight-normal nowrap-text">Số
								lượng</th>
							<th style="text-align: center"
								class="font-title font-15pt font-weight-normal nowrap-text">Giá</th>
							<th style="text-align: center"
								class="font-title font-15pt font-weight-normal nowrap-text">Thành
								tiền</th>
							<th style="text-align: center"
								class="font-title font-15pt font-weight-normal nowrap-text">Thao
								tác</th>
						</thead>
						<tbody class="font-15pt">
							<%
								for (GioHangBEAN gh : gio) {
								TongTien = TongTien + (gh.getGia() * gh.getSoLuong());
							%>
							<tr id="tr<%=gh.getMaSach()%>">
								<td style="text-align: center"><%=gh.getTenSach()%></td>
								<td style="text-align: center" class="table-product-img"><img
									src="image/<%=gh.getAnh()%>" style="width: 40px;"></td>
								<td style="text-align: center">
									<div style="display: inline-flex;" class="cart-plus-minus">
										<a onclick="GiamSL(<%=gh.getMaSach()%>)"
											class="dec qtybutton btn"
											style="margin-right: 3px; background: #ff5800;">-</a> <input
											id="sl<%=gh.getMaSach()%>"
											style="background: #fff; width: 50px; padding: 5px;"
											type="text" class="cart-plus-minus-box" min="1"
											onkeypress="updateCart(<%=gh.getMaSach()%>)"
											value="<%=gh.getSoLuong()%>" inputmode="numberic">
											<input id="slc<%=gh.getMaSach() %>" type="hidden" value="<%=gh.getSoLuong()%>">
											<input id="slMax<%=gh.getMaSach() %>" type="hidden" value="<%=gh.getSoLuongMax()%>"> <a
											onclick="TangSL(<%=gh.getMaSach()%>)"
											class="dec qtybutton btn"
											style="margin-left: 3px; background: #ff5800;">+</a>
									</div>
								</td>
								<td id="gia<%=gh.getMaSach()%>" style="text-align: center"
									class="nowrap-text"><%=gh.getGia()%> đ</td>
								<td id="tongGia<%=gh.getMaSach()%>" style="text-align: center"
									class="nowrap-text"><%=gh.getSoLuong() * gh.getGia()%> đ</td>
								<td style="text-align: center" class="text-danger font-title">
									<div class="del-product">
										<a onclick="xoaSach(<%=gh.getMaSach() %>)" style="color:#fff;cursor: pointer;"	class="btn btn-sm btn-danger"> <i
											class="fa fa-trash-o"></i>
										</a>
									</div>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4" class="text-right text-danger font-title">Tổng
									tiền</td>
								<td id="tongTien" style="text-align: center"
									class="text-danger font-title"><%=TongTien%> đ</td>
								<td style="text-align: center"><a
									onclick="xoaSachAll()" style="color:#fff;cursor: pointer;" name="deleteAllCart"
									class="btn btn-sm btn-danger text-capitalize">Xóa giỏ hàng</a></td>
							</tr>
						</tfoot>
					</table>
				</div>
				<div id="mua" class="text-right btn-action-cart" style="padding-top: 12px;">
					<a href="/KhoSach"
						class="btn btn-warning text-uppercase font-title mr-3 border-0">tiếp
						tục mua hàng</a>
					<%
						if (session.getAttribute("maKhachHang") != null) {
					%><a href="Dathang" style="background: #ff5800;"
						class="btn btn-purple text-uppercase font-title border-0">tiến
						hành đặt hàng</a>
					<%
						} else {
					%>
					<a id="myBtn1" style="background: #ff5800;"
						class="btn btn-purple text-uppercase font-title border-0 header__wrapper-link">tiến
						hành đặt hàng</a>
					<%
						}
					%>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
</section>
<%@ include file="Footer.jsp"%>
<%@page import="model.bean.SachBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="HeaderTrangChu.jsp"%>
<div class="container">
	<!-- product -->
	<div style="margin-top: 50px; margin-bottom: 20px">
		<img src="image/_Ngang-3.png" style="width: 100%;">
	</div>

	<section class="product" id="product-1">

		<h2 class="title-section">FLASH SALE</h2>
		<div class="row" style="background: #fff">
			<div class="col-lg-12 pl-0"
				style="padding-left: 0; padding-right: 0px;">
				<div class="product-list"
					style="grid-template-columns: repeat(6, 1fr);">
					<%
						ArrayList<SachBEAN> listSachTiêuThuyet = (ArrayList<SachBEAN>) request.getAttribute("listSachSale");
						for (int i = 0; i < 12; i++) {
							SachBEAN sach = listSachTiêuThuyet.get(i);
					%>
				  		<a href="Chitietsanpham?maSach=<%=sach.getMaSach() %>" style="margin: 10px;">
						<div class="product-single text-center">
							<div class="product-img">
								<img style="padding-top: 20px"
									src="image/<%=sach.getAnh()%>" alt="">
								<%
									long sale = ((sach.getGia() - sach.getGiaKhuyenMai()) * 100 / sach.getGia());
								%>
								<div class="sale"><%=sale%>%
								</div>
							</div>
							<div class="product-desc">
								<div class="product-title" style="padding: 10px;">
									<h4 style="color: #000" ><%=sach.getTenSach()%></h4>
								</div>
							</div>
							<div class="product-desc ">
								<div class="product-price" style="padding-left: 10px">
									<ins><%=formatter.format(sach.getGiaKhuyenMai())%> VND</ins>
									<del><%=formatter.format(sach.getGia())%> VND</del>
								</div>
							</div>

					</div>
					</a>
					<%
						}
					%>
					<!-- End of single-product  -->
				</div>
				<!-- End of product-list -->
			</div>
			<!-- End of col-lg-7 -->
		</div>

		<div class="product-seemore" style="">
			<p>
				<a>Xem Thêm</a>
			</p>
		</div>
	</section>
	<div style="margin-top: 50px; margin-bottom: 20px">
		<img src="image/_Ngang-2__1_.png" style="width: 100%;">
	</div>

	<section class="product" id="product-1">

		<h2 class="title-section">HẠT GIỐNG TÂM HỒN</h2>
		<div class="row" style="background: #fff">
			<div class="col-lg-3 d-none d-lg-block pr-0"
				style="padding-left: 0; padding-right: 0px;">
				<div class="d-flex">
					<div class="col-banner">
						<a href=""> <img src="image/_doc-1.png" alt=""
							style="width: 100%">
						</a>
					</div>
					<!-- End of col-banner !-->
				</div>
			</div>
			<div class="col-lg-9 pl-0"
				style="padding-left: 0; padding-right: 0px;">
				<div class="product-list">
					<%
						ArrayList<SachBEAN> listSachHatGiong = (ArrayList<SachBEAN>) request.getAttribute("listSachHatGiong");
						for (int i = 0; i < 8; i++) {
							SachBEAN sach = listSachHatGiong.get(i);
					%>
					<a href="Chitietsanpham?maSach=<%=sach.getMaSach() %>" style="margin: 10px;">
					<div class="product-single text-center" >
						<div class="product-img">
							<img style="padding-top: 20px"
								src="image/<%=sach.getAnh()%>" alt="">
							<%
								long sale = ((sach.getGia() - sach.getGiaKhuyenMai()) * 100 / sach.getGia());
							%>
							<div class="sale"><%=sale%>%
							</div>
						</div>
						<div class="product-desc">
							<div class="product-title" style="padding: 10px;">
								<h4 style="color: #000"><%=sach.getTenSach()%></h4>
							</div>
						</div>
						<div class="product-desc ">
							<div class="product-price" style="padding-left: 10px">
								<ins><%=formatter.format(sach.getGiaKhuyenMai())%> VND</ins>
								<del><%=formatter.format(sach.getGia())%> VND</del>
							</div>
						</div>

					</div>
					</a>
					<%
						}
					%>
					<!-- End of single-product  -->
				</div>
				<!-- End of product-list -->
			</div>
			<!-- End of col-lg-7 -->
		</div>
		<div class="product-seemore" style="">
			<p>
				<a>Xem Thêm</a>
			</p>
		</div>
	</section>

	<section class="product" id="product-1">

		<h2 class="title-section">VĂN HỌC NỖI BẬT</h2>
		<div class="row" style="background: #fff">
			<div class="col-lg-9 pl-0"
				style="padding-left: 0; padding-right: 0px;">
				<div class="product-list">
					<%
						ArrayList<SachBEAN> listSachSale = (ArrayList<SachBEAN>) request.getAttribute("listSachTieuThuyet");
						for (int i = 0; i < 8; i++) {
							SachBEAN sach = listSachSale.get(i);
					%>
					<a href="Chitietsanpham?maSach=<%=sach.getMaSach() %>" style="margin: 10px;">
					<div class="product-single text-center" >
						<div class="product-img">
							<img style="padding-top: 20px"
								src="image/<%=sach.getAnh()%>" alt="">
							<%
								long sale = ((sach.getGia() - sach.getGiaKhuyenMai()) * 100 / sach.getGia());
							%>
							<div class="sale"><%=sale%>%
							</div>
						</div>
						<div class="product-desc">
							<div class="product-title" style="padding: 10px;">
								<h4 style="color: #000"><%=sach.getTenSach()%></h4>
							</div>
						</div>
						<div class="product-desc ">
							<div class="product-price" style="padding-left: 10px">
								<ins><%=formatter.format(sach.getGiaKhuyenMai())%> VND</ins>
								<del><%=formatter.format(sach.getGia())%> VND</del>
							</div>
						</div>

					</div>
					</a>
					<%
						}
					%>
					<!-- End of single-product  -->
				</div>
				<!-- End of product-list -->
			</div>
			<!-- End of col-lg-7 -->

			<div class="col-lg-3 d-none d-lg-block pr-0"
				style="padding-left: 0; padding-right: 0px;">
				<div class="d-flex">
					<div class="col-banner">
						<a href=""> <img src="image/_doc-2.png" alt=""
							style="width: 100%">
						</a>
					</div>
					<!-- End of col-banner !-->
				</div>
			</div>
		</div>
		<div class="product-seemore" style="">
			<p>
				<a>Xem Thêm</a>
			</p>
		</div>
	</section>

	<section class="product" id="product-1">

		<h2 class="title-section">KỸ NĂM SỐNG</h2>
		<div class="row" style="background: #fff">
			<div class="col-lg-3 d-none d-lg-block pr-0"
				style="padding-left: 0; padding-right: 0px;">
				<div class="d-flex">
					<div class="col-banner">
						<a href=""> <img src="image/_doc-3.png" alt=""
							style="width: 100%">
						</a>

					</div>
					<!-- End of col-banner !-->
				</div>
			</div>
			<div class="col-lg-9 pl-0"
				style="padding-left: 0; padding-right: 0px;">
				<div class="product-list">
					<%
						ArrayList<SachBEAN> listSachKyNang = (ArrayList<SachBEAN>) request.getAttribute("listSachKyNang");
						for (int i = 0; i < 8; i++) {
							SachBEAN sach = listSachKyNang.get(i);
					%>
					<a href="Chitietsanpham?maSach=<%=sach.getMaSach() %>" style="margin: 10px;">
					<div class="product-single text-center">
						<div class="product-img">
							<img style="padding-top: 20px"
								src="image/<%=sach.getAnh()%>" alt="">
							<%
								long sale = ((sach.getGia() - sach.getGiaKhuyenMai()) * 100 / sach.getGia());
							%>
							<div class="sale"><%=sale%>%
							</div>
						</div>
						<div class="product-desc">
							<div class="product-title" style="padding: 10px;">
								<h4 style="color: #000"><%=sach.getTenSach()%></h4>
							</div>
						</div>
						<div class="product-desc ">
							<div class="product-price" style="padding-left: 10px">
								<ins><%=formatter.format(sach.getGiaKhuyenMai())%> VND</ins>
								<del><%=formatter.format(sach.getGia())%> VND</del>
							</div>
						</div>

					</div>
					</a>
					<%
						}
					%>
					<!-- End of single-product  -->
				</div>
				<!-- End of product-list -->
			</div>
			<!-- End of col-lg-7 -->
		</div>
		<div class="product-seemore" style="">
			<p>
				<a>Xem Thêm</a>
			</p>
		</div>
	</section>


	<%@ include file="Footer.jsp"%>
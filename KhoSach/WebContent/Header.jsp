<%@page import="java.text.DecimalFormat"%>
<%@page import="model.bean.TheLoaiBEAN"%>
<%@page import="model.bean.NhomTheLoaiBEAN"%>
<%@page import="model.bean.DanhMucBEAN"%>
<%@page import="model.bean.KhachHangBEAN"%>
<%@page import="model.bean.GioHangBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Kho sách</title>
<link rel="shortcut icon" type="image/png" href="image/favicon.ico">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/meanmenu.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/css.css">
<link rel="stylesheet" href="css/dangnhap.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/styleheader2.css">
</head>

<body data-spy="scroll" data-target="#myScroll" data-offset="50">
	<%
				DecimalFormat formatter = new DecimalFormat("###,###,###.00");
				ArrayList<DanhMucBEAN> danhMucBean = (ArrayList<DanhMucBEAN>)request.getAttribute("listDanhMuc");
				ArrayList<NhomTheLoaiBEAN> nhomTheLoaiBean = (ArrayList<NhomTheLoaiBEAN>)request.getAttribute("listNhomTheLoai");
				ArrayList<TheLoaiBEAN> theLoaiBean = (ArrayList<TheLoaiBEAN>)request.getAttribute("listTheLoai");
		%>
	<%
	    ArrayList<GioHangBEAN> gio = (ArrayList<GioHangBEAN>) session.getAttribute("gio");
						    KhachHangBEAN kh = (KhachHangBEAN) session.getAttribute("KhachHang");
														    Long TongTien=(long)0;
	%>
	<!-- header -->
	<header class="header__container">
		<div class="header__wrapper js-container" style="padding-top: 20px">
			<div class="container">
				<div class="header__left-right">
					<div class="header__wrapper-left">
						<div class="header__logo">
							<a href=""> <img src="image/logo.png" alt="">
							</a>
						</div>
						<div class="header__form" style="display: block;">
							<form action="Timkiem" method="GET" >
								<input type="text" class="header__form-input" id="search" name="search"
									placeholder="Hôm nay bạn muốn tìm ....">
								<button type="submit" class="header__form-submit" required>Tìm
									kiếm</button>
							</form>
							<div  class="resutlSearch">
                                <ul class="menu-search" id="resutlSearch">
                               
                                </ul>
                            </div>
						</div>
					</div>
					<div class="header__wrapper-right">
						<%
						    if(session.getAttribute("KhachHang")!=null){
						%>
						<a class="header__wrapper-link" style="margin-top: 4px"> <i
							class="fa fa-user"></i> Xin chào <%=kh.getTenKhachHang()%>
						</a>
						<%
						    }else{
						%>
						<a id="myBtn" class="header__wrapper-link" style="margin-top: 4px;cursor: pointer;">
							<i class="fa fa-user"></i> Tài khoản
						</a>
						<%
						    }
						%></a> <a href="" class="header__wrapper-link"> <i
							class="fa fa-bell"></i> Thông báo
						</a> <a href="Giohang"
							class="header__wrapper-link shopping__cart-icon"> <i
							class="fa fa-shopping-cart"></i> <span id="SLG" class="number__cart">
								<%
									int soLuongSP=0;
									for(GioHangBEAN ghang : gio){
										soLuongSP += ghang.getSoLuong();
									}
								    if(gio == null) out.print("0");else out.print(soLuongSP);
								%>
						</span>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="container">

			<div class="header__middle">
				<div class="header__category" id="headingOne">
					<a href="" class="header__category-name" data-toggle="collapse"
						data-target="#demo" aria-expanded="false"> <i
						class="fa fa-align-right header__category-icon"></i> Danh mục sản
						phẩm
					</a>

					<ul class="header__category-list collapse" id="demo">
						<%
							for (DanhMucBEAN danhMuc : danhMucBean) {
						%>

						<li class="header__category-item"><a
							href="DanhSachTheoDanhMucServlet?maDanhMuc=<%=danhMuc.getMaDanhMuc()%>"
							class="header__category-link"> <i class="fa fa-book"></i><%=danhMuc.getTenDanhMuc()%></a>



							<div class="sub__menu">
								<div class="sub__menu-left">

									<div class="sub__menu-inner"
										style="display: grid; width: 100%; height: 100%; grid-template-columns: repeat(3, 1fr); grid-template-rows: repeat(3, 1fr);">
										<%
											int soNhom = 0;

												for (NhomTheLoaiBEAN nhomTheLoai : nhomTheLoaiBean) {
													if (nhomTheLoai.getMaDanhMuc() == danhMuc.getMaDanhMuc()) {
										%>
										<div>

											<h3 class="sub__menu-title">
												<a href="SachTheoNhomTheLoaiServlet?maNhomTheLoai=<%=nhomTheLoai.getMaNhomTheLoai() %>" style="color: #000"
											><%=nhomTheLoai.getTenNhomTheLoai()%></a>
											</h3>

											<ul class="sub__menu-list">

												<%
													int soTheLoai = 0;
																for (TheLoaiBEAN theLoai : theLoaiBean) {
																	if (theLoai.getMaNhomTheLoai() == nhomTheLoai.getMaNhomTheLoai()) {
												%>
												<li class="sub__menu-item"><a
													href="SachTheoTheLoaiServlet?maTheLoai=<%=theLoai.getMaTheLoai()%>"
													class="sub__menu-link"><%=theLoai.getTenTheLoai()%></a></li>
												<%
													soTheLoai += 1;
																	}

																	if (soTheLoai == 3) {
																		out.print(
																				"<a href='' style='color: #ff5800;font-size: 12px;border-bottom: 1px solid #ff5800;'> Xem thêm</a>");
																		break;
																	}
																}
												%>

											</ul>
										</div>
										<%
											soNhom++;
													}

													if (soNhom == 9) {
														out.print(
																"<a href='' style='color: #ff5800;font-size: 12px;border-bottom: 1px solid #ff5800;'> Xem thêm</a>");
														break;
													}
												}
										%>
									</div>
								</div>



								<div class="sub__menu-right">
									<img src="image/menu_Sach_trong_nuoc.png" alt="">
								</div>
							</div></li>


						<%
							}
						%>
					</ul>
				</div>

				<div class="header__menu">
					<nav>
						<ul class="header__menu-list">
							<li class="header__menu-item"><a href="/KhoSach"
								class="header__menu-link">Trang chủ</a></li>
							<li class="header__menu-item"><a href=""
								class="header__menu-link">Giới thiệu</a></li>
							<li class="header__menu-item"><a href=""
								class="header__menu-link">Khuyến mãi</a></li>
							<li class="header__menu-item"><a href=""
								class="header__menu-link">Liên hệ</a></li>
							<%
							    if(session.getAttribute("maKhachHang")!=null){
							%>
							<li class="header__menu-item"><a href=""
								class="header__menu-link">Tài khoản</a>
								<ul style="box-shadow: 0 3px 10px rgba(34, 25, 25, 0.4);" class="header__menu-list-sub">
									<li><a href="Thongtincanhan" class="header__menu-link-sub">Thông tin
											cá nhân</a></li>
									<li><a href="DangXuatServlet"
										class="header__menu-link-sub">Đăng Xuất</a></li>
								</ul></li>

							<%
							    }
							%>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</header>
	<%@ include file="DangNhap.jsp"%>
	<!-- End of header -->
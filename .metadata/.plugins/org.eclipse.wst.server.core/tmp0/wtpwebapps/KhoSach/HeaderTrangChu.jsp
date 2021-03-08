<%@page import="model.bean.KhachHangBEAN"%>
<%@page import="model.bean.GioHangBEAN"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.bean.TheLoaiBEAN"%>
<%@page import="model.bean.NhomTheLoaiBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.DanhMucBEAN"%>
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/css.css">
<link rel="stylesheet" href="css/dangnhap.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/styleheader1.css">
<style type="text/css">
/*--------------------------------Menu search------------------------*/
.menu-search{
    margin-bottom: 0px;
    padding-left: 0px;
}
.menu-search li{
    padding:8px;
    padding-left: 12px;
    list-style: none;
    width: 100%;
}
.menu-search li:hover{
    background: #ff5800;
    
}
.menu-search li a{
    text-decoration: none;
    color: #000;
}
.resutlSearch{
    position: absolute;
    border-radius: 25px;
    box-shadow: 0 15px 20px rgba(0, 0, 0, 0.3);
    background-color: #fff;
    width: 100%;
    transition: 0.3s;
    overflow: hidden;
    z-index: 2000;
    border-color: rgba(0, 0, 0, .15);
   
}
.resutlSearch label{
   margin-bottom: 0px;
    cursor: pointer;
    background: #f1f1f1;
    color: #ff5800;
    width: 100%;
    text-align: center;
    height: 30px;
}

/*-------------------------------End Menu search------------------------*/
</style>
</head>

<body data-spy="scroll" data-target="#myScroll" data-offset="50">

	<!-- header -->
	<%
          	    DecimalFormat formatter = new DecimalFormat("###,###,###.00");
                ArrayList<DanhMucBEAN> danhMucBean = (ArrayList<DanhMucBEAN>) request.getAttribute("listDanhMuc");
                ArrayList<NhomTheLoaiBEAN> nhomTheLoaiBean = (ArrayList<NhomTheLoaiBEAN>) request.getAttribute("listNhomTheLoai");
                ArrayList<TheLoaiBEAN> theLoaiBean = (ArrayList<TheLoaiBEAN>) request.getAttribute("listTheLoai");
            
			    ArrayList<GioHangBEAN> gio = (ArrayList<GioHangBEAN>) session.getAttribute("gio");
								    KhachHangBEAN kh = (KhachHangBEAN) session.getAttribute("KhachHang");
																    Long TongTien=(long)0;
	%>
	<header class="header__container" >
		<div class="header__wrapper  js-container" style="padding-top: 20px">
			<div class="container" style="display:flex;">
				<div class="header__left-right">
					<div class="header__wrapper-left">
						<div class="header__logo">
							<a href=""> <img src="image/logo.png" alt="">
							</a>
						</div>
						<div class="header__form"style="display: block;">
							<form action="Timkiem" method="GET" >
								<input type="text" class="header__form-input" id="search" name="search"
									placeholder="Hôm nay bạn muốn tìm ...." required>
								<button type="submit" class="header__form-submit">Tìm
									kiếm</button>
							</form>
							<div  class="resutlSearch">
                                <ul class="menu-search"id="resutlSearch">
                               
                                </ul>
                               
                            </div>
                        </div>
						</div>
					</div>
					<div class="header__wrapper-right" style="margin-left: auto;">
						<%
						    if(session.getAttribute("KhachHang")!=null){
						%>
						<a class="header__wrapper-link" style="margin-top: 4px"> <i
							class="far fa-user"></i> Xin chào <%=kh.getTenKhachHang()%>
						</a>
						<%
						    }else{
						%>
						<a id="myBtn" class="header__wrapper-link"
							style="margin-top: 4px; cursor: pointer;"> <i
							class="far fa-user"></i> Tài khoản
						</a>
						<%
						    }
						%></a> <a href="" class="header__wrapper-link"> <i
							class="far fa-bell"></i> Thông báo
						</a> <a href="Giohang"
							class="header__wrapper-link shopping__cart-icon"> <i
							class="fas fa-shopping-cart"></i> <span id="SLG" class="number__cart">
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
	</header>


	<div style="height: 70px; background: #fff;"></div>

	<section>
		<div class="container">

			<div class="header__middle">
				<div class="row">
					<div class="col-lg-3 p-0">
						<div class="header__category">
							<a href="" class="header__category-name" data-toggle="collapse"
								data-target="#demo" aria-expanded="false"> <i
								class="fas fa-align-right header__category-icon"></i> Danh mục
								sản phẩm
							</a>

							<ul class="header__category-list collapse show" id="demo">
								<%
									for (DanhMucBEAN danhMuc : danhMucBean) {
								%>
								<li class="header__category-item"><a href="DanhSachTheoDanhMucServlet?maDanhMuc=<%=danhMuc.getMaDanhMuc() %>"
									class="header__category-link"> <i class="fas fa-book"></i><%=danhMuc.getTenDanhMuc()%>
								</a>

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

												<a style="color: #000" href="SachTheoNhomTheLoaiServlet?maNhomTheLoai=<%=nhomTheLoai.getMaNhomTheLoai()%>"
															class="sub__menu-link">
													<h3 class="sub__menu-title">
															<%=nhomTheLoai.getTenNhomTheLoai() %></h3>
											   </a>

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
					</div>


					<div class="col-lg-9 p-0">
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
											<li><a href="Thongtincanhan" class="header__menu-link-sub">Thông
													tin cá nhân</a></li>
											<li><a href="DangXuatServlet"
												class="header__menu-link-sub">Đăng Xuất</a></li>
										</ul></li>

									<%
									    }
									%>
								</ul>
							</nav>
							<div class="">
								<div class="">
									<div class="slider-inner">
										<div id="carouselExampleIndicators" class="carousel slide"
											data-ride="carousel">
											<div class="carousel-inner">

												<div class="carousel-item active animated heartBeat ">
													<img src="image/888x455px_3.png" class="d-block w-100"
														alt="">
												</div>
												<%for(int i=4;i<=8;i++){ %>
												<div class="carousel-item animated lightSpeedIn">
													<img src="image/888x455px_<%=i %>.png"
														class="d-block w-100 " alt="">
												</div>
												<% }%>


											</div>
											<a class="carousel-control-prev"
												href="#carouselExampleIndicators" role="button"
												data-slide="prev"> <span class="prev-left"> <i
													class="fas fa-chevron-left"></i>
											</span>
											</a> <a class="carousel-control-next"
												href="#carouselExampleIndicators" role="button"
												data-slide="next"> <span class="prev-left"> <i
													class="fas fa-chevron-right"></i>
											</span>
											</a>
										</div>
									</div>
									<!-- End of slider-inner -->
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>

	</section>
		<%@ include file="DangNhap.jsp"%>
	<!-- End of header -->
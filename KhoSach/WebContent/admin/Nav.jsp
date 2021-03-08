<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<nav class="navbar navbar-expand navbar-dark bg-white static-top"
	style="box-shadow: 0 .15rem 1.75rem 0 rgba(58, 59, 69, .15) !important;">

	<a class="navbar-brand mr-1" href="index.html"><img
		src="image/logo.png" alt="" style="width: 212px;"></a>

	<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
		id="sidebarToggle" href="#" style="background: #000">
		<i class="fas fa-bars"></i>
	</button>

	<!-- Navbar Search -->
	<form
		class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">

	</form>

	<!-- Navbar -->
	<ul class="navbar-nav ml-auto ml-md-0">
		<li class="nav-item dropdown no-arrow">
			<div style="display: inline-flex;">
			<% DecimalFormat formatter = new DecimalFormat("###,###,###.00");
				String tenAdmin = (String) session.getAttribute("txtTenDangNhap"); %>
				<h5 style="padding-top: 5px; padding-right: 30px; color: #000;">
					Xin chào <%=tenAdmin %> <i class="fas fa-user-circle fa-fw"></i>
				</h5>
				<div>
					<a class="nav-link dropdown-toggle" href="#" id="userDropdown"
						role="button" style="color: #000" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> <i
						class="fas fa-cog"></i>
					</a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="userDropdown">
						<a class="dropdown-item" href="#">Cài đặt</a> <a
							class="dropdown-item" href="#">Thông tin admin</a>
						<div class="dropdown-divider"></div>
						   <a class="dropdown-item" href="DangXuatAdminSevlet" >Đăng xuất</a>
					</div>
				</div>

			</div>

		</li>
	</ul>

</nav>

<div id="wrapper">

	<!-- Sidebar -->
	<ul class="sidebar navbar-nav">
		<li class="nav-item active"><a class="nav-link" href="index.php">
				<i class="fas fa-fw fa-tachometer-alt"></i> <span>Trang chủ</span>
		</a></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-list"></i> <span> Danh mục</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
				<h6 class="dropdown-header">Quản lý danh mục</h6>
				<a class="dropdown-item" href="ThemDanhMucServlet">Thêm danh mục</a>
				<a class="dropdown-item" href="DanhMucServlet">Danh sách danh
					mục</a>

			</div></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-fw fa-folder"></i> <span> Nhóm Thể loại</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
				<h6 class="dropdown-header">Quản lý nhóm thể loại</h6>
				<a class="dropdown-item" href="ThemNhomTheLoaiServlet">Thêm nhóm
					thể loại</a> <a class="dropdown-item" href="NhomTheLoaiServlet">Danh
					sách nhóm <br> thể loại</a>

			</div></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-fw fa-folder"></i> <span> Thể loại</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
				<h6 class="dropdown-header">Quản lý thể loại</h6>
				<a class="dropdown-item" href="ThemTheLoaiServlet">Thêm thể loại</a>
				<a class="dropdown-item" href="TheLoaiServlet">Danh sách thể
					loại</a>

			</div></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-book"></i> <span> Sách</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
				<h6 class="dropdown-header">Quản lý sách</h6>
				<a class="dropdown-item" href="ThemSachServlet">Thêm sách</a> <a
					class="dropdown-item" href="SachServlet">Danh sách sách</a>

			</div></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-file-alt"></i> <span> Đơn hàng</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
				<h6 class="dropdown-header">Quản lý đơn hàng</h6>
				<a class="dropdown-item" href="DanhSachHoaDonSevlet">Danh sách đơn hàng</a>

			</div></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-users"></i> <span> Khách hàng</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
				<h6 class="dropdown-header">Quản lý khách hàng</h6>
				<a class="dropdown-item" href="DanhSachKhachHangServlet">Danh sách khách hàng</a>

			</div></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"><i class="fa fa-comment" aria-hidden="true"></i> <span> Bình luận</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
				<h6 class="dropdown-header">Quản lý Bình luận</h6>
				 <a class="dropdown-item" href="DanhSachSachBinhLuanServlet">Danh sách bình luận</a>
			</div></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-user-alt"></i> <span> Admin</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
				<h6 class="dropdown-header">Quản lý admin</h6>
				<a class="dropdown-item" href="ThemAdminSevlet">Thêm admin</a> <a
					class="dropdown-item" href="DanhSachAdminSevlet">Danh sách admin</a>
			</div></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-paste"></i> <span> Thống kê</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
				<h6 class="dropdown-header">Thông kế</h6>
				<a class="dropdown-item" href="ThongKeTheoNamServlet">Số lượng hóa đơn <br> trong năm</a>
				<a class="dropdown-item" href="ThongKeDoanhThuTheoNamServlet">Doanh thu <br> trong năm</a>
				<a class="dropdown-item" href="BieuDoDanhThuTheoNam">Biểu đồ doanh thu</a>
			</div></li>
	</ul>

	<div id="content-wrapper"
		style="background: #f1f1f1; margin-bottom: 40px;">

		<div class="container-fluid">
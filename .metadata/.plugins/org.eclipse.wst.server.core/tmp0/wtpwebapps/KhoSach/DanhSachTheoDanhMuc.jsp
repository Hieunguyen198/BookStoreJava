<%@page import="model.bean.SachBEAN"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<div class="container chitiet-baner">
	<a href="">Trang chủ </a>/ <a href="">Danh mục sản phẩm</a>
</div>
<div class="container">
  <%
		ArrayList<SachBEAN> listSachBean = (ArrayList<SachBEAN>) request.getAttribute("listSach");
		ArrayList<String> listTacGia = (ArrayList<String>) request.getAttribute("listTacGia");
		ArrayList<String> listNhaXuatBan = (ArrayList<String>) request.getAttribute("listNhaXuatBan");
	%>
	<%String tenDanhMuc = (String) request.getAttribute("tenDanhSach"); %>
	<h2 class="title-section"><%=tenDanhMuc %>(<%=listSachBean.size() %>)</h2>
	<div class="row">
		<div class="col-lg-3 d-none d-lg-block pr-0"
			style="padding-left: 0; padding-right: 0px;">
			<div class="d-flex">
				<div>
					<div class="ty-product-filters__wrapper" style="background: #fff">
						<div class="ty-product-filters__block">
							<div
								class="ty-product-filters__switch cm-save-state cm-ss-reverse">
								<span>Nhà Xuất Bản</span>
							</div>
							<ul class="ty-product-filters" id="content_32_29">
								<li>
									<ul id="ranges_32_29" class="ty-product-filters-sub">
										<%
											for (String nhaXuatBan : listNhaXuatBan) {
										%>
										<li><label class="check"><%=nhaXuatBan%> <input
												type="checkbox"> <span class="checkmark"></span> </label></li>

										<%
											}
										%>
									</ul>
								</li>
							</ul>
						</div>
						<div class="ty-product-filters__block">
							<div class="ty-product-filters__switch cm-save-state ">
								<span class="ty-product-filters__title">Tác giả</span>
							</div>
							<div class="ty-product-filters__search">
								<input type="text" class="form-control" placeholder="Tìm kiếm"
									class="cm-autocomplete-off ty-input-text-medium" name="q"
									id="elm_search_32_32" value="" autocomplete="off"> <i
									class="ty-product-filters__search-icon ty-icon-cancel-circle hidden"
									id="elm_search_clear_32_32" title="Xóa"></i>
							</div>
							<div class="tacGiaScroll">
								<ul class="ty-product-filters" id="content_32_29">

									<li>
										<ul id="ranges_32_29" class="ty-product-filters-sub">
											<%
												for (String tacGia : listTacGia) {
											%>
											<li><label class="check"><%=tacGia%> <input
													type="checkbox"> <span class="checkmark"></span> </label></li>
											<%
												}
											%>
										</ul>

									</li>
								</ul>

							</div>
						</div>


					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-9 pl-0"
			style="padding-left: 0; padding-right: 0px;">
			<div class="product-list-dm " style="background: #fff">
				<%
					for (SachBEAN sach : listSachBean) {
				%>
				<a class="contentPage" href="Chitietsanpham?maSach=<%=sach.getMaSach() %>" style="margin: 10px;">
						<div class="product-single text-center" style="   border-radius: 10px; height: 270px;">
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
	  <ul id="pagination" class="d-flex justify-content-end align-items-center pt-3" style="margin-right: -13px;"></ul>

</div>
<%@ include file="FooterPagination.jsp"%>

<%@page import="model.bean.BinhLuanBEAN"%>
<%@page import="model.bean.SachBEAN"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<div class="container chitiet-baner">
	<a href="/KhoSach">Trang chủ </a>/ <a href="">Danh mục sản phẩm</a>/ <a style="color: #ff5800" href="">Chi
		tiết sản phẩm</a>
</div>
<div class="container chitiet-body">
	<div class="row">
		<div class="col-lg-3 chitiet-body-left">
			<div class="widget-box">
				<h3>Chính sách đổi trả</h3>
				<div class="content-widget">
					<div class="returnpolicy icon-return">
						<i class='fa fa-hand-holding-usd'></i> <strong>Hoàn tiền
							101%</strong> Nếu phát hiện hàng giả
					</div>
					<div class="returnpolicy">
						<i class='fa fa-sync-alt'></i> <strong>Đổi trả trong vòng
							7 ngày</strong> Không chấp nhận trường hợp thay đổi suy nghĩ
					</div>
					<div class="returnpolicy icon-waranty">
						<i class='fa fa-user-shield'></i> <strong>Bảo hành</strong> Nếu
						phát hiện hàng giả
					</div>
				</div>
			</div>
		</div>

		<div class="col-lg-9 chitiet-body-right">
			<div class="chitiet-body-right-content">
				<%
					SachBEAN sach = (SachBEAN) request.getAttribute("sach");
				%>
				<img src="image/<%=sach.getAnh()%>">
				<div class="chitiet-body-right-content-text">
					<h5>
						<bdi><%=sach.getTenSach()%></bdi>
					</h5>
					<div class="boder-content-text-ct"></div>
					<%if(sach.isTrangThai()){ %>
					<label class="trangThaiChiTiet"> Còn hàng </label>
					<% } else { %>
					<label class="trangThaiChiTiet"> Hết hàng </label>
					<% } %>
					<del style="font-size: 19px;"><%=formatter.format(sach.getGia())%>
						VND
					</del>
					<ins><%=formatter.format(sach.getGiaKhuyenMai())%>
						VND
					</ins>
					<%
						if (sach.getMoTa().length() > 300) {
					%>
					<p class="noiDung-right-content"><%=sach.getMoTa().substring(0, 300)%>...
					</p>
					<%
						} else {
					%>
					<p class="noiDung-right-content"><%=sach.getMoTa()%></p>
					<%
						}
					%>
					<form action="ThemSachGioHangServlet" accept="Post">
						<div class="ty-qty clearfix changer " id="qty_8962">
							<label class="ty-control-group__label" for="qty_count_8962">Số
								lượng:</label>
							<div class="ty-center ty-value-changer cm-value-changer">
								<a class="cm-decrease ty-value-changer__decrease"
									id="qty_count_tru" style="cursor: pointer;">−</a>
									<%if(sach.getSoLuong()!=0){ %>
									 <input
									type="text" size="5" class="ty-value-changer__input cm-amount"
									id="qty_count" name="sL" value="1" data-ca-min-qty="1">
									<%} else{ %>
									 <input
									type="text" size="5" class="ty-value-changer__input cm-amount"
									  value="0" data-ca-min-qty="1" readonly>
									<%} %>
								<a class="cm-increase ty-value-changer__increase"
									id="qty_count_cong" style="cursor: pointer;">+</a>
							</div>
						</div>

						<input type="hidden" name="mS" value="<%=sach.getMaSach()%>">
						<input type="hidden" name="tS" value="<%=sach.getTenSach()%>">
						<input type="hidden" name="sLM" value="<%=sach.getSoLuong()%>">
						<input type="hidden" name="anh" value="<%=sach.getAnh()%>">
						<input type="hidden" name="gia"
							value="<%=sach.getGiaKhuyenMai()%>">
						<div style="display: inline-flex;">
						<%if(sach.getSoLuong()!=0){ %>
						<button type="submit" class="ty-product-block__button-add">Thêm
								vào giỏ hàng</button>
						<%} %>
							
						</div>
					</form>
				</div>
			</div>
			<div
				style="margin-top: 30px; background: #fff; width: 100%; padding: 10px">
				<h2>Thông tin chi tiết</h2>
				<div class="boder-content-text"></div>
				<p style="padding: 10px; margin-top: -33px;"><%=sach.getMoTa()%></p>
			</div>
			<div class="comment__container" style="margin-top: 50px">
		<div class="form__comment">
			<form action="#">
				<div class="form__container">
					<div class="form-comment__group">
						<label class="form-comment__group-label">Đánh giá của bạn <span class="form-comment__required">*</span></label>
					</div>
					<div id="rating">
						<input type="radio" id="star5" name="rating" value="5" />
						<label class = "full" for="star5" title="Awesome - 5 stars"></label>

						<input type="radio" id="star4" name="rating" value="4" />
						<label class = "full" for="star4" title="Pretty good - 4 stars"></label>

						<input type="radio" id="star3" name="rating" value="3" />
						<label class = "full" for="star3" title="Meh - 3 stars"></label>

						<input type="radio" id="star2" name="rating" value="2" />
						<label class = "full" for="star2" title="Kinda bad - 2 stars"></label>

						<input type="radio" id="star1" name="rating" value="1" />
						<label class = "full" for="star1" title="Sucks big time - 1 star"></label>
					</div>
					
					
				</div>
				<div>
					<p class="text-danger" style="text-align: right;" id="resultDanhGia"></p>
					</div>
				<div class="comment__root" >
					
					<%
						    if(session.getAttribute("KhachHang")!=null){
					%>
					<label  class="form-comment__group-label"><%=kh.getTenKhachHang() %><span class="form-comment__required">*</span></label>
					<textarea id="submitBL" class="comment__textarea" placeholder="Viết bình luận..."></textarea>
					<input type="hidden" id="mKH" value="<%=kh.getMaKhachHang()%>">
					<input type="hidden" id="mS" value="<%=sach.getMaSach()%>">
					<%} else { %>
					<label  class="form-comment__group-label">Nội dung bình luận<span class="form-comment__required">*</span></label>
					  <textarea readonly class="comment__textarea" placeholder="Viết bình luận..."></textarea>
					<%} %>
					
				</div>
				<p class="text-danger" style="margin-left: 150px" id="resultBinhLuan"></p>
				<%ArrayList<BinhLuanBEAN> listBl = (ArrayList<BinhLuanBEAN>) request.getAttribute("listBL");%>
				<div class="filter__comment" style="margin-top: 50px; margin-bottom: 25px;">
					<label class="form-comment__group-label">Nhận xét về sản phẩm ( <%=listBl.size() %> nhận xét)</label>
					<div class="filter__name">
						<label class="form-comment__group-label">Hiển thị theo:</label>
						<select>
							<option>Tất cả đánh giá</option>
							<option>Mới Nhất</option>
							<option>cũ nhất</option>
						</select>
					</div>
				</div>
			</form>
			<div style="margin-left: 20px">
			<%
					for(BinhLuanBEAN bl : listBl){
			%>
			<div class="content-BinhLuan">
				<div class="text-binhLuan" >
					<label style="font-weight: 600;  color: #ff5800; padding-left: 10px;" class="tenKHBinhLuan"><%=bl.getTenKhachHang() %></label>
					<label style="padding-left: 10px" class="noiDungKHBinhLuan"><%=bl.getNoiDungBinhLuan() %></label>
				</div>
				<div class="baChamBinhLuan">
					<i data-toggle="tooltip" title="xóa chỉnh sửa bình luận này" onclick="showMenu(<%=bl.getMaBinhLuan()%>)" class="fa fa-ellipsis-h iconBaCham"></i>
					<nav id='nav-menu-bl<%=bl.getMaBinhLuan()%>'class="nav-menu-bl">
						<ul class="menu-bl">
							<li>xóa</li>
							<li> chỉnh sửa</li>
					</ul>
					</nav>
					
				</div>
			</div>
			<%} %>
		</div>
		</div>
	</div>
		</div>
	</div>

</div>
<!-- End of main !-->
<%@ include file="Footer.jsp"%>
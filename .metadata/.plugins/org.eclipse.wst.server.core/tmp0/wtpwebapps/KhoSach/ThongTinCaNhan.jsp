<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp" %>

<div class="container information" >
<%if(request.getAttribute("ThongBao")!=null){
	out.print("<script>alert('Đặt hàng thành công! Vui lòng xem lịch sử mua hàng.')</script>");
}%>
  <%KhachHangBEAN khachHang = (KhachHangBEAN) request.getAttribute("khachHang"); %>
   <div class="row ">
    <div class="information-left col-2">
        <h4 style="padding-left: 10px;"><%=khachHang.getTenKhachHang() %></h4>
        <ul class="menu-information nav nav-tabs ">
            <li class="nav-item" > 
              <a href="#thongTinKhachHang" class="nav-link active" data-toggle="tab">
                <div class="fa fa-user"></div> Thông tin cá nhân</a>
            </li>
            <li class="nav-item"> <a href="#capNhatMatKhau" class="nav-link" data-toggle="tab">
                <div class="fa fa-key"></div> Thay đổi mật khẩu</a>
            </li>
            <li class="nav-item">
             <a class="nav-link" data-toggle="tab" href="#lichSuMuaHang">
                <div class="fa fa-history"></div> Lịch sử mua hàng</a>
            </li>
            <li class="nav-item"> 
                <a class="nav-link" href="DangXuatServlet"><i class="fa fa-sign-out-alt"></i> Đăng xuất</a></li>
            </ul>
        </div>
        <div class="information-right clo-10 tab-content">
        <div class="information-right-content tab-pane fade in show active" id="thongTinKhachHang">
                <div class="information-right-content-title">
                    <h4 >THÔNG TIN KHÁCH HÀNG</h4>
                    <label id="editInfo"><i class="fa fa-edit"></i></label>
                </div>
                <hr>
              
                <div class="information-right-content-sub">
                    <div class="information-right-content-sub-line">
                        <label>Tên khách hàng : </label>
                        <p><%=khachHang.getTenKhachHang() %></p>
                    </div>
                    
                    <div class="information-content-text"></div>
                    <div class="information-right-content-sub-line">
                        <label>Tên đăng nhập : </label>
                        <p> <%=khachHang.getTenDangNhap() %></p>
                    </div>
                    <div class="information-content-text"></div>
                    <div class="information-right-content-sub-line">
                        <label>Ngày sinh : </label>
                        <p> <%=khachHang.getNgaySinhString() %></p>
                    </div>
                    <div class="information-content-text"></div>
                    <div class="information-right-content-sub-line">
                     <label>Giới tính : </label>
                     <% if(khachHang.isGioiTinh()){ %>
                     <p>Nam </p>
                     <%} else{ %>
                     <p>Nữ </p>
                     <%} %>
                     <p> </p>
                 </div>
                 <div class="information-content-text"></div>
                 <div class="information-right-content-sub-line">
                     <label>Địa chỉ : </label>
                     <p> <%=khachHang.getDiaChi() %></p>
                 </div>
                 <div class="information-content-text"></div>
                 <div class="information-right-content-sub-line">
                    <label>Email : </label>
                    <p> <%=khachHang.getEmail() %></p>
                </div>
                <div class="information-content-text"></div>
                <div class="information-right-content-sub-line">
                 <label>Số điện thoại : </label>
                 <p> <%=khachHang.getSoDienThoai() %></p>
             </div>
             <div class="information-content-text"></div>
         </div>
     </div>
     <!-- cập nhật mật khẩu -->
     <%@ include file="ThayDoiMatKhau.jsp" %>
   <!-- cập nhật mật khẩu -->
    <!-- Lịch sử mua hàng -->
     <%@ include file="LichSuMuaHang.jsp" %>
   <!-- end Lịch sử mua hàng -->
</div>
</div>
</div>
<!-- cập nhậtthông tin -->
<%@ include file="CapNhatThongTin.jsp" %>
<!-- end cập nhậtthông tin -->
<%@ include file="Footer.jsp" %>
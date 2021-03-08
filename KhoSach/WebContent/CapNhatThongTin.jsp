<%@page import="model.bean.KhachHangBEAN"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="container mt-3">
  <div class="modal fade" id="editInfoModal">
    <div class="modal-dialog">
      <div class="modal-content" style="width: 700px">

        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Cập nhập khách hàng</h4>
          <button type="button" class="close" data-dismiss="modal">×</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form method="POST" action="CapNhatThongTinServlet" >
        <div class="row">
          <%KhachHangBEAN khachHang2 = (KhachHangBEAN) request.getAttribute("khachHang"); %>
            <div class="col-sm-3">
                <div class="form-group">
                    <label>Mã khách hàng</label> 
                    <input type="text" class="text form-control"  value="<%=khachHang2.getMaKhachHang() %>" readonly name="maKhachHang">
                </div>
            </div>
            <div class="col-sm-5">
                <div class="form-group">
                    <label>Tên khách hàng</label>
                    <input type="text"  class="text form-control" value="<%=khachHang2.getTenKhachHang() %>" placeholder="Tên khách hàng" required name="tenKhachHang">
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Tên đăng nhập</label>
                    <input type="text"  class="text form-control" value="<%=khachHang2.getTenDangNhap() %>" readonly>
                </div>
            </div>
        </div>
        <div class="row p-2 pt-3">
            <div class="col-sm-5">
                <div class="form-group">
                    <label>Ngày sinh</label>
                    <input type="date" class="text form-control" value="<%=khachHang2.getNgaySinhString() %>" placeholder="Ngày sinh" required name="ngaySinh">
                </div>
            </div>
            <div class="col-sm-5">
                <div class="form-group">
                    <label style=" width: 100%;">Giới tính</label>
                    <%if(khachHang2.isGioiTinh()){ %>
                     <input type="radio" checked="checked" name="gioiTinh"
                    value="true"> <label style="margin-right: 10px;">Nam</label> 
                    <input type="radio" name="gioiTinh" value="false"><label>Nữ</label>
                    <%}else { %>
                    <input type="radio"  name="gioiTinh"
                    value="true"> <label style="margin-right: 10px;">Nam</label> 
                    <input type="radio" checked="checked" name="gioiTinh" value="false"><label>Nữ</label>
                    <%} %>
                    
                </div>
            </div>
        </div>
        <div class="row p-2 pt-3">
            <div class="col-sm-10">
                <label>Địa chỉ </label> <input type="text" value="<%=khachHang2.getDiaChi() %>"
                class="form-control" name="diaChi"
                placeholder="Địa chỉ" required>
            </div>
        </div>
        <div class="row p-2 pt-3">
            <div class="col-sm-5">
                <label>Email </label> <input type="text" value="<%=khachHang2.getEmail() %>"
                class="form-control" name="email"
                placeholder="Địa chỉ" required>
            </div>
            <div class="col-sm-5">
                <label>Số điện thoại </label> <input type="text" value="<%=khachHang2.getSoDienThoai() %>"
                class="form-control" name="soDienThoai"
                placeholder="Địa chỉ" required>
            </div>
        </div>
        <h1 style="text-align: right; margin-top: 10px;">
           <button type="submit" class="btn btn-success mb-3" name="subCapNhat">Cập nhật</button>
           <a class="btn btn-danger ml-3 mb-3" style="color: #fff" data-dismiss="modal">Hủy</a>
       </h1>

   </form>
</div>
</div>
</div>
</div>
</div>
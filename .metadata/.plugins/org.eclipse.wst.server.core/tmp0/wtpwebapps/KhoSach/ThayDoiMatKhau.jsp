<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="information-right-content tab-pane fade" id="capNhatMatKhau">
         <div class="information-right-content-title">
                    <h4 >THAY ĐỔI MẬT KHẨU MẬT KHẨU</h4>
            </div>
        <hr>
       <form  action="" >

            <div class="form-group">
                <label>Mật khẩu cũ</label> 
                <input type="password" class="text form-control" placeholder="Mật khẩu cũ" name="matkhaucu" id="matKhauCu" required >
                <p class="text-danger" id="resultMatKhauCu"></p>
            </div>

            <div class="form-group">
                <label>Mật khẩu mới</label>
                <input type="password"  class="text form-control" placeholder="Mật khẩu mới" id="matKhauMoi" required >
                <p class="text-danger" id="resultMatKhauMoi"></p>
            </div>

            <div class="form-group">
                <label>Nhật lại mật khẩu mới</label>
                <input type="password"  class="text form-control" placeholder="Xác nhận mật khẩu" id="matKhauXacNhan" required >
           		<p class="text-danger" id="resultMatKhauXacNhan"></p>
            </div>
             <h1 style="text-align: right; margin-top: 10px;">
           <button  class="btn btn-success mb-3" id="subCapNhatMK" >Cập nhật</button>
       </h1>
        </form>
       
   </div>
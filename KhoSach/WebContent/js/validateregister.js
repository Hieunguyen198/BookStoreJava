$(document).ready(function() {
	$('#subDangKy').click(function(e) {
		e.preventDefault();
		if($('#full_name').val()!=""&&$('#user_name').val()!=""&&$('#pphone').val()!=""&&$('#pemail').val()!=""
			&&$('#ppassword1').val()!=""&&$('#ppassword2').val()!=""&&$('#ngaySinh').val()!=""){
		$.ajax({
			type : "POST",
			url : "DangKyServlet", 
			dataType:"text",
			data:{
				hoten : $('#full_name').val(),
				tendn : $('#user_name').val(),
				sdt : $('#pphone').val(),
				email: $('#pemail').val(),
				matkhau1: $('#ppassword1').val(),
				matkhau2: $('#ppassword2').val(),
				gt:$("input[name='radioGroup']:checked").val(),
				ngaysinh: $('#ngaySinh').val(),
			},
			success : function(result) {
				$('#resultemail').text("");
				$('#resultphone').text("");
				$('#resultusername').text("");
				$('#resultMK1').text("");
				$('#resultempty').text("");
				if(result=="1"){
					$('#resultemail').html('<i class="fa fa-exclamation-circle"></i> Email chưa đúng định dạng');
				}
				if(result=="2"){
					$('#resultphone').html('<i class="fa fa-exclamation-circle"></i> Số điện thoại chưa đúng định dạng');
				}	 
				if(result=='3'){
					$('#resultusername').html( '<i class="fa fa-exclamation-circle"></i> Tên đăng nhập đã tồn tại');
				}
				if(result=="4"){
					$('#resultemail').html( '<i class="fa fa-exclamation-circle"></i> Email đã tồn tại');
				}
				if(result=="5"){
					$('#resultphone').html( '<i class="fa fa-exclamation-circle"></i> Số điện thoại đã tồn tại');
				}
				if(result=="6"){
					$('#resultMK1').html( '<i class="fa fa-exclamation-circle"></i> Mật khẩu và mật khẩu xác nhận không trùng nhau');
				}
				if(result=="Thanh cong"){
					$('#full_name').val("");
					$('#user_name').val("");
					$('#pphone').val("");
					$('#pemail').val("");
					$('#ppassword1').val("");
					$('#ppassword2').val("");
					$('#male').val("");
					$('#female').val("");
					$('#ngaySinh').val("");
					alert("Đăng ký thành công! mời đăng nhập");
				}
			}
		});
		}else{
				$('#resultempty').html( '<i class="fa fa-exclamation-circle"></i>Không được bỏ trống các trường ');
		}
	});
});
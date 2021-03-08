$(document).ready(function() {
	$('#subCapNhatMK').click(function(e) {
		e.preventDefault();
		if($('#matKhauMoi').val()!=""&&$('#matKhauMoi').val()!=""&& $('#matKhauXacNhan').val()!=""){
		$.ajax({
			type : "POST",
			url : "ThayDoiMatKhauServlet", //Tên servlet
			dataType:"text",
			data : {
				matKhauCu : $('#matKhauCu').val(),
				matKhauMoi : $('#matKhauMoi').val(),
				matKhauXacNhan : $('#matKhauXacNhan').val()
			},
			success : function(result) {
				$('#matKhauCu').val("");
				$('#matKhauMoi').val("");
				$('#matKhauXacNhan').val("");
				$('#resultMatKhauCu').html("");
				$('#resultMatKhauXacNhan').html("");
				$('#resultMatKhauMoi').html("");
				if(result=="1"){
					$('#resultMatKhauCu').html('<i class="fa fa-exclamation-circle"></i> Sai mật khẩu cũ');
				}
				if(result=="2"){
					 alert("Cập nhật mật khẩu thành công");
				}
				if(result=="0"){i
						$('#resultMatKhauXacNhan').html( '<i class="fa fa-exclamation-circle"></i> Mật khẩu xác nhận không trùng mật khẩu mới');
						
					}
				}
		});
		}else{
			$('#resultMatKhauCu').html('<i class="fa fa-exclamation-circle"></i> Vui lòng điền đủ thông tin');
			$('#resultMatKhauXacNhan').html('<i class="fa fa-exclamation-circle"></i> Vui lòng điền đủ thông tin');
			$('#resultMatKhauMoi').html('<i class="fa fa-exclamation-circle"></i> Vui lòng điền đủ thông tin');
		}
	});
	$('#matKhauXacNhan').change(function(){
		if($('#matKhauMoi').val()==$('#matKhauXacNhan').val()){
			$('#resultMatKhauXacNhan').text("");
		}else{
			$('#resultMatKhauXacNhan').html('<i class="fa fa-exclamation-circle"></i> Mật khẩu xác nhận không trùng mật khẩu cũ');
		}
	});
});
$(document).ready(function() {
	$('#subDangNhap').click(function(e) {
		e.preventDefault();
		if($('#userName').val()!="" &&$('#password').val()!="" ){
		$.ajax({
			type : "POST",
			url : "DangNhapServlet", 
			dataType:"text",
			data:{
				userName : $('#userName').val(),
				password : $('#password').val()
			},
			success : function(result) {
				$('#result').val("");
				if(result=="0"){
					$('#result').html('<i class="fa fa-exclamation-circle"></i> Tên đăng nhập hoặc mật khẩu không đúng!');
					$('#userName').val();
					
				}else{
					window.location = result;
				}
			}
		});
		}else{
			$('#result').html('<i class="fa fa-exclamation-circle"></i> Tên đăng nhập hoặc mật khẩu không đúng!');
		}
	});
});
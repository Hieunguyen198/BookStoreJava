$(document).ready(function() {
	$('#submitBL').keypress(function(e) {
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if (keycode == '13') {
			// alert($('#submitBL').val()+" "+ $('#mKH').val()+"
			// "+$('#mS').val()+"
			// "+$("input[name='rating']:checked").val());
			//$('#submitBL').text("");
			if($("input[name='rating']:checked").val()!=null){
				if($('#submitBL').val()!=""){	
			$.ajax({
				type : "POST",
				url : "ThemBinhLuanServlet", // Tên servlet
				dataType : "text",
				data : {
					noiDungBinhLuan : $('#submitBL').val(),
					maKhachHang : $('#mKH').val(),
					maSach : $('#mS').val(),
					danhGia : $("input[name='rating']:checked").val()
				},
				success : function(result) {
					$('#submitBL').val("");
					
				}

			});

				}else{
					$('#resultBinhLuan').html('<i class="fa fa-exclamation-circle"></i> Vui lòng viết nội dung bình luận ');
				}
			}else{
				$('#resultDanhGia').html('<i class="fa fa-exclamation-circle"></i> Vui lòng đánh giá ');
			}
		}
	});
	
});
function showMenu(id){
	  $('#nav-menu-bl'+id).toggleClass("nav-menu-bl-show");
};
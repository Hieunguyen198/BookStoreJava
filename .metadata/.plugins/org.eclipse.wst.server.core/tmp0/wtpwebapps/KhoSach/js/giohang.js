$(document).ready(function() {

	/*
	 * $('a').click(function(e) { e.preventDefault(); var maSach =
	 * $('.mS').val(); alert(maSach)
	 */
	// $.ajax({
	// type : "POST",
	// dataType:"text",
	// url : "CapNhatSoLuongGioHangServlet", //Tên servlet
	// data : {
	// mS : $('#mS').val(),
	// sL : "+1"
	// },success : function(result) {
	// alert(result);
	// }
	// });
	/* }); */
	// $('#tang').click(function(e) {
	// var sl = parseInt($('#sl').val(), 10)
	// $('#sl').val(sl+1);
	// });
});
function changeText(id) {
	var sl = parseInt($('#sl' + id).val(), 10) +1;
	var gia = parseInt($('#gia'+ id).text(), 10) *sl;
	$('#sl' + id).val(sl);
	$('#tongGia'+ id).text(gia+"đ");
		$.ajax({
			type : "POST",
			dataType : "text",
			url : "CapNhatSoLuongGioHangServlet", // Tên servlet
			data : {
				mS : id,
				sL : "+1"
			},
			success : function(result) {
			//	alert(result);
			}
		});

}


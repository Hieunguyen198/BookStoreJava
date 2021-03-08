function deleteRow(maHoaDon) {
	if (confirm('Bạn có thực sự muốn xóa nó')){
	$.ajax({
		type : "POST",
		url : "HuyDonServlet", //Tên servlet
		dataType:"text",
		data : {
			maHoaDon : maHoaDon
		},success : function(result) {
			$('#trXoaDonHang'+maHoaDon).remove();
		}
	});
	}
}
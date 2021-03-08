function XoaSach(maSach) {
	confirm('Bạn có thực sự muốn xóa nó');
	$.ajax({
		type : "POST",
		url : "XoaSachServlet", //Tên servlet
		dataType:"text",
		data : {
			maSach : maSach
		},success : function(result) {
			$('#trXoaSach'+maSach).remove();
		}
	});
}
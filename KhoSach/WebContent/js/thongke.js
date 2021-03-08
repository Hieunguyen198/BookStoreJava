$(document).ready(function() {
	$('#namThongKe').change(function() {
		var nam = $("#namThongKe").val();
		$.ajax({
			type : "GET",
			url : "ThongKeTheoNamServlet", // Tên servlet
			data : "nam=" + nam, // Gán giá trị vào name mục
			dataType : "json",
			async : true,
			cache : false,
			success : function(result) {
				$('td').remove();
				$('#titleThongKe').text('THỐNG KÊ SỐ LƯỢNG HÓA ĐƠN THEO TUẦN THÁNG TRONG '+nam+' NĂM')
				$('#tableThongKe').append("<td>" + result.thang1 + "</td>");
				$('#tableThongKe').append("<td>" + result.thang2 + "</td>");
				$('#tableThongKe').append("<td>" + result.thang3 + "</td>");
				$('#tableThongKe').append("<td>" + result.thang4 + "</td>");
				$('#tableThongKe').append("<td>" + result.thang5 + "</td>");
				$('#tableThongKe').append("<td>" + result.thang6 + "</td>");
				$('#tableThongKe').append("<td>" + result.thang7 + "</td>");
				$('#tableThongKe').append("<td>" + result.thang8 + "</td>");
				$('#tableThongKe').append("<td>" + result.thang9 + "</td>");
				$('#tableThongKe').append("<td>" + result.thang10 + "</td>");
				$('#tableThongKe').append("<td>" + result.thang11 + "</td>");
				$('#tableThongKe').append("<td>" + result.thang12 + "</td>");

							}

						});
					});
		});
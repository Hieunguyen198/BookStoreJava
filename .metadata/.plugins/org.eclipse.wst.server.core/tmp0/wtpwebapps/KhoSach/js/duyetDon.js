    function clickDuyet(maHoaDon) {
        $.ajax({
            type: "GET",
            url: "DuyetHoaDonServlet", 
            data: "maHoaDon="+ maHoaDon,
            dataType: "text",
            async: true,
            cache: false,
            success: function (result) {
            	if(result!="0"){
            		alert("Sách có mã "+ result + " không đủ số lượng")
            	}else{
            		$('#trangThai'+maHoaDon).text("Đã duyệt");
            	}
            }
           
        });
       
    }
    function clickTraDon(maHoaDon) {
        $.ajax({
            type: "GET",
            url: "TraDonServlet", 
            data: "maHoaDon="+ maHoaDon,
            dataType: "text",
            async: true,
            cache: false,
            success: function (result) {
            	$('#trangThai'+maHoaDon).text("Đã thu hồi đơn");
            }
        });
       
    }
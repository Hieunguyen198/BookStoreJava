function TangSL(id) {
	var MaDV = document.getElementById('sl' + id).value;
	var sl = parseInt($('#sl' + id).val(), 10) + 1;
	if (sl > 0 && isNaN(Math.floor(MaDV)) == false) {
		var slM = parseInt($('#slMax' + id).val(), 10);
		if (sl <= slM) {
			var slc = parseInt($('#slc' + id).val(), 10);
			var slt = parseInt($('#SLG').text(), 10);
			var gia = parseInt($('#gia' + id).text(), 10) * sl;
			var gia1 = parseInt($('#gia' + id).text(), 10);
			// var slg = parseInt($('#SLG').text(), 10);
			slt = slt + sl - slc;
			var tongTien = parseInt($('#tongTien').text(), 10) + (sl - slc)
					* gia1;
			$('#slc' + id).val(sl);
			$('#sl' + id).val(sl);
			$('#tongGia' + id).text(gia + " đ");
			$('#tongTien').text(tongTien + " đ");
			$('#SLG').text(slt);
		} else {
			alert("Số lượng tối đa của sách này là " + slM);
			var slc = parseInt($('#slc' + id).val(), 10);
			sl = slc;
			var slt = parseInt($('#SLG').text(), 10);
			var gia = parseInt($('#gia' + id).text(), 10) * sl;
			var gia1 = parseInt($('#gia' + id).text(), 10);
			$('#sl' + id).val(sl);
			slt = slt + sl - slc;
			var tongTien = parseInt($('#tongTien').text(), 10) + (sl - slc)
					* gia1;
			// $('#sl' + id).val(sl);
			$('#slc' + id).val(sl);
			$('#SLG').text(slt);
			$('#tongGia' + id).text(gia + " đ");
			$('#tongTien').text(tongTien + " đ");
		}
			$.ajax({
				type : "POST",
				dataType : "text",
				url : "CapNhatSoLuongGioHangServlet", // Tên servlet
				data : {
					mS : id,
					sL : sl - slc
				},
				success : function(result) {
					// alert(result);
				}
			});
		
		
	} else {
		alert("Vui lòng nhập đúng số lượng là số nguyên lớn hơn 0");
		var slc = parseInt($('#slc' + id).val(), 10);
		sl = slc;
		var slt = parseInt($('#SLG').text(), 10);
		var gia = parseInt($('#gia' + id).text(), 10) * sl;
		var gia1 = parseInt($('#gia' + id).text(), 10);
		$('#sl' + id).val(sl);
		slt = slt + sl - slc;
		var tongTien = parseInt($('#tongTien').text(), 10) + (sl - slc) * gia1;
		// $('#sl' + id).val(sl);
		$('#slc' + id).val(sl);
		$('#SLG').text(slt);
		$('#tongGia' + id).text(gia + " đ");
		$('#tongTien').text(tongTien + " đ");
	}

}
function GiamSL(id) {
	var MaDV = document.getElementById('sl' + id).value;
	var sl = parseInt($('#sl' + id).val(), 10) - 1;
	if (sl > 0 && isNaN(Math.floor(MaDV)) == false) {
		var slM = parseInt($('#slMax' + id).val(), 10);
		if (sl <= slM) {
		var slc = parseInt($('#slc' + id).val(), 10);
		var slt = parseInt($('#SLG').text(), 10);
		//alert(slc);
		//alert(sl);
		var gia = parseInt($('#gia' + id).text(), 10) * sl;
		var gia1 = parseInt($('#gia' + id).text(), 10);
		// var slg = parseInt($('#SLG').text(), 10) - 1;
		slt = slt + sl - slc;
		var tongTien = parseInt($('#tongTien').text(), 10) + (sl - slc) * gia1;
		$('#slc' + id).val(sl);
		$('#sl' + id).val(sl);
		$('#tongGia' + id).text(gia + " đ");
		$('#tongTien').text(tongTien + " đ");
		$('#SLG').text(slt);
		} else {
			alert("Số lượng tối đa của sách này là " + slM);
			var slc = parseInt($('#slc' + id).val(), 10);
			sl = slc;
			var slt = parseInt($('#SLG').text(), 10);
			var gia = parseInt($('#gia' + id).text(), 10) * sl;
			var gia1 = parseInt($('#gia' + id).text(), 10);
			$('#sl' + id).val(sl);
			slt = slt + sl - slc;
			var tongTien = parseInt($('#tongTien').text(), 10) + (sl - slc)
					* gia1;
			// $('#sl' + id).val(sl);
			$('#slc' + id).val(sl);
			$('#SLG').text(slt);
			$('#tongGia' + id).text(gia + " đ");
			$('#tongTien').text(tongTien + " đ");
		}
	$.ajax({
		type : "POST",
		dataType : "text",
		url : "CapNhatSoLuongGioHangServlet", // Tên servlet
		data : {
			mS : id,
			sL : sl - slc
		},
		success : function(result) {
			// alert(result);
		}
	});
	}else {
		alert("Vui lòng nhập đúng số lượng là số nguyên lớn hơn 0");
		var slc = parseInt($('#slc' + id).val(), 10);
		sl = slc;
		var slt = parseInt($('#SLG').text(), 10);
		var gia = parseInt($('#gia' + id).text(), 10) * sl;
		var gia1 = parseInt($('#gia' + id).text(), 10);
		$('#sl' + id).val(sl);
		slt = slt + sl - slc;
		var tongTien = parseInt($('#tongTien').text(), 10) + (sl - slc) * gia1;
		// $('#sl' + id).val(sl);
		$('#slc' + id).val(sl);
		$('#SLG').text(slt);
		$('#tongGia' + id).text(gia + " đ");
		$('#tongTien').text(tongTien + " đ");
	}

}
function updateCart(id) {
	var keycode = (event.keyCode ? event.keyCode : event.which);
	if (keycode == '13') {
		var MaDV = document.getElementById('sl' + id).value;
		var sl = parseInt($('#sl' + id).val(), 10);
		if (isNaN(Math.floor(MaDV)) == false && parseInt(MaDV) > 0) {
			var slM = parseInt($('#slMax' + id).val(), 10);
			if (sl <= slM) {
				var slc = parseInt($('#slc' + id).val(), 10);
				var slt = parseInt($('#SLG').text(), 10);
				var gia = parseInt($('#gia' + id).text(), 10) * sl;
				var gia1 = parseInt($('#gia' + id).text(), 10);
				slt = slt + sl - slc;
				var tongTien = parseInt($('#tongTien').text(), 10) + (sl - slc)
						* gia1;
				// $('#sl' + id).val(sl);
				$('#slc' + id).val(sl);
				$('#SLG').text(slt);
				$('#tongGia' + id).text(gia + " đ");
				$('#tongTien').text(tongTien + " đ");
			} else {
				alert("Số lượng tối đa của sách là " + slM);
				var slc = parseInt($('#slc' + id).val(), 10);
				sl = slc;
				var slt = parseInt($('#SLG').text(), 10);
				var gia = parseInt($('#gia' + id).text(), 10) * sl;
				var gia1 = parseInt($('#gia' + id).text(), 10);
				$('#sl' + id).val(sl);
				slt = slt + sl - slc;
				var tongTien = parseInt($('#tongTien').text(), 10) + (sl - slc)
						* gia1;
				// $('#sl' + id).val(sl);
				$('#slc' + id).val(sl);
				$('#SLG').text(slt);
				$('#tongGia' + id).text(gia + " đ");
				$('#tongTien').text(tongTien + " đ");
			}
			$.ajax({
				type : "POST",
				dataType : "text",
				url : "CapNhatSoLuongGioHangServlet", // Tên servlet
				data : {
					mS : id,
					sLEnter : sl
				},
				success : function(result) {
					// alert(result);
				}
			});

		} else {
			alert("Vui lòng nhập đúng số lượng là số nguyên lớn hơn 0");

			var slc = parseInt($('#slc' + id).val(), 10);
			sl = slc;
			var slt = parseInt($('#SLG').text(), 10);
			var gia = parseInt($('#gia' + id).text(), 10) * sl;
			var gia1 = parseInt($('#gia' + id).text(), 10);
			$('#sl' + id).val(sl);
			slt = slt + sl - slc;
			var tongTien = parseInt($('#tongTien').text(), 10) + (sl - slc)
					* gia1;
			// $('#sl' + id).val(sl);
			$('#slc' + id).val(sl);
			$('#SLG').text(slt);
			$('#tongGia' + id).text(gia + " đ");
			$('#tongTien').text(tongTien + " đ");
		}
	} else {
	}
	event.stopPropagation();
};
function xoaSach(id) {
	var trLength = table.getElementsByTagName("tr").length;
	if(trLength>3){
		var slc = parseInt($('#slc' + id).val(), 10);
		sl = 0;
		var slt = parseInt($('#SLG').text(), 10);
		var gia1 = parseInt($('#gia' + id).text(), 10);
		slt = slt + sl - slc;
		var tongTien = parseInt($('#tongTien').text(), 10) + (sl - slc) * gia1;
		$('#tongTien').text(tongTien + " đ");
		$('#SLG').text(slt);
		$.ajax({
			type : "POST",
			dataType : "text",
			url : "XoaSachTrongGioServlet", // Tên servlet
			data : {
				mS : id
			},
			success : function(result) {
				// alert(result);
					$('#tr' + id).remove();
				
			}
		});
	}else{
		xoaSachAll();
	}
}
	
function xoaSachAll() {
	$.ajax({
		type : "POST",
		dataType : "text",
		url : "XoaSachTrongGioServlet", // Tên servlet
		data : {
			k : "1"
		},
		success : function(result) {
			// alert(result);
				window.location = "Giohang";
		}
	});
}

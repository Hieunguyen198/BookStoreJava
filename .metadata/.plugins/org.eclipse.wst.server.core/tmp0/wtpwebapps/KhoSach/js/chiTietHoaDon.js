
    function clickChiTiet(maHoaDon) {
        $.ajax({
            type: "GET",
            url: "ChiTietHoaDonServlet", //Tên servlet
            data: "maHoaDonCT="+ maHoaDon,  //Gán giá trị vào name mục đich để servlet nhận được Parameter
            dataType: "json",
            async: true,
            cache: false,
            success: function (result) {
//                Lấy size của list này
                var listSize = Object.keys(result).length;
                if (listSize > 0) {
                    $('#message').text("");
                    $('#trChiTiet'+maHoaDon).html("");
//                    Khai báo table kiểu global để sử dụng ngoài fuction này
                    table = document.getElementById('trChiTiet'+maHoaDon);
                    
                    for (i = 0; i < listSize; i++) {
                        var row = table.insertRow(0);

                        var cell = row.insertCell(0);
                        var cell1 = row.insertCell(1);
                        var cell2 = row.insertCell(2);
                        var cell3 = row.insertCell(3);
                        var cell4 = row.insertCell(4);
                        var cell5 = row.insertCell(5);
                        var cell6 = row.insertCell(6);
                        
                        cell.innerHTML = result[i].maHoaDon;
                        cell1.innerHTML = result[i].maSach;
                        cell2.innerHTML = result[i].tenSach;
                        cell3.innerHTML = "<img style='width: 60px' src='image/"+result[i].anh+"'>"
                        cell4.innerHTML = result[i].soLuong;
                        cell5.innerHTML = result[i].gia;
                        cell6.innerHTML = result[i].tongTien;

                      
                    }
                    
                }

            }
        });
       
    }
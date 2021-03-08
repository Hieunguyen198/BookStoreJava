    function ChiTietBL(maSach) {
        $.ajax({
            type: "GET",
            url: "DanhSachBinhLuanServlet", //Tên servlet
            data: "maSach="+maSach,  //Gán giá trị vào name mục đich để servlet nhận được Parameter
            dataType: "json",
            async: true,
            cache: false,
            success: function (result) {

//                Lấy size của list này
                var listSize = Object.keys(result).length;
                if (listSize > 0) {
                    $('#trBinhLuan'+maSach).html("");
//                    Khai báo table kiểu global để sử dụng ngoài fuction này
                    table = document.getElementById('trBinhLuan'+maSach);
                    for (i = 0; i < listSize; i++) {
                        var row = table.insertRow(0);

                        var cell = row.insertCell(0);
                        var cell1 = row.insertCell(1);
                        var cell2 = row.insertCell(2);
                        var cell3 = row.insertCell(3);
                        var cell4 = row.insertCell(4);
                        var cell5 = row.insertCell(5);
                        var cell6 = row.insertCell(6);
         
                        cell.innerHTML = result[i].maBinhLuan;
                        cell1.innerHTML = result[i].maKhachHang;
                        cell2.innerHTML = result[i].tenKhachHang;
                        cell3.innerHTML = result[i].noiDungBinhLuan;
                        cell4.innerHTML = result[i].danhGia;
                        cell5.innerHTML = result[i].thoiGian;
                        cell6.innerHTML = '<a style="margin-right: 3px;"  class="btn btn-info" onclick="XemTraLoi('+result[i].maBinhLuan+ ')" data-toggle="modal" data-target="#chiTiet<%=sachBL.getMaSach()%>"><i class="fas fa-info-circle"></i></a><a  class="btn btn-danger"  onclick="xoaTraLoiBL('+result[i].maBinhLuan+ ')" ><i class="fas fa-trash-alt"></i></a>';

                      
                    }
                    
                }

            }
        });
       
    }
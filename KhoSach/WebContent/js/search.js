$(document).ready(
		function() {
			$('#search').keyup(
					function() {
						var name = $("#search").val();
						if($('#search').val().length != 0){
						$.ajax({
							type : "GET",
							url : "TimKiemServlet", //Tên servlet
							data : "search=" + name, //Gán giá trị vào name mục đich để servlet nhận được Parameter
							dataType : "json",
							async : true,
							cache : false,
							success : function(result) {
								var listSize = Object.keys(result).length;
								if (result.check == "fail") {
									$('.liSearch').remove();
									$('.labelSearch').remove();
									$('#resutlSearch').append("<label class='labelSearch' ><a>Không tìm thấy...</a></label>");
									return;
								}
								//Nếu list tồn tại thì reset thông điệp cảnh báo về rỗng và loop dữ liệu hiển thị ra table
								if (listSize > 0) {
									$('.liSearch').remove();
									$('.labelSearch').remove();
									//Khai báo table kiểu global để sử dụng ngoài fuction này
									var size = 8;
									if (listSize < 8) {
										size = listSize;
									}
									for (i = 0; i < size; i++) {
										$('#resutlSearch').append(
												" <li class='liSearch' > <a href='DanhSachSachTimKiemServlet?search="+result[i]+"'> " + result[i]
														+ "</a>   </li>"
										)
									}
									$('#resutlSearch').append("<label class='labelSearch' ><a>xem thêm...</a></label>");
								}

							}
						
						});
						}else{
							$('.liSearch').remove();
							$('.labelSearch').remove();
						}
				});
			
					
		});
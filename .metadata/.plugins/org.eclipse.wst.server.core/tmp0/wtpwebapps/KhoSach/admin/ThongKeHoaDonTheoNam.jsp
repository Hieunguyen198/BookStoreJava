<%@page import="java.util.Calendar"%>
<%@page import="model.bean.ThongKeTheoNamBEAN"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<%@ include file="Nav.jsp"%>
<div class="container">
	<%
		ThongKeTheoNamBEAN thongKe = (ThongKeTheoNamBEAN) request.getAttribute("thongKe");
	%>
	<h2 id="titleThongKe"
		style="padding-bottom: 37px; font-size: 23px; text-align: center; padding-top: 16px;">
		THỐNG KÊ SỐ LƯỢNG HÓA ĐƠN THEO TUẦN THÁNG TRONG
		<%=thongKe.getNam()%>
		NĂM
	</h2>
	<div class="card shadow mb-4">
		<div class="card-body">
			<div class="form-group">
				<%
			Calendar calendar = Calendar.getInstance();
			int namhienTai = calendar.get(Calendar.YEAR);
	      
			
			%>
				<select class="text form-control" id="namThongKe"
					style="width: 100px; margin-left: auto;">
					<%for(int i =namhienTai; i>=2015; i--) {
					%>
					<option value="<%=i%>"><%=i%></option>
					<%} %>

				</select>
			</div>
			<table class="table table-bordered">
				<thead>
					<tr class="tr_tableThongKe">
						<th >Tháng 1</th>
						<th>Tháng 2</th>
						<th>Tháng 3</th>
						<th>Tháng 4</th>
						<th>Tháng 5</th>
						<th>Tháng 6</th>
						<th>Tháng 7</th>
						<th>Tháng 8</th>
						<th>Tháng 9</th>
						<th>Tháng 10</th>
						<th>Tháng 11</th>
						<th>Tháng 12</th>

					</tr>
				</thead>
				<tbody >

					<tr id="tableThongKe">
						<td><%=thongKe.getThang1()%></td>
						<td><%=thongKe.getThang2()%></td>
						<td><%=thongKe.getThang3()%></td>
						<td><%=thongKe.getThang4()%></td>
						<td><%=thongKe.getThang5()%></td>
						<td><%=thongKe.getThang6()%></td>
						<td><%=thongKe.getThang7()%></td>
						<td><%=thongKe.getThang8()%></td>
						<td><%=thongKe.getThang9()%></td>
						<td><%=thongKe.getThang10()%></td>
						<td><%=thongKe.getThang11()%></td>
						<td><%=thongKe.getThang12()%></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="Footer.jsp"%>
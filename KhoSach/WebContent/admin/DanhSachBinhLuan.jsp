<%@page import="model.bean.SachBinhLuanBEAN"%>
<%@page import="model.bean.ChiTietHoaDonBEAN"%>
<%@page import="model.bean.HoaDonBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<%@ include file="Nav.jsp"%>
<div class="container">
	<div class="row shadow">
		<div class="col-sm-12">
			<div class="px-2">
				<h4 class="title mt-4 mb-5 text-center text-uppercase text-danger">Danh Sách Binh Luận</h4>
				<div class="container-fluid">
	 <div class="card shadow mb-4">
		<div class="card-body">
			<div class="table-responsive table-hover">
				<table class="table table-bordered" id="dataTable" width="100%"	cellspacing="0">
					<thead>
						<tr>
							<th>Mã sách</th>
							<th>Tên sách</th>
							<th>Số lượng bình luận</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<SachBinhLuanBEAN> listSachBL = (ArrayList<SachBinhLuanBEAN>)request.getAttribute("listSachBL");
					for(SachBinhLuanBEAN sachBL: listSachBL){ %>
						
						<tr id="trXoaBinhLuan<%=sachBL.getMaSach()%>" >
							<td><%=sachBL.getMaSach() %></td>
							<td><%=sachBL.getTenSach() %></td>
							<td><%=sachBL.getSoLuongBinhLuan() %></td>
							<td style="text-align: center;">
								<div class="d-flex justify-content-center align-items-center">
									<a style="margin-right: 3px;"  class="btn btn-info" onclick="ChiTietBL(<%=sachBL.getMaSach() %>)" data-toggle="modal" data-target="#chiTiet<%=sachBL.getMaSach()%>"><i class="fas fa-info-circle"></i></a>
									<a  class="btn btn-danger"  onclick="xoaSachBL(<%=sachBL.getMaSach() %>)" ><i class="fas fa-trash-alt"></i></a>
								</div>
							</td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%for(SachBinhLuanBEAN sachBL: listSachBL){ %>
		<div class="modal fade" id="chiTiet<%=sachBL.getMaSach() %>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				    <div class="modal-dialog modal-lg">
				        <div class="modal-content" style="width: 1000px">
				            <div class="modal-header">
				            	<h4 class="modal-title" id="myModalLabel">Bình luận</h4>
				                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
				                </button>                 
				            </div>
				            <div class="modal-body">
				                <table class="table table-bordered">
				                    <thead>
				                        <tr>
				                            <th>Mã bình luận</th>
				                            <th>Mã khách hàng</th>
				                            <th>Tên đăng nhập</th>
				                            <th>Nội dung bình luận</th>
				                            <th>Dánh giá</th>
				                            <th>Thời gian</th>
				                            <th></th>
				                        </tr>
				                    </thead>
				                    <tbody id="trBinhLuan<%=sachBL.getMaSach()%>">
				                    </tbody>
				                </table>
				               
				            </div>
				            <div class="modal-footer">
				                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				            </div>
				        </div>
				    </div>
				</div><%} %>
	</div>
			</div>
		</div>
	</div>
</div>

	<%@ include file="Footer.jsp"%>
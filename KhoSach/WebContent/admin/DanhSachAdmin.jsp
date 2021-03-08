<%@page import="model.bean.AdminBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<%@ include file="Nav.jsp"%>
<%String tenDangNhap=""; %>
<div class="container">
	<div class="row shadow">
	
		<div class="col-sm-12">
		<h2 style="text-align: right;">
		<a class="text-white btn btn-success mr-3"
			href="ThemAdminSevlet">Thêm admin</a>
	</h2>
			<div class="px-2">
				<h4 class="title mt-4 mb-5 text-center text-uppercase text-danger">Danh Sách Admin</h4>
				
			</div>
			<div class="container-fluid">
	 <div class="card shadow mb-4">
		<div class="card-body">
		
			<div class="table-responsive table-hover">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Tên Đăng Nhập</th>
							<th>Mật khẩu</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<% ArrayList<AdminBEAN> listAdmin = (ArrayList<AdminBEAN>)request.getAttribute("listAdmin");
					for(AdminBEAN admin: listAdmin){
						tenDangNhap = admin.getTenDangNhap();
					%>
						<tr>
							<td><%=admin.getTenDangNhap() %></td>
							<td><%=admin.getMatKhau() %></td>
							<td style="text-align: center;">
								<div class="d-flex justify-content-center align-items-center">
									<a href="SuaAdminServlet?masua=<%=admin.getTenDangNhap() %>" class="btn btn-success mr-3"><i class="fa fa-edit" ></i></a> 
									<a onclick="return confirm('Xóa sẽ không thể khôi phục lại ?');" name="btnXoa" href="XoaAdminServlet?maxoa=<%=admin.getTenDangNhap() %>"
										class="btn btn-danger"><i class="fas fa-trash-alt"></i></a>
								</div>
							</td>
						</tr>
						<%} %>
						<?php } ?>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				    <div class="modal-dialog">
				        <div class="modal-content">
				            <div class="modal-header">
				            	<h4 class="modal-title" id="myModalLabel">Đổi mật khẩu</h4>
				                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>                 
				            </div>
				            <div class="modal-body">
				               <input type="text">
				            </div>
				            <div class="modal-footer">
				                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				            </div>
				        </div>
				    </div>
	</div>
	</div>
		</div>
	</div>
</div>

	<%@ include file="Footer.jsp"%>
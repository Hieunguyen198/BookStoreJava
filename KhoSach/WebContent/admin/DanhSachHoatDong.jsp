<%@page import="model.bean.AdminBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>
<div class="container">
	<div class="row shadow">
		<div class="col-sm-12">
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
					<td></td>
					<td></td>
					<td></td>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	</div>
		</div>
	</div>
</div>
	<%@ include file="Footer.jsp"%>
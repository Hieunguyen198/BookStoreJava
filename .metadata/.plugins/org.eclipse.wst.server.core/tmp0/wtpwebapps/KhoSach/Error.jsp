<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="Header.jsp"%>

<div class="container">
	<div class="span16 main-content-grid">
		<div class="ty-exception">
			<div class="ty-exception__code">
				404 <span class="ty-exception__code-txt">LỖI</span>
			</div>
			<div class="ty-exception__title-info">
				<h1 class="ty-exception__title">
					Rất tiếc! <br> Chúng tôi không thể tìm thấy những gì bạn đang
					tìm kiếm.
				</h1>
				<p class="ty-exception__info">Không tìm thấy trang bạn yêu cầu.
				</p>

				<p class="ty-exception__info">Mã lỗi: Không tìm thấy trang</p>
				<ul class="ty-exception__links">
					<li class="ty-exception__links-item"><a
						class="ty-exception__links-a" style="color: #ff5800"
						href="/KhoSach">Đi đến trang chủ</a></li>
					<li class="ty-exception__links-item" id="go_back"><a
						class="ty-exception__links-a cm-back-link">Quay lại</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<%@ include file="Footer.jsp"%>
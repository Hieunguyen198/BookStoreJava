<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="container mt-3">
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class=" top-my-account ty-float-right">
					<div id="account_info_154" class="popup popup_user hidden active">
						<button style="background: #ff5a01" class="btnClose" type="button"
							data-dismiss="modal">
							<i style="font-size: 25px; color: #fff;" class="fa fa-times"></i>
						</button>
						<div class="popup__content">
							<div class="popup__img active" id="login1" data-value="login">
								<h3 class="title-login">Đăng nhập</h3>
								<div class="desc-login">
									Chào mừng bạn quay lại.<br>Đăng nhập để theo dõi đơn hàng,
									đánh dấu sản phẩm yêu thích, cập nhật thông tin, và nhận nhiều
									ưu đãi hấp dẫn từ Kho Sach.
								</div>
							</div>
							<div class="popup__img" id="resigter1" data-value="register">
								<h3 class="title-login">Tạo tài khoản</h3>
								<div class="desc-login">
									Chào mừng bạn đến tới Kho Sach.<br>Tạo tài khoản để trở
									thành thành viên, theo dõi đơn hàng, cập nhật thông tin, và
									nhận nhiều ưu đãi từ Kho Sach.
								</div>
							</div>
							<div class="popup__body">

								<div class="popup__header nav nav-tabs">
									<a href="#login" role="tab" id="btn_login"
										class="nav-link active button" aria-selected="true"
										data-toggle="tab">Đăng nhập</a> <a style="width: 177px; height: 44px;" href="#resigter" role="tab"
										id="btn_resigter" aria-selected="false"
										class="nav-link button" data-toggle="tab">Tạo tài khoản</a>
								</div>
								<div class="tab__content">
									<div class="popup__body__inner show active" role="tabpanel"
										id="login">
										<form name="popup_login_form" 
											method="post" class="cm-processed-form">
											<input type="hidden" name="return_url" value="index.php">
											<input type="hidden" name="redirect_url" value="index.php">
											<div class="popup__form">
												<div class="form">
													<label style="width: 95px" for="user_loginmain_login"
														class="cm-required">Email/SĐT</label> <input id="userName"
														style="width: 408px" value="" id="user_loginmain_login"
														name="userName" type="text"
														placeholder="Nhập số điện thoại or Email"
														autocomplete="off">
												</div>
												<div class="form">
													<label style="width: 95px" for="ppsw_main_login"
														class="cm-required">Mật khẩu</label> <input id="password"
														style="width: 408px" id="ppsw_main_login" name="password"
														type="password" placeholder="Nhập mật khẩu đăng nhập"
														maxlength="32" autocomplete="off">
												</div>
												<p class="text-danger" style="margin-left:97px" id="result"></p>
											</div>
											<div class="button-left">
												<div class="popup__forgot">
													<div class="popup__checkbox">
														<input name="remember_me" type="checkbox" id="remember"
															value="Y"> <label for="remember">Ghi nhớ
															đăng nhập</label>
													</div>
													<p class="forgot">
														Bạn quên mật khẩu đăng nhập? Nhấn vào <a
															href="https://nhanvan.vn/quen-mat-khau.html">đây</a>.
													</p>
												</div>

												<button id="subDangNhap" class="button btn-orrange" type="submit"
													name="dispatch[auth.login]">Đăng nhập</button>
											</div>
										</form>
									</div>
									<div class="popup__body__inner" role="tabpanel" id="resigter">
										<form name="profiles_register_form" method="POST"
											class="cm-processed-form">
											<div class="popup__form">
												<div class="form">
													
													<label for="full_name" class="cm-required">Họ tên</label> <input
														id="full_name" name="hoten" type="text"
														value="" placeholder="Họ và tên*" required>
														<p class="text-danger" style="margin-left: 150px" id="resultempty"></p>
												</div>
												<div class="form">
													<label for="full_name" class="cm-required">Tên Đăng Nhập</label> <input
														id="user_name" name="tendn" type="text"
														value="" placeholder="Tên đăng nhập*" required>
														<p class="text-danger" style="margin-left: 150px" id="resultusername"></p>
												</div>
												<div class="form">
													<label for="pphone" class="cm-required cm-phone">SĐT</label>
													<input id="pphone" name="sdt" type="text"
														placeholder="Số điện thoại*" required>
														<p class="text-danger" style="margin-left: 150px" id="resultphone"></p>
												</div>
												<div class="form">
													<label for="pemail" class="cm-email cm-required hidden">E-mail</label>
													<input id="pemail" value="" name="email"
														type="text" placeholder="Email của bạn" required>
														<p class="text-danger" style="margin-left: 150px" id="resultemail"></p>
												</div>
												<div class="form">
													<label for="ppassword1" class="cm-required cm-password">Mật
														khẩu</label> <input type="password" id="ppassword1"
														placeholder="Mật khẩu*" name="matkhau1"
														maxlength="32" autocomplete="off"
														class="cm-autocomplete-off" value="" required>
														<p class="text-danger" style="margin-left: 150px" id="resultMK1"></p>
												</div>
												<div class="form">
													<label for="ppassword2" class="cm-required cm-password">Xác
														nhận mật khẩu</label> <input type="password" id="ppassword2"
														placeholder="Mật khẩu*" name="matkhau2"
														maxlength="32" autocomplete="off"
														class="cm-autocomplete-off" value="" required>
														<p class="text-danger" style="margin-left: 150px" id="resultMK2"></p>
												</div>
												<div class="form">
													<label for="gioitinh" class="cm-required">Giới tính</label>
													<div class="popup__checkbox popup__checkbox--inline">
														<input type="radio" name="radioGroup" value="male"
															id="male" required> <label for="male">Nam</label> <input
															type="radio" name="radioGroup" value="female"
															id="female" required> <label for="female">Nữ</label>
													</div>
												</div>
												<div class="form">
													<label for="ngaysinh">Ngày sinh</label> <input value=""
														name="ngaysinh" type="date" id="ngaySinh"
														placeholder="Ngày sinh của bạn" required>
												</div>
												<div class="button-left">
													<div class="popup__checkbox popup__checkbox--italic">



														<input type="checkbox" id="italic"> <label
															for="italic">Nhận thông báo và các khuyến mãi từ
															Kho Sach qua mail</label>
													</div>
													<div class="popup__register">

														<button class="button btn-orrange" type="submit" id="subDangKy">Đăng
															Ký</button>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
						<!--account_info_154-->
					</div>
					<!-- Inline script moved to the bottom of the page -->
					<div class="mask active"></div>

				</div>
			</div>

		</div>
	</div>
</div>

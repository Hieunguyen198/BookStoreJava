package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Validate;
import model.bean.KhachHangBEAN;
import model.bo.GioHangBO;
import model.bo.KhachHangBO;

/*
 * @author Hieu
 * @date  2020-04-27
 * @version 1.0
 */

@WebServlet("/DangKyServlet")
public class DangKyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DangKyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	KhachHangBO khb = new KhachHangBO();
	GioHangBO ghBo = new GioHangBO();
	Validate vl = new Validate();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tenKhachHang = request.getParameter("hoten");
		String tenDangNhap = request.getParameter("tendn");
		String soDienThoai = request.getParameter("sdt");
		String email = request.getParameter("email");
		String matKhau1 = request.getParameter("matkhau1");
		String matKhau2 = request.getParameter("matkhau2");
		String gioiTinh = request.getParameter("gt");
		String ngaySinh = request.getParameter("ngaysinh");
		PrintWriter out = response.getWriter();
		if (gioiTinh.equals("male")) {// chuyển giới tính sang boolean
			gioiTinh = "true";
		} else {
			gioiTinh = "false";
		}
		ArrayList<KhachHangBEAN> ds = khb.getKhachHangs();
		if (!vl.checkSDT(soDienThoai)) {// kiểm tra định dạng sdt
			String text = "2";
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF8");
			out.print(text);
			return;
		}
		if (!vl.checkEmail(email)) {//kiểm tra định dạng email
			String text = "1";
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF8");
			out.print(text);
			return;
		}
		for (KhachHangBEAN kh : ds) {
			if (kh.getTenDangNhap().equalsIgnoreCase(tenDangNhap)) {// kiểm tra tên đăng nhập
				String text = "3";
				response.setContentType("text/plain");
				response.setCharacterEncoding("UTF8");
				out.print(text);
				return;
			}
			if (kh.getEmail().equalsIgnoreCase(email)) {// kiểm tra email tồn tại chưa
				String text = "4";
				response.setContentType("text/plain");
				response.setCharacterEncoding("UTF8");
				out.print(text);
				return;
			}
			if (kh.getSoDienThoai().equals(soDienThoai)) {//kiểm tra số điện thoại tồn tại chưa
				String text = "5";
				response.setContentType("text/plain");
				response.setCharacterEncoding("UTF8");
				out.print(text);
				return;
			}
		}
		if(!matKhau1.equals(matKhau2)) {
			String text = "6";
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF8");
			out.print(text);
			return;
		}else {
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF8");
			String text = "Thanh cong";
			khb.themKhachHang(tenKhachHang, email, soDienThoai, "", java.sql.Date.valueOf(ngaySinh),
					Boolean.parseBoolean(gioiTinh), matKhau1, tenDangNhap);
			out.print(text);
			out.flush();
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

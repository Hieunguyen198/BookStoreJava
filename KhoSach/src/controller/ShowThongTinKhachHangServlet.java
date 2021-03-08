package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.GioHangBEAN;
import model.bean.KhachHangBEAN;
import model.bean.LichSuMuaHangBEAN;
import model.bo.DanhMucBO;
import model.bo.GioHangBO;
import model.bo.KhachHangBO;
import model.bo.LichSuMuaHangBO;
import model.bo.NhomTheLoaiBO;
import model.bo.TheLoaiBO;

/*
 * @author Hieu
 * @date  2020-04-27
 * @version 1.0
 */

@WebServlet("/ShowThongTinKhachHangServlet")
public class ShowThongTinKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowThongTinKhachHangServlet() {
		super();
	}

	NhomTheLoaiBO nhomTheLoaiBo = new NhomTheLoaiBO();
	DanhMucBO danhMucBo = new DanhMucBO();
	TheLoaiBO theLoaiBo = new TheLoaiBO();
	GioHangBO ghBo = new GioHangBO();
	LichSuMuaHangBO lsb = new LichSuMuaHangBO();
	KhachHangBO khachHang = new KhachHangBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		session.setAttribute("page", "TrangChuServlet");
		if(session.getAttribute("ThanhCong")!=null) {
			request.setAttribute("ThongBao","1");
			session.setAttribute("ThanhCong", null);
		}
		int maKhachHang = (int) session.getAttribute("maKhachHang");// Lấy mã khách hàng từ session
		request.setAttribute("dslsmhdd", lsb.getLSMHDD(maKhachHang));// Lấy lịch sử mua hàng đã duyệt theo mã khách hàng
		request.setAttribute("dslsmhcd", lsb.getLSMHCD(maKhachHang)); // Lấy lịch sử mua hàng chưa duyệt theo mã khách hàng
		request.setAttribute("dsct", lsb.getChiTietDonHang(maKhachHang)); // Lấy danh sách chi tiết
		request.setAttribute("listDanhMuc", danhMucBo.getDanhSachDanhMuc());// Lấy danh mục
		request.setAttribute("listNhomTheLoai", nhomTheLoaiBo.getDanhSachNhomTheLoai()); // Lấy danh mục theo nhóm thể loại
		request.setAttribute("listTheLoai", theLoaiBo.getDanhSachTheLoai());// Lấy danh sách thể loại
		request.setAttribute("khachHang", khachHang.getKhachHang(maKhachHang));//lấy thông tin của khách hàng
		RequestDispatcher rd = request.getRequestDispatcher("ThongTinCaNhan.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

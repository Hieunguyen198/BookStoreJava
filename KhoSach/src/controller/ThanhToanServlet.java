package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Validate;
import model.bean.GioHangBEAN;
import model.bean.KhachHangBEAN;
import model.bo.ChiTietHoaDonBO;
import model.bo.GioHangBO;
import model.bo.HoaDonBO;
import model.bo.KhachHangBO;

/**
 * Servlet implementation class ThanhToanServlet
 */
@WebServlet("/ThanhToanServlet")
public class ThanhToanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThanhToanServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	ChiTietHoaDonBO cthdBO = new ChiTietHoaDonBO();
	HoaDonBO hdBO = new HoaDonBO();
	GioHangBO ghBO = new GioHangBO();
	KhachHangBO khBO = new KhachHangBO();
	Validate vl = new Validate();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			ArrayList<GioHangBEAN> gh = (ArrayList<GioHangBEAN>) session.getAttribute("gio");
			int maKH = 0;
			String tenKhachHang = "";
			String soDienThoai = "";
			String diaChi = "";
			String email = "";
			String phuongThucThanhToan = "";
			maKH = (int) session.getAttribute("maKhachHang");
			tenKhachHang = request.getParameter("tenKhachHang");
			soDienThoai = request.getParameter("soDienThoai");
			diaChi = request.getParameter("diaChi");
			email = request.getParameter("email");
			phuongThucThanhToan = request.getParameter("phuongThucThanhToan");
			int phuongThuc = 0;
			phuongThuc = Integer.parseInt(phuongThucThanhToan);
			if (Validate.checkName(tenKhachHang) && new Validate().checkEmail(email)
					&& Validate.checkNumberPhone(soDienThoai) && Validate.checkDiaChi(diaChi)) {
				hdBO.getHoaDon();
				hdBO.them(maKH, 0, new Date(), phuongThuc);//
				int maHD = hdBO.demMaHD();
				cthdBO.themall(gh, maHD);
				session.setAttribute("gio", ghBO.getGioHangs(0));
				ghBO.XoaTatCaDB(maKH);
				KhachHangBEAN kh = khBO.getKhachHang(maKH);
				khBO.thayDoiThongTin(maKH, tenKhachHang, email, soDienThoai, diaChi, kh.getNgaySinh(), kh.isGioiTinh());
				session.setAttribute("KhachHang", khBO.getKhachHang(maKH));
			} else {
				response.sendRedirect("DatHangServlet");
			}
			session.setAttribute("ThanhCong", "1");
			response.sendRedirect("ShowThongTinKhachHangServlet");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

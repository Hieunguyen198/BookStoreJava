package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.GioHangBEAN;
import model.bo.DanhMucBO;
import model.bo.GioHangBO;
import model.bo.NhomTheLoaiBO;
import model.bo.TheLoaiBO;

/**
 * Servlet implementation class CapNhatSoLuongGioHangServlet
 */
@WebServlet("/CapNhatSoLuongGioHangServlet")
public class CapNhatSoLuongGioHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CapNhatSoLuongGioHangServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	GioHangBO ghBO = new GioHangBO();
	NhomTheLoaiBO nhomTheLoaiBo = new NhomTheLoaiBO();
	DanhMucBO danhMucBo = new DanhMucBO();
	TheLoaiBO theLoaiBo = new TheLoaiBO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String mS = request.getParameter("mS");
			int maSach = Integer.parseInt(mS);
			String sL = null;
			int soLuong = 0;
			if (request.getParameter("sL") != null) {
				sL = request.getParameter("sL");
				soLuong = Integer.parseInt(sL);
			}
			HttpSession session = request.getSession();
			String sLEnter = null;
			ghBO.ds = (ArrayList<GioHangBEAN>) session.getAttribute("gio");
			ghBO.capNhatSoLuong(maSach, soLuong);
			if (request.getParameter("sLEnter") != null) {
				sLEnter = request.getParameter("sLEnter");
				int sLE = Integer.parseInt(sLEnter);
				ghBO.capNhapGioHangEnter(maSach, sLE);
			}

			session.setAttribute("gio", ghBO.ds);
			if (session.getAttribute("maKhachHang") != null) {
				int maKhachHang = (int) session.getAttribute("maKhachHang");
				ghBO.getGioHangs(maKhachHang);
				ghBO.capNhapGioHang(maKhachHang, maSach, soLuong);
				if (request.getParameter("sLEnter") != null) {
					sLEnter = request.getParameter("sLEnter");
					int sLE = Integer.parseInt(sLEnter);
					ghBO.capNhapGioHangEnterDB(maKhachHang, maSach, sLE);
				}
			}
			request.setAttribute("listDanhMuc", danhMucBo.getDanhSachDanhMuc());
			request.setAttribute("listNhomTheLoai", nhomTheLoaiBo.getDanhSachNhomTheLoai());
			request.setAttribute("listTheLoai", theLoaiBo.getDanhSachTheLoai());
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF8");
			PrintWriter out = response.getWriter();
			out.print(mS + sL);
			out.flush();
		} catch (Exception e) {
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

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

import org.apache.tomcat.util.http.fileupload.FileItem;

import model.bean.GioHangBEAN;
import model.bo.DanhMucBO;
import model.bo.GioHangBO;
import model.bo.NhomTheLoaiBO;
import model.bo.TheLoaiBO;

/**
 * Servlet implementation class ThemSachGioHangServlet
 */
@WebServlet("/ThemSachGioHangServlet")
public class ThemSachGioHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemSachGioHangServlet() {
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
			HttpSession session = request.getSession();
			String mS = request.getParameter("mS");
			int maSach = Integer.parseInt(mS);
			String sL = request.getParameter("sL");
			int soLuong = Integer.parseInt(sL);
			String sLM = request.getParameter("sLM");
			int soLuongMax = Integer.parseInt(sLM);
			String tenSach = request.getParameter("tS");
			String anh = request.getParameter("anh");
			String g = request.getParameter("gia");
			long gia = Integer.parseInt(g);
			ghBO.ds = (ArrayList<GioHangBEAN>) session.getAttribute("gio");
			if(soLuong>soLuongMax) {
				soLuong = soLuongMax;
			}
			ghBO.themGioHang(maSach, tenSach, anh, soLuong, soLuongMax, gia);
			session.setAttribute("gio", ghBO.ds);
			if (session.getAttribute("maKhachHang") != null) {
				int maKhachHang = (int) session.getAttribute("maKhachHang");
				ghBO.getGioHangs(maKhachHang);
				ghBO.themGioHangDB(maKhachHang, maSach, soLuong, gia);
			}
			request.setAttribute("listDanhMuc", danhMucBo.getDanhSachDanhMuc());
			request.setAttribute("listNhomTheLoai", nhomTheLoaiBo.getDanhSachNhomTheLoai());
			request.setAttribute("listTheLoai", theLoaiBo.getDanhSachTheLoai());
			response.sendRedirect("Giohang");
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

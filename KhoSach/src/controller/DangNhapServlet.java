package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.GioHangBEAN;
import model.bo.DanhMucBO;
import model.bo.GioHangBO;
import model.bo.KhachHangBO;
import model.bo.NhomTheLoaiBO;
import model.bo.TheLoaiBO;

/**
 * Servlet implementation class DangNhapServlet
 */
@WebServlet("/DangNhapServlet")
public class DangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangNhapServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	KhachHangBO khBO = new KhachHangBO();
	GioHangBO ghBO = new GioHangBO();
	NhomTheLoaiBO nhomTheLoaiBo = new NhomTheLoaiBO();
	DanhMucBO danhMucBo = new DanhMucBO();
	TheLoaiBO theLoaiBo = new TheLoaiBO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			khBO.getKhachHangs();
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			request.setAttribute("listDanhMuc", danhMucBo.getDanhSachDanhMuc());
			request.setAttribute("listNhomTheLoai", nhomTheLoaiBo.getDanhSachNhomTheLoai());
			request.setAttribute("listTheLoai", theLoaiBo.getDanhSachTheLoai());
			HttpSession session = request.getSession();
			String userName = null;
			String password = null;
			String page = (String) session.getAttribute("page");
			String k="0";
			if (request.getParameter("userName") != null) {
				userName = request.getParameter("userName");
				password = request.getParameter("password");
				if (khBO.kiemTraDangNhap(userName, password) == true) {
					k=page;
					session.setAttribute("maKhachHang", khBO.getMaKhachHang(userName));
					ghBO.ds = ghBO.getGioHangs(khBO.getMaKhachHang(userName));
					ArrayList<GioHangBEAN> gh = (ArrayList<GioHangBEAN>) session.getAttribute("gio");
					ghBO.themallDB(gh, khBO.getMaKhachHang(userName));
					session.setAttribute("gio", ghBO.getGioHangs(khBO.getMaKhachHang(userName)));
					session.setAttribute("KhachHang", khBO.getKhachHang(khBO.getMaKhachHang(userName)));
				}
			}
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF8");
			PrintWriter out = response.getWriter();
			out.print(k);
			out.flush();

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

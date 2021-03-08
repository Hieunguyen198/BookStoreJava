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

import model.bean.DanhMucBEAN;
import model.bean.GioHangBEAN;
import model.bean.SachBEAN;
import model.bo.DanhMucBO;
import model.bo.GioHangBO;
import model.bo.NhomTheLoaiBO;
import model.bo.SachBO;
import model.bo.TheLoaiBO;
import model.bo.TimKiemBO;

/**
 * Servlet implementation class DanhSachSachTimKiemServlet
 */
@WebServlet("/DanhSachSachTimKiemServlet")
public class DanhSachSachTimKiemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachSachTimKiemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	SachBO sachBo = new SachBO();
	NhomTheLoaiBO nhomTheLoaiBo = new NhomTheLoaiBO();
	DanhMucBO danhMucBo = new DanhMucBO();
	TheLoaiBO theLoaiBo = new TheLoaiBO();
	GioHangBO ghBo = new GioHangBO();
	TimKiemBO timKiemBo = new TimKiemBO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int maKH = 0;
		if (session.getAttribute("maKhachHang") != null) {
			maKH = (int) session.getAttribute("maKhachHang");
			session.setAttribute("gio", ghBo.getGioHangs(maKH));
		} else {
			if (session.getAttribute("gio") != null) {
				ArrayList<GioHangBEAN> gh = (ArrayList<GioHangBEAN>) session.getAttribute("gio");
				session.setAttribute("gio", gh);
			} else {
				session.setAttribute("gio", ghBo.getGioHangs(0));
			}
		}
		String tuKhoa = (String) request.getParameter("search");
		if (tuKhoa != null) {
			String page = "DanhSachSachTimKiemServlet?search=" + tuKhoa;
			session.setAttribute("page", page);

		}
		request.setAttribute("listDanhMuc", danhMucBo.getDanhSachDanhMuc());
		request.setAttribute("listNhomTheLoai", nhomTheLoaiBo.getDanhSachNhomTheLoai());
		request.setAttribute("listTheLoai", theLoaiBo.getDanhSachTheLoai());
		try {
			if (tuKhoa != null || tuKhoa != "") {
				ArrayList<SachBEAN> listSach = timKiemBo.getListSachTimKiem(tuKhoa);
				if (listSach.size() == 1) {
					response.sendRedirect("ChiTietSanPhamServlet?maSach=" + listSach.get(0).getMaSach());
				} else {
					if (listSach == null || listSach.size() == 0) {
						RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
						rd.forward(request, response);
					} else {
						request.setAttribute("listSach", listSach);
						request.setAttribute("listTacGia", timKiemBo.getTacGiaTimKiem(tuKhoa));
						request.setAttribute("listNhaXuatBan", timKiemBo.getNhaXuatBanTimKiem(tuKhoa));
						request.setAttribute("tenDanhSach", tuKhoa);
						RequestDispatcher rd = request.getRequestDispatcher("DanhSachTheoDanhMuc.jsp");
						rd.forward(request, response);
					}
				}
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("DanhSachTheoDanhMuc.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);

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

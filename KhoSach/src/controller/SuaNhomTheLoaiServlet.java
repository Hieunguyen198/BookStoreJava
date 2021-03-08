package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.DMUL;

import model.bo.DanhMucBO;
import model.bo.NhomTheLoaiBO;

/**
 * Servlet implementation class SuaNhomTheLoaiServlet
 */
@WebServlet("/SuaNhomTheLoaiServlet")
public class SuaNhomTheLoaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaNhomTheLoaiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	NhomTheLoaiBO nhomTheLoaiBo = new NhomTheLoaiBO();
	DanhMucBO danhMucBo = new DanhMucBO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession admin = request.getSession();
		if(admin.getAttribute("txtTenDangNhap")==null){
			response.sendRedirect("DangNhapAdminSevlet");
			return;
		}
		if (request.getParameter("maNTLSua") != null) {
			int maNhomTheLoai = Integer.parseInt(request.getParameter("maNTLSua"));

			request.setAttribute("nhomTheLoai", nhomTheLoaiBo.getNhomTheLoai(maNhomTheLoai));
			request.setAttribute("dsMaDanhMuc", danhMucBo.getDanhSachDanhMuc());
			request.setAttribute("list", nhomTheLoaiBo.getDanhSachNhomTheLoai());

			RequestDispatcher rd = request.getRequestDispatcher("admin/SuaNhomTheLoai.jsp");
			rd.forward(request, response);

		} else if (request.getParameter("btnSua") != null) {
			int maNhomTheLoai = 0;
			if (request.getParameter("txtMaNhomTheLoai") != null) {
				maNhomTheLoai = Integer.parseInt(request.getParameter("txtMaNhomTheLoai"));
			}
			String tenNhomTheLoai = request.getParameter("txtNhomTenTheLoai");
			int maDanhMuc = 0;
			if (request.getParameter("txtMaDanhMuc") != null) {
				maDanhMuc = Integer.parseInt(request.getParameter("txtMaDanhMuc"));
			}
			int n = nhomTheLoaiBo.capNhap(maNhomTheLoai, tenNhomTheLoai, maDanhMuc);
			request.setAttribute("kiemtrasua", n);
			//response.sendRedirect("NhomTheLoaiServlet");
			request.setAttribute("list", nhomTheLoaiBo.getDanhSachNhomTheLoai());
			RequestDispatcher rd = request.getRequestDispatcher("admin/NhomTheLoai.jsp");
			rd.forward(request, response);

		}

		else {
			request.setAttribute("list", nhomTheLoaiBo.getDanhSachNhomTheLoai());
			RequestDispatcher rd = request.getRequestDispatcher("admin/NhomTheLoai.jsp");
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

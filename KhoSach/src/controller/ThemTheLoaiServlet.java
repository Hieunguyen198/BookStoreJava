package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.NhomTheLoaiBO;
import model.bo.TheLoaiBO;

/**
 * Servlet implementation class themTheLoaiServlet
 */
@WebServlet("/ThemTheLoaiServlet")
public class ThemTheLoaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemTheLoaiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	TheLoaiBO bo = new TheLoaiBO();
	NhomTheLoaiBO nhomTheLoaiBo = new NhomTheLoaiBO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession admin = request.getSession();
		if(admin.getAttribute("txtTenDangNhap")==null){
			response.sendRedirect("DangNhapAdminSevlet");
			return;
		}
		try {
			String tenTheLoai = request.getParameter("txtTenTheLoai");
			
			int maNhomTheLoai = 0;
			if (request.getParameter("txtMaNhomTheLoai") != null) {
				maNhomTheLoai = Integer.parseInt(request.getParameter("txtMaNhomTheLoai"));
			}

			if (request.getParameter("btnThem") != null) {
				int n = bo.them(tenTheLoai, maNhomTheLoai);
				request.setAttribute("kiemtrathem", n);

			}

			request.setAttribute("dsNhomTheLoai", nhomTheLoaiBo.getDanhSachNhomTheLoai());
			request.setAttribute("list", bo.getDanhSachTheLoai());
			RequestDispatcher rd = request.getRequestDispatcher("admin/ThemTheLoai.jsp");
			rd.forward(request, response);
		} catch (Exception tt) {
			tt.printStackTrace();
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

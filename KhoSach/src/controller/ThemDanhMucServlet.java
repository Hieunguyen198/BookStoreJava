package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.DanhMucBO;

/**
 * Servlet implementation class themDanhMucServelet
 */
@WebServlet("/ThemDanhMucServlet")
public class ThemDanhMucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	DanhMucBO bo = new DanhMucBO();

	public ThemDanhMucServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession admin = request.getSession();
		if(admin.getAttribute("txtTenDangNhap")==null){
			response.sendRedirect("DangNhapAdminSevlet");
			return;
		}
		String tenDanhMuc = request.getParameter("txtTenDanhMuc");

		if (request.getParameter("btnThem") != null) {
			int n = bo.them(tenDanhMuc);
			request.setAttribute("kiemtrathem", n);
		}
		
		request.setAttribute("list", bo.getDanhSachDanhMuc());
		RequestDispatcher rd = request.getRequestDispatcher("admin/ThemDanhMuc.jsp");
		rd.forward(request, response);

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

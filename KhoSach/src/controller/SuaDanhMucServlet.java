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
 * Servlet implementation class SuaDanhMucServlet
 */
@WebServlet("/SuaDanhMucServlet")
public class SuaDanhMucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaDanhMucServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    DanhMucBO bo = new DanhMucBO(); 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession admin = request.getSession();
		if(admin.getAttribute("txtTenDangNhap")==null){
			response.sendRedirect("DangNhapAdminSevlet");
			return;
		}
		if (request.getParameter("maDMSua") != null) {
			int maDanhMuc = Integer.parseInt(request.getParameter("maDMSua"));
			request.setAttribute("danhMuc", bo.getDanhMuc(maDanhMuc));
			RequestDispatcher rd = request.getRequestDispatcher("admin/SuaDanhMuc.jsp");
			rd.forward(request, response);
		} 
			else if (request.getParameter("btnSua") != null) {
			int maDanhMuc = 0;
			if(request.getParameter("txtMaDanhMuc") != null){
				maDanhMuc = Integer.parseInt(request.getParameter("txtMaDanhMuc"));
			}
			String tenDanhMuc = request.getParameter("txtTenDanhMuc");
			
			int n = bo.capNhap(maDanhMuc, tenDanhMuc);
			
			request.setAttribute("kiemtrasua", n);
			request.setAttribute("list", bo.getDanhSachDanhMuc());
			RequestDispatcher rd = request.getRequestDispatcher("admin/DanhMuc.jsp");
			rd.forward(request, response);

		}

		else {
			request.setAttribute("list", bo.getDanhSachDanhMuc());
			RequestDispatcher rd = request.getRequestDispatcher("admin/DanhMuc.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

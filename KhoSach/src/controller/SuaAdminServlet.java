package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.AdminBO;

/**
 * Servlet implementation class SuaAdminServlet
 */
@WebServlet("/SuaAdminServlet")
public class SuaAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    AdminBO adminBO = new AdminBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("masua")!=null) {
			request.setAttribute("admin", adminBO.TimAdmin(request.getParameter("masua")));
			
			RequestDispatcher rd= request.getRequestDispatcher("admin/SuaAdmin.jsp");
			rd.forward(request, response);
		}
		String tenDangNhap = request.getParameter("txtTenDangNhap");
		String matKhau = request.getParameter("txtMatKhau");
		int n = adminBO.Sua(tenDangNhap, matKhau);
		response.sendRedirect("DanhSachAdminSevlet");
	 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

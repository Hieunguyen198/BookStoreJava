package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.AdminBO;

/**
 * Servlet implementation class ThemAdminSevlet
 */
@WebServlet("/ThemAdminSevlet")
public class ThemAdminSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemAdminSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession admin = request.getSession();
		if(admin.getAttribute("txtTenDangNhap")==null){
			response.sendRedirect("DangNhapAdminSevlet");
			return;
		}
		AdminBO adminBO = new AdminBO();
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");

			if(request.getParameter("btnTao")!=null) {
				  String tenDangNhap = request.getParameter("txtTenDangNhap"); 
				  String matKhau =  request.getParameter("txtMatKhau"); 
				  int n = adminBO.Them(tenDangNhap, matKhau);
				  request.setAttribute("kiemtrathem", n);
			}
			request.setAttribute("dsAdmin", adminBO.getAdmin());
			RequestDispatcher rd = request.getRequestDispatcher("admin/ThemAdmin.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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

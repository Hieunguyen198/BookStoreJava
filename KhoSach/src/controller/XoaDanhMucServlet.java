package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.DanhMucBO;

/**
 * Servlet implementation class XoaDanhMucServlet
 */
@WebServlet("/XoaDanhMucServlet")
public class XoaDanhMucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaDanhMucServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    DanhMucBO bo = new DanhMucBO(); 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getParameter("maDMXoa") != null) {
			int n = bo.xoa((request.getParameter("maDMXoa")));
			request.setAttribute("kiemtraxoa", n);
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

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.TheLoaiBO;

/**
 * Servlet implementation class xoaTheLoaiServlet
 */
@WebServlet("/XoaTheLoaiServlet")
public class XoaTheLoaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaTheLoaiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    TheLoaiBO bo = new TheLoaiBO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("maTLXoa") != null) {
			String maTheLoai = request.getParameter("maTLXoa");
			int n = bo.xoa(maTheLoai);
			request.setAttribute("kiemtraxoa", n);
		}
		request.setAttribute("list", bo.getDanhSachTheLoai());
		RequestDispatcher rd  = request.getRequestDispatcher("admin/TheLoai.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

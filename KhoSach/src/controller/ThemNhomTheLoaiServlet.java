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
import model.bo.NhomTheLoaiBO;

/**
 * Servlet implementation class ThemNhomTheLoaiServlet
 */
@WebServlet("/ThemNhomTheLoaiServlet")
public class ThemNhomTheLoaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemNhomTheLoaiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    DanhMucBO danhMucBo = new DanhMucBO();
    NhomTheLoaiBO nhomTheLoaiBo = new NhomTheLoaiBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession admin = request.getSession();
		if(admin.getAttribute("txtTenDangNhap")==null){
			response.sendRedirect("DangNhapAdminSevlet");
			return;
		}
		try {
			String tenNhomTheLoai = request.getParameter("txtTenNhomTheLoai");
			
			int maDanhMuc = 0;
			if (request.getParameter("txtMaDanhMuc") != null) {
				maDanhMuc = Integer.parseInt(request.getParameter("txtMaDanhMuc"));
			}

			if (request.getParameter("btnThem") != null) {
				int n = nhomTheLoaiBo.them(tenNhomTheLoai, maDanhMuc);
				request.setAttribute("kiemtrathem", n);

			}

			request.setAttribute("dsMaDanhMuc", danhMucBo.getDanhSachDanhMuc());
			request.setAttribute("list", nhomTheLoaiBo.getDanhSachNhomTheLoai());
			RequestDispatcher rd = request.getRequestDispatcher("admin/ThemNhomTheLoai.jsp");
			rd.forward(request, response);
		} catch (Exception tt) {
			tt.printStackTrace();
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

package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.GioHangBEAN;
import model.bo.DanhMucBO;
import model.bo.GioHangBO;
import model.bo.KhachHangBO;
import model.bo.NhomTheLoaiBO;
import model.bo.TheLoaiBO;

/**
 * Servlet implementation class CapNhatThongTinServlet
 */
@WebServlet("/CapNhatThongTinServlet")
public class CapNhatThongTinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapNhatThongTinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    KhachHangBO khb = new KhachHangBO();
    GioHangBO ghBo = new GioHangBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        session.setAttribute("page", "GioHangServlet");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int maKhachHang= Integer.parseInt(request.getParameter("maKhachHang"));
		String tenKhachHang=request.getParameter("tenKhachHang");
		/*String tenDangNhap=request.getParameter("tenDangNhap");*/
		String soDienThoai=request.getParameter("soDienThoai");
		String email=request.getParameter("email");
		String gioiTinh=request.getParameter("gioiTinh");
		String ngaySinh=request.getParameter("ngaySinh");
		String diaChi=request.getParameter("diaChi");
		String page = (String) session.getAttribute("page");
		khb.thayDoiThongTin(maKhachHang, tenKhachHang, email, soDienThoai, diaChi, java.sql.Date.valueOf(ngaySinh),Boolean.parseBoolean(gioiTinh));
		response.sendRedirect("ShowThongTinKhachHangServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

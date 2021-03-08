package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.KhachHangBEAN;
import model.bo.BinhLuanBO;

/**
 * Servlet implementation class ThemBinhLuanServlet
 */
@WebServlet("/ThemBinhLuanServlet")
public class ThemBinhLuanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemBinhLuanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    BinhLuanBO binhLuanBo = new BinhLuanBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
		int maSach = Integer.parseInt(request.getParameter("maSach"));
		int danhGia = Integer.parseInt(request.getParameter("danhGia"));
		String noiDungBinhLuan = request.getParameter("noiDungBinhLuan");
		Date ngayGioHienTai = new Date();
		java.sql.Timestamp thoiGian = new java.sql.Timestamp(ngayGioHienTai.getTime());
		PrintWriter out = response.getWriter();
		binhLuanBo.them(noiDungBinhLuan, maKhachHang, maSach, danhGia, thoiGian);
		out.print("Thanh Cong");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

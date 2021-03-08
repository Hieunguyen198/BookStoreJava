package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.bean.KhachHangBEAN;
import model.bo.DanhMucBO;
import model.bo.KhachHangBO;
import model.bo.NhomTheLoaiBO;
import model.bo.TheLoaiBO;

/*
 * @author Hieu
 * @date  2020-04-27
 * @version 1.0
 */

@WebServlet("/ThayDoiMatKhauServlet")
public class ThayDoiMatKhauServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ThayDoiMatKhauServlet() {
		super();
	}
	 NhomTheLoaiBO nhomTheLoaiBo = new NhomTheLoaiBO();
	    DanhMucBO danhMucBo = new DanhMucBO();
	    TheLoaiBO theLoaiBo = new TheLoaiBO();
	    KhachHangBO khb = new KhachHangBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mkc = request.getParameter("matKhauCu");
		String mkm = request.getParameter("matKhauMoi");
		String mkxn = request.getParameter("matKhauXacNhan");
		HttpSession session = request.getSession();
		int maKhachHang = (int) session.getAttribute("maKhachHang");
		KhachHangBEAN kh = khb.getKhachHang(maKhachHang);
		PrintWriter out = response.getWriter();
		if(mkc.equals(kh.getMatKhau())) { // kiểm tra mật khẩu cũ 
				if(!mkm.equals(mkxn)) {// kiểm tra mật khẩu mới và mật khẩu xác nhận
					String text ="0";
					response.setContentType("text/plain");  
		            response.setCharacterEncoding("UTF8");
		            out.print(text);
		           
				}else{
					response.setContentType("text/plain"); 
		            response.setCharacterEncoding("UTF8");
					String text ="2";
					khb.thayDoiMatKhau(mkm, maKhachHang);
		            out.print(text);
		            out.flush();
				}
		}else {
			String text ="1";
			response.setContentType("text/plain");  
            response.setCharacterEncoding("UTF8");
            out.print(text);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doGet(request, response);
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.GioHangBEAN;
import model.bo.GioHangBO;

/**
 * Servlet implementation class XoaSachTrongGioServlet
 */
@WebServlet("/XoaSachTrongGioServlet")
public class XoaSachTrongGioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XoaSachTrongGioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	GioHangBO ghBO = new GioHangBO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			if (request.getParameter("k") != null) {
				ghBO.XoaTatCa();
				if (session.getAttribute("maKhachHang") != null) {
					int maKhachHang = (int) session.getAttribute("maKhachHang");
					ghBO.XoaTatCaDB(maKhachHang);
				}
			} else {
				String mS = request.getParameter("mS");
				int maSach = Integer.parseInt(mS);
				ghBO.ds = (ArrayList<GioHangBEAN>) session.getAttribute("gio");
				ghBO.Xoa(maSach);
				if (session.getAttribute("maKhachHang") != null) {
					int maKhachHang = (int) session.getAttribute("maKhachHang");
					ghBO.XoaHangGioDB(maKhachHang, maSach);
				}

			}
			session.setAttribute("gio", ghBO.ds);
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF8");
			PrintWriter out = response.getWriter();
			int size = ghBO.ds.size();
			out.print(size);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
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

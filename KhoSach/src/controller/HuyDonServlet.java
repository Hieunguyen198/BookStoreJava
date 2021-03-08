package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.LichSuMuaHangBO;

/**
 * Servlet implementation class HuyDonServlet
 */
@WebServlet("/HuyDonServlet")
public class HuyDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HuyDonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maHoaDon = request.getParameter("maHoaDon");
		LichSuMuaHangBO lsb= new LichSuMuaHangBO();
		lsb.huyDonHang(Integer.parseInt(maHoaDon));
		PrintWriter out = response.getWriter();
		String text = "1";
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF8");
		out.print(text);
		System.out.println(text);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.bean.ThongKeTheoNamBEAN;
import model.bo.ThongKeBO;

/**
 * Servlet implementation class ThongKeTheoNamServlet
 */
@WebServlet("/ThongKeTheoNamServlet")
public class ThongKeTheoNamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThongKeTheoNamServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	ThongKeBO thongKebo = new ThongKeBO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession admin = request.getSession();
		if (admin.getAttribute("txtTenDangNhap") == null) {
			response.sendRedirect("DangNhapAdminSevlet");
			return;
		} else {
			if (request.getParameter("nam") != null) {
				int nam = Integer.parseInt(request.getParameter("nam"));
				ThongKeTheoNamBEAN listThongKe = thongKebo.getDachSachThangTrongNam(nam);
				PrintWriter out = response.getWriter();
				Gson gson = new Gson();
				String objectToReturn = gson.toJson(listThongKe); // Convert List -> Json
				out.write(objectToReturn); // Đưa Json trả về Ajax
				out.flush();
			} else {
				Calendar calendar = Calendar.getInstance();
				int nam = calendar.get(Calendar.YEAR);
				request.setAttribute("thongKe", thongKebo.getDachSachThangTrongNam(nam));
				RequestDispatcher rd = request.getRequestDispatcher("admin/ThongKeHoaDonTheoNam.jsp");
				rd.forward(request, response);
			}

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

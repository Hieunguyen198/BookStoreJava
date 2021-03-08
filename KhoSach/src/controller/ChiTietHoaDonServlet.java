package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.bean.ChiTietHoaDonBEAN;
import model.bo.ChiTietHoaDonBO;

/**
 * Servlet implementation class ChiTietHoaDonServlet
 */
@WebServlet("/ChiTietHoaDonServlet")
public class ChiTietHoaDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietHoaDonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    ChiTietHoaDonBO cthdBO = new ChiTietHoaDonBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
	    String maHoaDonCT = request.getParameter("maHoaDonCT");
	    ArrayList<ChiTietHoaDonBEAN> listChiTiet = cthdBO.getChiTietHoaDon(maHoaDonCT);
	    Gson gson = new Gson();
        String objectToReturn = gson.toJson(listChiTiet); //Convert List -> Json
//        System.out.println(maHoaDonCT);
//        System.out.println(objectToReturn);
        PrintWriter out = response.getWriter();
        out.write(objectToReturn); //Đưa Json trả về Ajax
        out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

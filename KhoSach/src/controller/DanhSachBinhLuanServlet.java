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

import model.bean.BinhLuanBEAN;
import model.bean.ChiTietHoaDonBEAN;
import model.bo.BinhLuanBO;

/**
 * Servlet implementation class DanhSachBinhLuanServlet
 */
@WebServlet("/DanhSachBinhLuanServlet")
public class DanhSachBinhLuanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachBinhLuanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    BinhLuanBO binhLuanBo = new BinhLuanBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setCharacterEncoding("UTF-8");
	        response.setContentType("application/json");
		    int maSach = Integer.parseInt(request.getParameter("maSach"));
		    ArrayList<BinhLuanBEAN> listBinhLuan = binhLuanBo.getListBinhLuan(maSach);
		    Gson gson = new Gson();
	        String objectToReturn = gson.toJson(listBinhLuan); //Convert List -> Json=
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

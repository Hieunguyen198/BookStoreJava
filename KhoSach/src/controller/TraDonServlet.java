package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ChiTietHoaDonBEAN;
import model.bean.SachBEAN;
import model.bo.ChiTietHoaDonBO;
import model.bo.HoaDonBO;
import model.bo.SachBO;

/**
 * Servlet implementation class TraDonServlet
 */
@WebServlet("/TraDonServlet")
public class TraDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraDonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    SachBO sachBO = new SachBO();
    ChiTietHoaDonBO cthdBO = new ChiTietHoaDonBO();
    HoaDonBO hoaDonBO = new HoaDonBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        String maHoaDonCT = request.getParameter("maHoaDon");
        ArrayList<ChiTietHoaDonBEAN> listChiTiet = cthdBO.getChiTietHoaDon(maHoaDonCT);
        for(ChiTietHoaDonBEAN chiTiet:listChiTiet) {
                 SachBEAN sach = sachBO.getSach(chiTiet.getMaSach());
            	 if(sach.getSoLuong()==0) {
                     sachBO.capNhatTrangThai(sach.getMaSach(), true);
                 } 
                int soLuongMoi = sach.getSoLuong() + chiTiet.getSoLuong();
                sachBO.capNhatSL(chiTiet.getMaSach(), soLuongMoi);
                hoaDonBO.capNhatTrangThai(chiTiet.getMaHoaDon(), 2);
                out.print("0");
            
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

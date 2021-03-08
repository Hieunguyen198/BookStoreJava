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

import com.google.gson.Gson;

import model.bean.ChiTietHoaDonBEAN;
import model.bean.HoaDonBEAN;
import model.bo.ChiTietHoaDonBO;
import model.bo.HoaDonBO;

/**
 * Servlet implementation class DanhSachHoaDonSevlet
 */
@WebServlet("/DanhSachHoaDonSevlet")
public class DanhSachHoaDonSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachHoaDonSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    HoaDonBO hoaDonBO = new HoaDonBO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession admin = request.getSession();
        if(admin.getAttribute("txtTenDangNhap")==null){
            response.sendRedirect("DangNhapAdminSevlet");
            return;
        }
        
        String maHoaDon = request.getParameter("maHoaDon");
        String maXoa = request.getParameter("maXoa");
        String maDuyet = request.getParameter("maDuyet");
        try {
            ArrayList<HoaDonBEAN> listHoaDon = hoaDonBO.getHoaDon();
            

            if(maHoaDon != null) {
                request.setAttribute("listHoaDon", hoaDonBO.getHoaDon(maHoaDon));
            }else
                request.setAttribute("listHoaDon", listHoaDon);
            
            if(maXoa!=null) {
                int n = hoaDonBO.Xoa(maXoa);
            }
          
            if(maDuyet!=null) {
                int n = hoaDonBO.Duyet(maDuyet);
            }
            
            request.setAttribute("listHoaDon", listHoaDon);
            
            RequestDispatcher rd = request.getRequestDispatcher("admin/DanhSachHoaDon.jsp");
            rd.forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
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

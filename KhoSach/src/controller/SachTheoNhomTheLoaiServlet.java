package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.GioHangBEAN;
import model.bean.NhomTheLoaiBEAN;
import model.bean.SachBEAN;
import model.bean.TheLoaiBEAN;
import model.bo.DanhMucBO;
import model.bo.GioHangBO;
import model.bo.NhomTheLoaiBO;
import model.bo.SachBO;
import model.bo.TheLoaiBO;

/**
 * Servlet implementation class SachTheoNhomTheLoaiServlet
 */
@WebServlet("/SachTheoNhomTheLoaiServlet")
public class SachTheoNhomTheLoaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SachTheoNhomTheLoaiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    SachBO sachBo = new SachBO();
   	NhomTheLoaiBO nhomTheLoaiBo = new NhomTheLoaiBO();
   	DanhMucBO danhMucBo = new DanhMucBO();
   	TheLoaiBO theLoaiBo = new TheLoaiBO();
    GioHangBO ghBo = new GioHangBO();
   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        int maKH = 0;
        if (session.getAttribute("maKhachHang") != null) {
            maKH = (int) session.getAttribute("maKhachHang");
            session.setAttribute("gio", ghBo.getGioHangs(maKH));
        } else {
            if (session.getAttribute("gio") != null) {
                ArrayList<GioHangBEAN> gh = (ArrayList<GioHangBEAN>) session.getAttribute("gio");
                session.setAttribute("gio", gh);
            } else {
                session.setAttribute("gio", ghBo.getGioHangs(0));
            }
        }
		if(request.getParameter("maNhomTheLoai")!=null) {
			int maNhomTheLoai = Integer.parseInt(request.getParameter("maNhomTheLoai")) ;
			String page = "SachTheoNhomTheLoaiServlet?maNhomTheLoai="+maNhomTheLoai;
			session.setAttribute("page", page);
			
		}
		int maNhomTheLoai = 0;
		request.setAttribute("listDanhMuc", danhMucBo.getDanhSachDanhMuc());
		request.setAttribute("listNhomTheLoai", nhomTheLoaiBo.getDanhSachNhomTheLoai());
        request.setAttribute("listTheLoai", theLoaiBo.getDanhSachTheLoai());
		try{
			if(request.getParameter("maNhomTheLoai")!= null || request.getParameter("maNhomTheLoai")!=""){
				
				maNhomTheLoai = Integer.parseInt(request.getParameter("maNhomTheLoai"));
				ArrayList<SachBEAN> listSach = sachBo.getSachTheoNhomTheLoai(maNhomTheLoai);
				
				if(listSach == null || listSach.size() == 0){
					RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				
				request.setAttribute("listSach", sachBo.getSachTheoNhomTheLoai(maNhomTheLoai));
			
				NhomTheLoaiBEAN nhomTheLoai = nhomTheLoaiBo.getNhomTheLoai(maNhomTheLoai);
				
				request.setAttribute("listTacGia", sachBo.getTacGiaNhomTheLoai(maNhomTheLoai));
				request.setAttribute("listNhaXuatBan", sachBo.getNhaXuatBanNhomTheLoai(maNhomTheLoai));
				request.setAttribute("tenDanhSach", nhomTheLoai.getTenNhomTheLoai());
		        
				RequestDispatcher rd = request.getRequestDispatcher("DanhSachTheoDanhMuc.jsp");
				rd.forward(request, response);
			}
			
			else{
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e){
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
			
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

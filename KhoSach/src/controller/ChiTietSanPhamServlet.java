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
import model.bo.BinhLuanBO;
import model.bo.DanhMucBO;
import model.bo.GioHangBO;
import model.bo.NhomTheLoaiBO;
import model.bo.SachBO;
import model.bo.TheLoaiBO;

/**
 * Servlet implementation class ChiTietSanPhamServlet
 */
@WebServlet("/ChiTietSanPhamServlet")
public class ChiTietSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietSanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    NhomTheLoaiBO nhomTheLoaiBo = new NhomTheLoaiBO();
    DanhMucBO danhMucBo = new DanhMucBO();
    TheLoaiBO theLoaiBo = new TheLoaiBO();
    SachBO sachBo = new SachBO();
    GioHangBO ghBo = new GioHangBO();
    BinhLuanBO binhLuanBo = new BinhLuanBO();
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
        int maSach =Integer.parseInt(request.getParameter("maSach"));
        String page = "SachTheoTheLoaiServlet?maSach=?"+maSach;
      	session.setAttribute("page", page);
		request.setAttribute("listDanhMuc", danhMucBo.getDanhSachDanhMuc());
        request.setAttribute("listNhomTheLoai", nhomTheLoaiBo.getDanhSachNhomTheLoai());
        request.setAttribute("listTheLoai", theLoaiBo.getDanhSachTheLoai());
        request.setAttribute("sach",sachBo.getSach(maSach));
        request.setAttribute("listBL", binhLuanBo.getListBinhLuan(maSach));
        RequestDispatcher rd = request.getRequestDispatcher("ChiTietSanPham.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

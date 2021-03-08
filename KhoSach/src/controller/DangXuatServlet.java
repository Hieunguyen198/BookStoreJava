package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.DanhMucBO;
import model.bo.GioHangBO;
import model.bo.KhachHangBO;
import model.bo.NhomTheLoaiBO;
import model.bo.TheLoaiBO;

/**
 * Servlet implementation class DangXuatServlet
 */
@WebServlet("/DangXuatServlet")
public class DangXuatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangXuatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    GioHangBO ghBO = new GioHangBO();
    KhachHangBO khBO = new KhachHangBO();
    NhomTheLoaiBO nhomTheLoaiBo = new NhomTheLoaiBO();
    DanhMucBO danhMucBo = new DanhMucBO();
    TheLoaiBO theLoaiBo = new TheLoaiBO();
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            HttpSession session = request.getSession();
            String page = (String) session.getAttribute("page");
            session.setAttribute("maKhachHang", null);
            session.setAttribute("KhachHang", null);
            session.setAttribute("gio", ghBO.getGioHangs(0));
            request.setAttribute("listDanhMuc", danhMucBo.getDanhSachDanhMuc());
            request.setAttribute("listNhomTheLoai", nhomTheLoaiBo.getDanhSachNhomTheLoai());
            request.setAttribute("listTheLoai", theLoaiBo.getDanhSachTheLoai());
            response.sendRedirect(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

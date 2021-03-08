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
import model.bo.DanhMucBO;
import model.bo.GioHangBO;
import model.bo.NhomTheLoaiBO;
import model.bo.TheLoaiBO;

/**
 * Servlet implementation class GioHangServlet
 */
@WebServlet("/GioHangServlet")
public class GioHangServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    GioHangBO ghBo = new GioHangBO();
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
            session.setAttribute("page", "GioHangServlet");
            int maKH = 0;
            if (session.getAttribute("maKhachHang") != null) {
                maKH = (int) session.getAttribute("maKhachHang");
                session.setAttribute("gio", ghBo.getGioHangs(maKH));
            } else {
                if (session.getAttribute("gio") != null) {
                    ArrayList<GioHangBEAN> gh = (ArrayList<GioHangBEAN>) session
                            .getAttribute("gio");
                    session.setAttribute("gio", gh);
                } else {
                    session.setAttribute("gio", ghBo.getGioHangs(0));
                }
            }
            
            request.setAttribute("listDanhMuc", danhMucBo.getDanhSachDanhMuc());
            request.setAttribute("listNhomTheLoai", nhomTheLoaiBo.getDanhSachNhomTheLoai());
            request.setAttribute("listTheLoai", theLoaiBo.getDanhSachTheLoai());
            RequestDispatcher rd = request.getRequestDispatcher("GioHang.jsp");
            rd.forward(request, response);
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

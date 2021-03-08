package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhomTheLoaiBEAN;
import model.bo.NhomTheLoaiBO;

/**
 * Servlet implementation class XoaNhomTheLoaiServlet
 */
@WebServlet("/XoaNhomTheLoaiServlet")
public class XoaNhomTheLoaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	NhomTheLoaiBO nhomTheLoaiBo = new NhomTheLoaiBO();
	
    public XoaNhomTheLoaiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("maNTLXoa")!=null){
			
			int n= nhomTheLoaiBo.xoa(request.getParameter("maNTLXoa"));
			request.setAttribute("kiemtraxoa", n);
		}
		request.setAttribute("list", nhomTheLoaiBo.getDanhSachNhomTheLoai());
		RequestDispatcher rd = request.getRequestDispatcher("NhomTheLoaiServlet");
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

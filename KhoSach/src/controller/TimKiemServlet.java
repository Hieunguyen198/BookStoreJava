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

import model.bo.TimKiemBO;

/**
 * Servlet implementation class TimKiemServlet
 */
@WebServlet("/TimKiemServlet")
public class TimKiemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimKiemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    TimKiemBO timKiem = new TimKiemBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String tuKhoa = request.getParameter("search");
        ArrayList<String> list = timKiem.getTimKiem(tuKhoa);
        if (!list.isEmpty()) {
            PrintWriter out = response.getWriter();
            response.setCharacterEncoding("UTF8");
            response.setContentType("application/json");
            //Import gson-2.2.2.jar
            Gson gson = new Gson();
            String objectToReturn = gson.toJson(list); //Convert List -> Json
            out.write(objectToReturn); //Đưa Json trả về Ajax
            out.flush();

        } else {
            PrintWriter out = response.getWriter();
            response.setCharacterEncoding("UTF8");
            response.setContentType("application/json");
            out.write("{\"check\":\"fail\"}");
            out.flush();
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

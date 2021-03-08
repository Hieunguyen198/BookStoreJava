package controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.bo.SachBO;

/**
 * Servlet implementation class XuLyThemSach
 */
@WebServlet("/XuLySuaSachServlet")
public class XuLySuaSachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XuLySuaSachServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	SachBO sachBo = new SachBO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		upload.setHeaderEncoding("UTF-8");
		String dirUrl1 = "C:\\Users\\VTA\\eclipse-workspace\\KhoSach\\WebContent\\image";

		try {
			String nameimg = "";
			int maSach = 0;
			String tenSach = "";
			int maTheLoai = 0;
			String tacGia = "";
			long gia = 0;
			long giaKhuyenMai = 0;
			int namXuatBan = 0;
			String nhaXuatBan = "";
			int soLuong = 0;
			boolean trangThai = true;
			String moTa = "";
			Date ngayNhap = null;
			String enc = "utf-8";
			enc = request.getCharacterEncoding();
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = "C:\\Users\\VTA\\eclipse-workspace\\KhoSach\\WebContent\\image";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// tạo file
						try {
							if (file != null) {
								fileItem.write(file);// lưu file
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					
					String tentk = fileItem.getFieldName();
					if (tentk.equals("maSach")) {
						maSach = Integer.parseInt(fileItem.getString());
					} else if (tentk.equals("tenSach")) {
						tenSach = fileItem.getString(enc);
					} else if (tentk.equals("maTheLoai")) {
						maTheLoai = Integer.parseInt(fileItem.getString());
					} else if (tentk.equals("tacGia")) {
						tacGia = fileItem.getString(enc);
					} else if (tentk.equals("gia")) {
						gia = Long.parseLong(fileItem.getString());
					} else if (tentk.equals("giaKhuyenMai")) {
						giaKhuyenMai = Long.parseLong(fileItem.getString());
					} else if (tentk.equals("namXuatBan")) {
						namXuatBan = Integer.parseInt(fileItem.getString());
					} else if (tentk.equals("nhaXuatBan")) {
						nhaXuatBan = fileItem.getString(enc);
					} else if (tentk.equals("soLuong")) {
						soLuong = Integer.parseInt(fileItem.getString());
					} else if (tentk.equals("moTa")) {
						moTa = fileItem.getString(enc);
					} else if (tentk.equals("trangThai")) {
						if (fileItem.getString().equals("false"))
							trangThai = false;
					} else if (tentk.equals("ngayNhap")) {
						SimpleDateFormat day = new SimpleDateFormat("yyyy/MM/dd");
						try {
							ngayNhap = day.parse(fileItem.getString());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} else if (tentk.equals("diaChiAnh")) {
						if(nameimg=="")
							nameimg = fileItem.getString();
					}

				}

			}
			// response.getWriter().println(maSach+" ten sach "+ tenSach+" hinh anh "+ nameimg+" ngay nhap "+ngayNhap+" trang thai "+trangThai);
			sachBo.capNhap(maSach, tenSach, soLuong, gia, giaKhuyenMai, tacGia, namXuatBan, nhaXuatBan, nameimg,
					maTheLoai, ngayNhap, trangThai, moTa);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		request.setAttribute("CapNhatThanhCong", 1);
		RequestDispatcher rd = request.getRequestDispatcher("SachServlet");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

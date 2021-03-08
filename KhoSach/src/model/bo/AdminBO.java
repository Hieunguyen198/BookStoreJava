package model.bo;

import java.util.ArrayList;
import model.bean.AdminBEAN;
import model.dao.AdminDAO;


public class AdminBO {
	AdminDAO s= new AdminDAO();
	public ArrayList<AdminBEAN> getAdmin(){
		return s.getAdmin();
	}
	public int Them(String tenDangNhap, String matKhau) {
		return s.them(tenDangNhap, matKhau);
	}
	public int Sua(String tenDangNhap, String matKhau){
		return s.capNhat(tenDangNhap, matKhau);
	}
	public int Xoa(String tenDangNhap)  {
		return s.xoa(tenDangNhap);
	}
	public AdminBEAN TimAdmin(String tenDangNhap) {
		return s.getAdmin(tenDangNhap);
	}
	public boolean Ktra(String tenDangNhap){
		return s.kTra(tenDangNhap);
	}
//	public boolean DangNhap(String tenDangNhap,String matKhau) throws Exception {
//		return s.DangNhap(tenDangNhap, matKhau);
//	}
	public boolean checkLogin(String tenDangNhap, String matKhau) {
		return s.checkLogin(tenDangNhap, matKhau);
	}
}

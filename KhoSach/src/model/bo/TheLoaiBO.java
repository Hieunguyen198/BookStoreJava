package model.bo;

import java.util.ArrayList;

import model.bean.TheLoaiBEAN;
import model.dao.TheLoaiDAO;

public class TheLoaiBO {
	TheLoaiDAO dao = new TheLoaiDAO();
	
	public ArrayList<TheLoaiBEAN> getDanhSachTheLoai() {
		return dao.getDanhSachTheLoai();
		
	}
	
	public int them(String tenTheLoai, int maNhomTheLoai) {
		return dao.them(tenTheLoai, maNhomTheLoai);
	}
	
	public int xoa(String maTheLoai) {
		return dao.xoa(maTheLoai);
	}
	
	public int capNhap(int maTheLoai, String tenNhomTheLoai, int maNhomTheLoai) {
		return dao.capNhap(maTheLoai, tenNhomTheLoai, maNhomTheLoai);
	}
	
	public TheLoaiBEAN getTheLoai(int maTheLoai) {
		return dao.getTheLoai(maTheLoai);
	}

}

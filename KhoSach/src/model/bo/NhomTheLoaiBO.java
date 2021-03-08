package model.bo;

import java.util.ArrayList;

import model.bean.NhomTheLoaiBEAN;
import model.dao.NhomTheLoaiDAO;

public class NhomTheLoaiBO {

	NhomTheLoaiDAO dao = new NhomTheLoaiDAO();

	public ArrayList<NhomTheLoaiBEAN> getDanhSachNhomTheLoai() {
		return dao.getDanhSachNhomTheLoai();

	}

	public int them(String tenNhomTheLoai, int maDanhMuc) {
		return dao.them(tenNhomTheLoai, maDanhMuc);
	}

	public int xoa(String maNhomTheLoai) {
		return dao.xoa(maNhomTheLoai);
	}

	public int capNhap(int maNhomTheLoai, String tenNhomTheLoai, int maDanhMuc) {
		return dao.capNhap(maNhomTheLoai, tenNhomTheLoai, maDanhMuc);
	}

	public NhomTheLoaiBEAN getNhomTheLoai(int maNhomTheLoai) {
		return dao.getNhomTheLoai(maNhomTheLoai);
	}

}

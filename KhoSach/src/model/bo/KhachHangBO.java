package model.bo;

import java.util.ArrayList;
import java.util.Date;

import model.bean.KhachHangBEAN;
import model.dao.KhachHangDAO;

public class KhachHangBO {
	KhachHangDAO khd = new KhachHangDAO();

	public void xoaKhachHang(int maKH) {
		khd.xoaKhachHang(maKH);
	}

	public void themKhachHang(String tenKhachHang, String email, String soDienThoai, String diaChi, Date ngaySinh,
			boolean gioiTinh, String matKhau, String tenDangNhap) {
		khd.themKhachHang(tenKhachHang, email, soDienThoai, diaChi, ngaySinh, gioiTinh, matKhau, tenDangNhap);
	}

	public void thayDoiMatKhau(String matKhauMoi, int maKhachHang) {
		khd.thayDoiMatKhau(matKhauMoi, maKhachHang);
	}

	public void thayDoiThongTin(int maKhachHang, String tenKhachHang, String email, String soDienThoai, String diaChi,
			Date ngaySinh, boolean gioiTinh) {
		khd.thayDoiThongTin(maKhachHang, tenKhachHang, email, soDienThoai, diaChi, ngaySinh, gioiTinh);
	}

	public ArrayList<KhachHangBEAN> ds;

	public ArrayList<KhachHangBEAN> getKhachHangs() {
		ds = khd.layTTKH();
		return ds;
	}

	public boolean kiemTraDangNhap(String userName, String password) {
		for (KhachHangBEAN kh : ds) {
			if (kh.getTenDangNhap().equals(userName) && kh.getMatKhau().equals(password))
				return true;
		}
		return false;
	}

	public int getMaKhachHang(String userName) {
		for (KhachHangBEAN kh : ds) {
			if (kh.getTenDangNhap().equals(userName)) {
				return kh.getMaKhachHang();
			}
		}
		return 0;
	}

	public KhachHangBEAN getKhachHang(int maKhachHang) {
		return khd.getKhachHang(maKhachHang);
	}

	public boolean kTraMatKhau(String matKhau, int maKhachHang) {
		return khd.kTraMatKhau(matKhau, maKhachHang);
	}

}

/*
 * @author VTA
 * @date Apr 27, 2020
 * @version 1.0
 */

package model.bo;

import java.sql.Timestamp;
import java.util.ArrayList;

import model.bean.BinhLuanBEAN;
import model.bean.SachBinhLuanBEAN;
import model.dao.BinhLuanDAO;

public class BinhLuanBO {
	BinhLuanDAO binhLuanDao = new BinhLuanDAO();
	public int them(String noiDungBinhLuan, int maKhachHang, int maSach, int danhGia, Timestamp thoiGian) {
		return binhLuanDao.them(noiDungBinhLuan, maKhachHang, maSach, danhGia, thoiGian);
	}
	public int capNhap(int maBinhLuan, String noiDungBinhLuan, int maKhachHang, int maSach, int danhGia,
			Timestamp thoiGian) {
		return binhLuanDao.capNhap(maBinhLuan, noiDungBinhLuan, maKhachHang, maSach, danhGia, thoiGian);
	}
	public BinhLuanBEAN getBinhLuan(int maBinhLuan) {
		return binhLuanDao.getBinhLuan(maBinhLuan);
	}
	public ArrayList<BinhLuanBEAN> getListBinhLuan(int maSach) {
		return binhLuanDao.getListBinhLuan(maSach);
	}
	public int xoa(String maBinhLuan) {
		return binhLuanDao.xoa(maBinhLuan);
	}
	public ArrayList<SachBinhLuanBEAN> getListSachBinhLuan() {
		return binhLuanDao.getListSachBinhLuan();
	}
}

/*
 * @author VTA
 * @date Apr 27, 2020
 * @version 1.0
 */

package model.bean;

import java.sql.Timestamp;

public class BinhLuanBEAN {
	private int maBinhLuan;
	private String noiDungBinhLuan;
	private int maKhachHang;
	private int maSach;
	private int danhGia;
	private Timestamp thoiGian;
	private String tenKhachHang;
	
	public BinhLuanBEAN(int maBinhLuan, String noiDungBinhLuan, int maKhachHang, int maSach, int danhGia,
			Timestamp thoiGian, String tenKhachHang) {
		super();
		this.maBinhLuan = maBinhLuan;
		this.noiDungBinhLuan = noiDungBinhLuan;
		this.maKhachHang = maKhachHang;
		this.maSach = maSach;
		this.danhGia = danhGia;
		this.thoiGian = thoiGian;
		this.tenKhachHang = tenKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public int getDanhGia() {
		return danhGia;
	}

	public void setDanhGia(int danhGia) {
		this.danhGia = danhGia;
	}

	public Timestamp getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Timestamp thoiGian) {
		this.thoiGian = thoiGian;
	}

	public int getMaBinhLuan() {
		return maBinhLuan;
	}

	public void setMaBinhLuan(int maBinhLuan) {
		this.maBinhLuan = maBinhLuan;
	}

	public String getNoiDungBinhLuan() {
		return noiDungBinhLuan;
	}

	public void setNoiDungBinhLuan(String noiDungBinhLuan) {
		this.noiDungBinhLuan = noiDungBinhLuan;
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public int getMaSach() {
		return maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}
}

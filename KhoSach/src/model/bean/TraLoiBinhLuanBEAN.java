/*
 * @author VTA
 * @date Apr 27, 2020
 * @version 1.0
 */

package model.bean;

import java.sql.Timestamp;

public class TraLoiBinhLuanBEAN {
	private int maTraLoiBinhLuan;
	private String noiDung;
	private int maKhachHang;
	private int maBinhLuan;
	private Timestamp thoiGian;

	public TraLoiBinhLuanBEAN(int maTraLoiBinhLuan, String noiDung, int maKhachHang, int maBinhLuan, Timestamp thoiGian) {
		super();
		this.maTraLoiBinhLuan = maTraLoiBinhLuan;
		this.noiDung = noiDung;
		this.maKhachHang = maKhachHang;
		this.maBinhLuan = maBinhLuan;
		this.thoiGian = thoiGian;
	}

	public Timestamp getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Timestamp thoiGian) {
		this.thoiGian = thoiGian;
	}

	public int getMaTraLoiBinhLuan() {
		return maTraLoiBinhLuan;
	}

	public void setMaTraLoiBinhLuan(int maTraLoiBinhLuan) {
		this.maTraLoiBinhLuan = maTraLoiBinhLuan;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public int getMaBinhLuan() {
		return maBinhLuan;
	}

	public void setMaBinhLuan(int maBinhLuan) {
		this.maBinhLuan = maBinhLuan;
	}
}

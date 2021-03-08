/*
 * @author VTA
 * @date Apr 17, 2020
 * @version 1.0
 */

package model.bean;

public class ChiTietHoaDonBEAN {
	private int maHoaDon;
	private int maSach;
	private String tenSach;
	private String anh;
	private int soLuong;
	private long gia;
	private long tongTien; // tổng tiền bằng gia * soLuong tự nhân trong contructors
	public ChiTietHoaDonBEAN() {
		super();
	}
	
	public ChiTietHoaDonBEAN(int maHoaDon, int maSach, String tenSach, String anh, int soLuong, long gia) {
		super();
		this.maHoaDon = maHoaDon;
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.anh = anh;
		this.soLuong = soLuong;
		this.gia = gia;
		this.tongTien = gia*soLuong;
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public int getMaSach() {
		return maSach;
	}
	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getTongTien() {
		return tongTien;
	}
	public void setTongTien() {
		this.tongTien = this.gia*this.soLuong;
	}
}

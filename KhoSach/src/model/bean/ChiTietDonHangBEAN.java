package model.bean;

public class ChiTietDonHangBEAN {
	private int maHoaDon;
	private int maKhachHang;
	private String tenSach;
	private String anh;
	public ChiTietDonHangBEAN(int maHoaDon, int maKhachHang, String tenSach, String anh, int soLuong, int gia) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKhachHang = maKhachHang;
		this.tenSach = tenSach;
		this.anh = anh;
		this.soLuong = soLuong;
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	private int soLuong;
	private int gia;
	public int getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public int getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public long thanhTien() {
		return this.gia*this.soLuong;
	}
	public ChiTietDonHangBEAN() {
		super();
	}
	
	
}

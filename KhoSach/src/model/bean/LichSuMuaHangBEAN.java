package model.bean;

public class LichSuMuaHangBEAN {
	private int maHoaDon;
	private int tongSoLuong;
	private int tongTien;
	private String ngayMua;
	public int getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public int getTongSoLuong() {
		return tongSoLuong;
	}
	public void setTongSoLuong(int tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public String getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(String ngayMua) {
		this.ngayMua = ngayMua;
	}
	public LichSuMuaHangBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LichSuMuaHangBEAN(int maHoaDon, int tongSoLuong, int tongTien, String ngayMua) {
		super();
		this.maHoaDon = maHoaDon;
		this.tongSoLuong = tongSoLuong;
		this.tongTien = tongTien;
		this.ngayMua = ngayMua;
	}
	
}

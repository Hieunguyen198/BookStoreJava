/*
 * @author VTA
 * @date Apr 17, 2020
 * @version 1.0
 */

package model.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SachBEAN {
	private int maSach;
	private String tenSach;
	private int soLuong;
	private Long gia;
	private Long giaKhuyenMai;
	private String tacGia;
	private int namXuatBan;
	private String nhaXuatBan;
	private String anh;
	private int maTheLoai;
	private String tenTheLoai;
	private Date ngayNhap;
	private boolean trangThai;
	private String moTa;

	public SachBEAN() {
		super();
	}

	public SachBEAN(int maSach, String tenSach, int soLuong, Long gia, Long giaKhuyenMai, String tacGia, int namXuatBan,
			String nhaXuatBan, String anh, int maTheLoai, String tenTheLoai, Date ngayNhap, boolean trangThai,
			String moTa) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.soLuong = soLuong;
		this.gia = gia;
		this.giaKhuyenMai = giaKhuyenMai;
		this.tacGia = tacGia;
		this.namXuatBan = namXuatBan;
		this.nhaXuatBan = nhaXuatBan;
		this.anh = anh;
		this.maTheLoai = maTheLoai;
		this.tenTheLoai = tenTheLoai;
		this.ngayNhap = ngayNhap;
		this.trangThai = trangThai;
		this.moTa = moTa;
	}


	public String getTenTheLoai() {
		return tenTheLoai;
	}


	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}


	public int getMaSach() {
		return maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
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

	public Long getGia() {
		return gia;
	}

	public void setGia(Long gia) {
		this.gia = gia;
	}

	public Long getGiaKhuyenMai() {
		return giaKhuyenMai;
	}

	public void setGiaKhuyenMai(Long giaKhuyenMai) {
		this.giaKhuyenMai = giaKhuyenMai;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public int getMaTheLoai() {
		return maTheLoai;
	}

	public void setMaTheLoai(int maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	public String getNgayNhapSring() { // trả về dạng ngày chuổi
		SimpleDateFormat day = new SimpleDateFormat("yyy/MM/dd");
		return day.format(ngayNhap);
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
}

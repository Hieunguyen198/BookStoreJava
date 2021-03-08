/*
 * @author VTA
 * @date Apr 17, 2020
 * @version 1.0
 */

package model.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class KhachHangBEAN {
	private int maKhachHang;
	private String tenKhachHang;
	private String Email;
	private String soDienThoai;
	private String diaChi;
	private Date ngaySinh;
	private boolean gioiTinh;
	private String matKhau;
	private String tenDangNhap;

	public KhachHangBEAN() {
		super();
	}

	public KhachHangBEAN(int maKhachHang, String tenKhachHang, String email, String soDienThoai, String diaChi,
			Date ngaySinh, boolean gioiTinh, String matKhau, String tenDangNhap) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		Email = email;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.matKhau = matKhau;
		this.tenDangNhap = tenDangNhap;
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}
	public String getNgaySinhString() { /// get ngay thành chuỗi
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
		return day.format(ngaySinh);
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

}

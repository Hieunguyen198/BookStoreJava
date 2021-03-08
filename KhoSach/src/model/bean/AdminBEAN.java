/*
 * @author VTA
 * @date Apr 17, 2020
 * @version 1.0
 */

package model.bean;

public class AdminBEAN {
	private String tenDangNhap;
	private String matKhau;

	public AdminBEAN() {
		super();
	}

	public AdminBEAN(String tenDangNhap, String maKhau) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = maKhau;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String maKhau) {
		this.matKhau = maKhau;
	}
}

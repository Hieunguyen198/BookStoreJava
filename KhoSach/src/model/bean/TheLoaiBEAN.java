/*
 * @author VTA
 * @date Apr 17, 2020
 * @version 1.0
 */

package model.bean;

public class TheLoaiBEAN {
	private int maTheLoai;
	private String TenTheLoai;
	private int maNhomTheLoai;
	private String tenNhomTheLoai;
	public int getMaTheLoai() {
		return maTheLoai;
	}
	public void setMaTheLoai(int maTheLoai) {
		this.maTheLoai = maTheLoai;
	}
	public String getTenTheLoai() {
		return TenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		TenTheLoai = tenTheLoai;
	}
	public int getMaNhomTheLoai() {
		return maNhomTheLoai;
	}
	public void setMaNhomTheLoai(int maNhomTheLoai) {
		this.maNhomTheLoai = maNhomTheLoai;
	}
	public String getTenNhomTheLoai() {
		return tenNhomTheLoai;
	}
	public void setTenNhomTheLoai(String tenNhomTheLoai) {
		this.tenNhomTheLoai = tenNhomTheLoai;
	}
	public TheLoaiBEAN(int maTheLoai, String tenTheLoai, int maNhomTheLoai, String tenNhomTheLoai) {
		super();
		this.maTheLoai = maTheLoai;
		TenTheLoai = tenTheLoai;
		this.maNhomTheLoai = maNhomTheLoai;
		this.tenNhomTheLoai = tenNhomTheLoai;
	}
	public TheLoaiBEAN() {
		super();
	}

	
}

/*
 * @author VTA
 * @date Apr 28, 2020
 * @version 1.0
 */

package model.bean;

public class SachBinhLuanBEAN {
	private int maSach;
	private String tenSach;
	private int soLuongBinhLuan;

	public SachBinhLuanBEAN(int maSach, String tenSach, int soLuongBinhLuan) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.soLuongBinhLuan = soLuongBinhLuan;
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

	public int getSoLuongBinhLuan() {
		return soLuongBinhLuan;
	}

	public void setSoLuongBinhLuan(int soLuongBinhLuan) {
		this.soLuongBinhLuan = soLuongBinhLuan;
	}
}

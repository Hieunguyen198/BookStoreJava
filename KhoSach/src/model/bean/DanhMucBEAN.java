package model.bean;

public class DanhMucBEAN {
	private int maDanhMuc;
	private String TenDanhMuc;
	public int getMaDanhMuc() {
		return maDanhMuc;
	}
	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	public String getTenDanhMuc() {
		return TenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		TenDanhMuc = tenDanhMuc;
	}
	public DanhMucBEAN() {
		super();
	}
	public DanhMucBEAN(int maDanhMuc, String tenDanhMuc) {
		super();
		this.maDanhMuc = maDanhMuc;
		TenDanhMuc = tenDanhMuc;
	}
	
	

}

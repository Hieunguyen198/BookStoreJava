package model.bean;

public class NhomTheLoaiBEAN {
	
	private int maNhomTheLoai;
	private String tenNhomTheLoai;
	private int maDanhMuc;
	private String tenDanhMuc;
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
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
	public int getMaDanhMuc() {
		return maDanhMuc;
	}
	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	public NhomTheLoaiBEAN(int maNhomTheLoai, String tenNhomTheLoai, int maDanhMuc, String tenDanhMuc) {
		super();
		this.maNhomTheLoai = maNhomTheLoai;
		this.tenNhomTheLoai = tenNhomTheLoai;
		this.maDanhMuc = maDanhMuc;
		this.tenDanhMuc = tenDanhMuc;
	}
	public NhomTheLoaiBEAN() {
		super();
	}
	
	

}

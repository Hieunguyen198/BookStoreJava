/*
 * @author VTA
 * @date Apr 17, 2020
 * @version 1.0
 */

package model.bean;

public class GioHangBEAN {
    private int maSach;
    private String tenSach;
    private String anh;
    private int soLuong;
    private int soLuongMax;
    private Long gia;

    public GioHangBEAN(int maSach, String tenSach, String anh, int soLuong,int soLuongMax,
            Long gia) {
        super();
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.anh = anh;
        this.soLuong = soLuong;
        this.soLuongMax = soLuongMax;
        this.gia = gia;
    }

    public int getSoLuongMax() {
		return soLuongMax;
	}

	public void setSoLuongMax(int soLuongMax) {
		this.soLuongMax = soLuongMax;
	}

	public Long getGia() {
        return gia;
    }

    public void setGia(Long gia) {
        this.gia = gia;
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

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public GioHangBEAN() {
        super();
        // TODO Auto-generated constructor stub
    }

    // náº¿u thiáº¿u tá»± bá»� vÃ´ luÃ´n hÃ¡y keke do k cháº¯c Ä‘á»§ trÆ°á»�ng

}

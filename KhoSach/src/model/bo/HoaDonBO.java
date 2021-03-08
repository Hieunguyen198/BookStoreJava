package model.bo;

import java.util.ArrayList;

import model.bean.HoaDonBEAN;
import model.dao.HoaDonDAO;


public class HoaDonBO {
	HoaDonDAO s= new HoaDonDAO();
	public ArrayList<HoaDonBEAN> getHoaDon() throws Exception{
		return s.getHoaDon();
	}
	public int them( int maKhachHang, int trangThai, java.util.Date ngayLap, int phuongThuc) {
		return s.them(maKhachHang, trangThai, ngayLap, phuongThuc);
	}
	public int Xoa(String maXoa) throws Exception {
		return s.delete(maXoa);
	}
	public HoaDonBEAN getHoaDon(String maHoaDon) throws Exception{
		return s.getHoaDon(maHoaDon);
	}
	public int Duyet(String maDuyet) {
		return s.duyet(maDuyet);
	}
	public int capNhatTrangThai(int maHoaDon, int trangThai) {
        return s.capNhatTrangThai(maHoaDon, trangThai);
    }
	public int demMaHD() {
		return s.demMaHD();
	}
}

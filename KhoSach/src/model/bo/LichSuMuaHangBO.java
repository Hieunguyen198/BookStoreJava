package model.bo;

import java.util.ArrayList;

import model.bean.ChiTietDonHangBEAN;
import model.bean.LichSuMuaHangBEAN;
import model.dao.LichSuMuaHangDAO;

/*
 * @author Hieu
 * @date  2020-04-27
 * @version 1.0
 */

public class LichSuMuaHangBO {
	LichSuMuaHangDAO ls = new  LichSuMuaHangDAO();
	public ArrayList<LichSuMuaHangBEAN> getLSMHDD(int maKhachHang){
		return ls.getLSMHDD(maKhachHang);
	}
	public ArrayList<LichSuMuaHangBEAN> getLSMHCD(int maKhachHang){
		return ls.getLSMHCD(maKhachHang);
	}
	public void huyDonHang(int maDoHang) {
		ls.huyDonHang(maDoHang);
	}
	public ArrayList<ChiTietDonHangBEAN> getChiTietDonHang(int maKhachHang) {
		return ls.getChiTietDonHang(maKhachHang);
	}
}

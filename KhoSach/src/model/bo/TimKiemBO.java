/*
 * @author VTA
 * @date Apr 25, 2020
 * @version 1.0
 */

package model.bo;

import java.util.ArrayList;

import model.bean.SachBEAN;
import model.dao.TimKiemDAO;

public class TimKiemBO {
	TimKiemDAO timKiem = new TimKiemDAO();
	public ArrayList<String> getTimKiem(String tuKhoa) {
		return timKiem.getTimKiem(tuKhoa);
	}
	public ArrayList<SachBEAN> getListSachTimKiem(String tuKhoa) {
		return timKiem.getListSachTimKiem(tuKhoa);
	}
	public ArrayList<String> getTacGiaTimKiem(String tuKhoa) {
		return timKiem.getTacGiaTimKiem(tuKhoa);
	}
	public ArrayList<String> getNhaXuatBanTimKiem(String tuKhoa) {
		return timKiem.getNhaXuatBanTimKiem(tuKhoa);
	}
	
}

/*
 * @author VTA
 * @date Apr 16, 2020
 * @version 1.0
 */

package model.bo;

import java.util.ArrayList;

import model.bean.DanhMucBEAN;
import model.dao.DanhMucDAO;

public class DanhMucBO {
	DanhMucDAO dao = new DanhMucDAO();

	public ArrayList<DanhMucBEAN> getDanhSachDanhMuc() {

		return dao.getDanhSachDanhMuc();
	}
	
	public int them(String tenDanhMuc) {
		return dao.them(tenDanhMuc);
	}
	
	public int capNhap(int maDanhMuc, String tenDanhMuc) {
		return dao.capNhap(maDanhMuc, tenDanhMuc);
	}
	
	public int xoa(String maDanhMuc) {
		return dao.xoa(maDanhMuc);
		
	}
	public DanhMucBEAN getDanhMuc(int maDanhMuc) {
		return dao.getDanhMuc(maDanhMuc);
	}
	
	public ArrayList<DanhMucBEAN> selectListDanhMucSearch(String tukhoa) { 
		//hàm tìm kiếm theo nhiều trường.
		ArrayList<DanhMucBEAN> dsDanhMucCanTim = new ArrayList<>();
		ArrayList<DanhMucBEAN> dsDM = getDanhSachDanhMuc();
		String noidung = tukhoa.trim().toLowerCase();
		for (DanhMucBEAN dm : dsDM) {
			if ((dm.getTenDanhMuc().toLowerCase().contains(noidung))) {
				dsDanhMucCanTim.add(dm);
			}
		}
		if (!dsDanhMucCanTim.isEmpty()) {
			return dsDM;
		} else {
			return null;
		}

	}
}

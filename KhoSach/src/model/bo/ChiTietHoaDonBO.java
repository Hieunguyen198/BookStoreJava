/*
 * @author VTA
 * @date Apr 22, 2020
 * @version 1.0
 */

package model.bo;

import java.util.ArrayList;

import model.bean.ChiTietHoaDonBEAN;
import model.bean.GioHangBEAN;
import model.bean.HoaDonBEAN;
import model.dao.ChiTietHoaDonDAO;

public class ChiTietHoaDonBO {
	ChiTietHoaDonDAO chiTietDao = new ChiTietHoaDonDAO();
	public ArrayList<ChiTietHoaDonBEAN > getHoaDon()  {
		return chiTietDao.getHoaDon();
	}
	public ArrayList<ChiTietHoaDonBEAN> getChiTietHoaDon(String maHoaDon){
        return chiTietDao.getChiTietHoaDon(maHoaDon);
    }
	public int them(int maHoaDon, int maSach, int soLuong, long gia) {
        return chiTietDao.them(maHoaDon, maSach, soLuong, gia);
    }
    public void themall(ArrayList<GioHangBEAN> ds, int maHD) {
        for (GioHangBEAN gh : ds) {
            them(maHD, gh.getMaSach(), gh.getSoLuong(), gh.getGia());
        }
    }
}

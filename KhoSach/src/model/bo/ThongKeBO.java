/*
 * @author VTA
 * @date Apr 26, 2020
 * @version 1.0
 */

package model.bo;

import model.bean.ThongKeTheoNamBEAN;
import model.dao.ThongkeDAO;

public class ThongKeBO {
	ThongkeDAO thongKeDao = new ThongkeDAO();

	public ThongKeTheoNamBEAN getDachSachThangTrongNam(int nam) {
		return thongKeDao.getDachSachThangTrongNam(nam);
	}
	public String getDanhThuTheoNam() {
		return thongKeDao.getDanhThuTheoNam();
	}
	public ThongKeTheoNamBEAN getDachSachDoanhThuThangTrongNam(int nam) {
		return thongKeDao.getDachSachDoanhThuThangTrongNam(nam);
	}
}

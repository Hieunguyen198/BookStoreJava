package model.bo;

import java.util.ArrayList;

import model.bean.GioHangBEAN;
import model.dao.GioHangDAO;

public class GioHangBO {
	GioHangDAO ghDao = new GioHangDAO();
	public ArrayList<GioHangBEAN> ds;

	public ArrayList<GioHangBEAN> getGioHangs(int maKhachHang) {
		ds = ghDao.getGioHangs(maKhachHang);
		return ds;
	}

	public ArrayList<GioHangBEAN> themGioHang(int maSach, String tenSach, String anh, int soLuong, int soLuongMax,
			Long gia) {
		for (GioHangBEAN g : ds)
			if (g.getMaSach() == maSach) {
				g.setSoLuong(g.getSoLuong() + soLuong);
				return ds;
			}
		GioHangBEAN s = new GioHangBEAN(maSach, tenSach, anh, soLuong, soLuongMax, gia);
		ds.add(s);
		return ds;
	}

	public int themGioHangDB(int maKhachHang, int maSach, int soLuong, long gia) {
		for (GioHangBEAN g : ds)
			if (g.getMaSach() == maSach) {
				return capNhapGioHang(maKhachHang, maSach, soLuong);
			}
		return ghDao.themGioHangDB(maKhachHang, maSach, soLuong, gia);

	}

	public void themallDB(ArrayList<GioHangBEAN> gh, int maKhachHang) {
		for (GioHangBEAN g : gh) {
			themGioHangDB(maKhachHang, g.getMaSach(), g.getSoLuong(), g.getGia());
		}
	}

	public void capNhatSoLuong(int maSach, int soLuong) {
		for (GioHangBEAN g : ds)
			if (g.getMaSach() == maSach) {
				if (g.getSoLuong() + soLuong >= 1) {
					if (g.getSoLuong() + soLuong <= g.getSoLuongMax()) {
						g.setSoLuong(g.getSoLuong() + soLuong);
						return;
					} else {
						g.setSoLuong(g.getSoLuongMax());
						return;
					}
				}
			}
	}

	public int capNhapGioHangEnterDB(int maKhachHang, int maSach, int soLuong) {
		return ghDao.capNhapGioHangEnter(maKhachHang, maSach, soLuong);
	}

	public void capNhapGioHangEnter(int maSach, int soLuong) {
		GioHangBEAN gh = new GioHangBEAN();
		for (GioHangBEAN g : ds)
			if (g.getMaSach() == maSach) {
				gh = g;
				break;
			}
		Xoa(gh.getMaSach());
		themGioHang(maSach, gh.getTenSach(), gh.getAnh(), soLuong, gh.getSoLuongMax(), gh.getGia());
	}

	public int capNhapGioHang(int maKhachHang, int maSach, int soLuong) {
		for (GioHangBEAN g : ds)
			if (g.getMaSach() == maSach) {
				if (g.getSoLuong() + soLuong >= 1) {
					if (g.getSoLuong() + soLuong <= g.getSoLuongMax()) {
						return ghDao.capNhapGioHang(maKhachHang, maSach, g.getSoLuong() + soLuong);
					} else {
						return ghDao.capNhapGioHang(maKhachHang, maSach,g.getSoLuongMax());
					}
				}
			}
		return 0;
	}

	public void Xoa(int maSach) {
		int i = 0;
		for (GioHangBEAN g : ds) {
			if (g.getMaSach() == maSach) {
				ds.remove(i);
				return;
			}
			i++;
		}
	}

	public int XoaHangGioDB(int maKhachHang, int maSach) {
		return ghDao.XoaHangGioDB(maKhachHang, maSach);
	}

	public void XoaTatCa() {
		ArrayList<GioHangBEAN> gh = new ArrayList<>();
		ds = gh;
	}

	public int XoaTatCaDB(int maKhachHang) {
		return ghDao.XoaTatCaDB(maKhachHang);
	}

}

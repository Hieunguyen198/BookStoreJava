/*
 * @author VTA
 * @date Apr 26, 2020
 * @version 1.0
 */

package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.ThongKeTheoNamBEAN;

public class ThongkeDAO {
	Connections con = new Connections();

	public ThongKeTheoNamBEAN getDachSachThangTrongNam(int nam) {

		ThongKeTheoNamBEAN thongKe = null;
		try {
			con.KetNoi();
			String sql = "SELECT Nam, COALESCE([1] , 0) AS Thang1, COALESCE([2] , 0) AS Thang2, COALESCE([3] , 0) AS Thang3, COALESCE([4] , 0) AS Thang4, COALESCE([5] , 0) AS Thang5, COALESCE([6] , 0) AS Thang6, COALESCE([7] , 0) AS Thang7, COALESCE([8] , 0) AS Thang8, COALESCE([9] , 0) AS Thang9, COALESCE([10], 0) AS Thang10, COALESCE([11], 0) AS Thang11, COALESCE([12], 0) AS Thang12 FROM   (SELECT YEAR(NgayLap) as Nam  , MONTH(HD.NgayLap) AS Thang   , HD.MaHoaDon    FROM HoaDon HD	WHERE YEAR(HD.NgayLap) = ? )  TEMP PIVOT(  COUNT(MaHoaDon)    FOR Thang IN ([1], [2],[3],[4],[5],[6],[7],[8],[9],[10],[11],[12])) AS PivotTable";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, nam);
			ResultSet rs = cmd.executeQuery();
			if (rs.next()) {
				long namb = rs.getInt("Nam");
				long[] a = new long[13];
				for (int i = 1; i <= 12; i++) {
					a[i] = rs.getLong("Thang" + i);
				}
				thongKe = new ThongKeTheoNamBEAN(namb, a[1], a[2], a[3], a[4], a[5], a[6], a[7], a[8], a[9], a[10],
						a[11], a[12]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con.cn != null)
					con.cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return thongKe;
	}

	public String getDanhThuTheoNam() {

		String doanhThu = "";
		try {
			con.KetNoi();
			String sql = "SELECT DoanhThu FROM DoanhThuTheoNam";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String st = rs.getString("DoanhThu");
				doanhThu += st + ",";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con.cn != null)
					con.cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return doanhThu.substring(0, doanhThu.length() - 1);
	}
	public ThongKeTheoNamBEAN getDachSachDoanhThuThangTrongNam(int nam) {

		ThongKeTheoNamBEAN thongKe = null;
		try {
			con.KetNoi();
			String sql = "SELECT Nam, COALESCE([1] , 0) AS Thang1, COALESCE([2] , 0) AS Thang2, COALESCE([3] , 0) AS Thang3, COALESCE([4] , 0) AS Thang4, COALESCE([5] , 0) AS Thang5, COALESCE([6] , 0) AS Thang6, COALESCE([7] , 0) AS Thang7, COALESCE([8] , 0) AS Thang8, COALESCE([9] , 0) AS Thang9, COALESCE([10], 0) AS Thang10, COALESCE([11], 0) AS Thang11, COALESCE([12], 0) AS Thang12 FROM (SELECT YEAR(NgayLap) as Nam , MONTH(HD.NgayLap) AS Thang ,(CT.SoLuong*CT.Gia) AS TongTien FROM HoaDon HD JOIN ChiTietHoaDon CT ON CT.MaHoaDon = HD.MaHoaDon WHERE YEAR(HD.NgayLap) = ? AND HD.TrangThai=1 )  TEMP PIVOT( SUM(TongTien) FOR Thang IN ([1], [2],[3],[4],[5],[6],[7],[8],[9],[10],[11],[12])) AS PivotTable";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, nam);
			ResultSet rs = cmd.executeQuery();
			if (rs.next()) {
				long namb = rs.getInt("Nam");
				long[] a = new long[13];
				for (int i = 1; i <= 12; i++) {
					a[i] = rs.getLong("Thang" + i);
				}
				thongKe = new ThongKeTheoNamBEAN(namb, a[1], a[2], a[3], a[4], a[5], a[6], a[7], a[8], a[9], a[10],
						a[11], a[12]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con.cn != null)
					con.cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return thongKe;
	}

}

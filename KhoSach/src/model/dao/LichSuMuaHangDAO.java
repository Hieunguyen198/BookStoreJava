package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ChiTietDonHangBEAN;
import model.bean.LichSuMuaHangBEAN;

/*
 * @author Hieu
 * @date  2020-04-27
 * @version 1.0
 */

public class LichSuMuaHangDAO {
	Connections kn = new Connections();

	public ArrayList<LichSuMuaHangBEAN> getLSMHDD(int maKhachHang) {
		ArrayList<LichSuMuaHangBEAN> ds = new ArrayList<LichSuMuaHangBEAN>();
		String sql = "Select * from ViewDonHangDaDuyet Where MaKhacHHang=?";
		try {
			kn.KetNoi();
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, maKhachHang);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				int maHoaDon = rs.getInt("MaHoaDon");
				int tongSoLuong = rs.getInt("TongSoLuong");
				int tongTien = rs.getInt("TongTien");
				String ngayMua = rs.getString("NgayLap");
				LichSuMuaHangBEAN ls = new LichSuMuaHangBEAN(maHoaDon, tongSoLuong, tongTien, ngayMua);
				ds.add(ls);
			}
			rs.close();
			cmd.close();
		} catch (Exception e1) {
			System.out.println("Đã Xãy ra lỗi");
			System.out.println("Tên lỗi là: " + e1);
		} finally {
			try {
				kn.cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ds;
	}

	public ArrayList<LichSuMuaHangBEAN> getLSMHCD(int maKhachHang) {
		ArrayList<LichSuMuaHangBEAN> ds = new ArrayList<LichSuMuaHangBEAN>();
		String sql = "Select * from ViewDonHangChuaDuyet Where MaKhacHHang=?";
		try {
			kn.KetNoi();
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, maKhachHang);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				int maHoaDon = rs.getInt("MaHoaDon");
				int tongSoLuong = rs.getInt("TongSoLuong");
				int tongTien = rs.getInt("TongTien");
				String ngayMua = rs.getString("NgayLap");
				LichSuMuaHangBEAN ls = new LichSuMuaHangBEAN(maHoaDon, tongSoLuong, tongTien, ngayMua);
				ds.add(ls);
			}
			rs.close();
		} catch (Exception e1) {
			System.out.println("Đã Xãy ra lỗi");
			System.out.println("Tên lỗi là: " + e1);
		} finally {
			try {
				if (kn.cn != null) {
					kn.cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ds;
	}

	public void huyDonHang(int maHoaDon) {
		String sql = "Select * from HoaDon";
		try {
			kn.KetNoi();
			PreparedStatement cmd = kn.cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				if (rs.getInt("MaHoaDon") == maHoaDon) {
					rs.deleteRow();
					rs.close();
					break;
				}
			}
			rs.close();
			cmd.close();
		} catch (Exception e1) {
			System.out.println("Đã Xãy ra lỗi");
			System.out.println("Tên lỗi là: " + e1);
		} finally {
			try {
				if (kn.cn != null) {
					kn.cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<ChiTietDonHangBEAN> getChiTietDonHang(int maKhachHang) {
		ArrayList<ChiTietDonHangBEAN> ds = new ArrayList<ChiTietDonHangBEAN>();
		String sql = "Select * from ViewChiTietDonHang Where MaKhacHHang=?";
		try {
			kn.KetNoi();
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, maKhachHang);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				int maHoaDon = rs.getInt("MaHoaDon");
				String tenSach = rs.getString("TenSach");
				String anh = rs.getString("Anh");
				int soLuong = rs.getInt("SoLuong");
				int gia = rs.getInt("Gia");
				ChiTietDonHangBEAN ct = new ChiTietDonHangBEAN(maHoaDon, maKhachHang, tenSach, anh, soLuong, gia);
				ds.add(ct);
			}
			rs.close();
			cmd.close();
		} catch (Exception e1) {
			System.out.println("Đã Xãy ra lỗi");
			System.out.println("Tên lỗi là: " + e1);
		} finally {
			try {
				if (kn.cn != null) {
					kn.cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ds;
	}
}

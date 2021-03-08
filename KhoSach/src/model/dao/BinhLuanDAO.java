/*
 * @author VTA
 * @date Apr 27, 2020
 * @version 1.0
 */

package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.bean.BinhLuanBEAN;
import model.bean.SachBinhLuanBEAN;

public class BinhLuanDAO {
	Connections con = new Connections();

	public int them(String noiDungBinhLuan, int maKhachHang, int maSach, int danhGia, Timestamp thoiGian) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "INSERT INTO BinhLuan (NoiDungBinhLuan, MaKhachHang, MaSach, DanhGia, ThoiGian) VALUES (?,?,?,?,?)";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, noiDungBinhLuan);
			cmd.setInt(2, maKhachHang);
			cmd.setInt(3, maSach);
			cmd.setInt(4, danhGia);
			cmd.setTimestamp(5, thoiGian);
			kq = cmd.executeUpdate();
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

		return kq;
	}

	public int capNhap(int maBinhLuan, String noiDungBinhLuan, int maKhachHang, int maSach, int danhGia,
			Timestamp thoiGian) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "UPDATE BinhLuan SET NoiDungBinhLuan=?, MaKhachHang=? MaSach=? DanhGia=? ThoiGian =? WHERE MaBinhLuan=? )";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maKhachHang);
			cmd.setInt(2, maSach);
			cmd.setInt(3, danhGia);
			cmd.setTimestamp(4, thoiGian);
			cmd.setString(5, noiDungBinhLuan);
			kq = cmd.executeUpdate();
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

		return kq;
	}

	public BinhLuanBEAN getBinhLuan(int maBinhLuan) {
		BinhLuanBEAN binhLuan = null;
		try {
			con.KetNoi();
			ResultSet rs = null;
			String sql = "SELECT MaBinhLuan, NoiDungBinhLuan, MaKhachHang, MaSach, DanhGia, ThoiGian, TenDangNhap FROM BinhLuanKhachHang WHERE MaBinhLuan=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maBinhLuan);
			rs = cmd.executeQuery();
			if (rs.next()) {
				int maBL = rs.getInt("MaBinhLuan");
				String noiDungBinhLuan = rs.getString("NoiDungBinhLuan");
				int maKhachHang = rs.getInt("MaKhachHang");
				int maSach = rs.getInt("MaKhachHang");
				int danhGia = rs.getInt("MaKhachHang");
				Timestamp thoiGian = rs.getTimestamp("ThoiGian");
				String tenDangNhap = rs.getString("TenDangNhap");
				binhLuan = new BinhLuanBEAN(maBL, noiDungBinhLuan, maKhachHang, maSach, danhGia, thoiGian, tenDangNhap);
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

		return binhLuan;
	}

	public ArrayList<BinhLuanBEAN> getListBinhLuan(int maSach) {
		ArrayList<BinhLuanBEAN> listBinhLuan = new ArrayList<>();
		try {
			con.KetNoi();
			ResultSet rs = null;
			String sql = "SELECT MaBinhLuan, NoiDungBinhLuan, MaKhachHang, MaSach, DanhGia, ThoiGian,TenDangNhap FROM BinhLuanKhachHang WHERE MaSach=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maSach);
			rs = cmd.executeQuery();
			while (rs.next()) {
				int maBL = rs.getInt("MaBinhLuan");
				String noiDungBinhLuan = rs.getString("NoiDungBinhLuan");
				int maKhachHang = rs.getInt("MaKhachHang");
				int maS = rs.getInt("MaKhachHang");
				int danhGia = rs.getInt("MaKhachHang");
				Timestamp thoiGian = rs.getTimestamp("ThoiGian");
				String tenDangNhap = rs.getString("TenDangNhap");
				BinhLuanBEAN binhLuan = new BinhLuanBEAN(maBL, noiDungBinhLuan, maKhachHang, maS, danhGia, thoiGian,tenDangNhap);
				listBinhLuan.add(binhLuan);
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

		return listBinhLuan;
	}

	public int xoa(String maBinhLuan) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "DELETE FROM BinhLuan WHERE MaBinhLuan =?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, Integer.parseInt(maBinhLuan));
			kq = cmd.executeUpdate();

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

		return kq;
	}
	public ArrayList<SachBinhLuanBEAN> getListSachBinhLuan() {
		ArrayList<SachBinhLuanBEAN> listSachBinhLuan = new ArrayList<>();
		try {
			con.KetNoi();
			ResultSet rs = null;
			String sql = "SELECT MaSach, TenSach, SoLuong FROM SachBinhLuan";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			rs = cmd.executeQuery();
			while (rs.next()) {
				int maSach = rs.getInt("MaSach");
				String tenSach = rs.getString("TenSach");
				int soLuong = rs.getInt("SoLuong");
				SachBinhLuanBEAN sachBL = new SachBinhLuanBEAN(maSach, tenSach, soLuong);
				listSachBinhLuan.add(sachBL);
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

		return listSachBinhLuan;
	}

}

package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.GioHangBEAN;

public class GioHangDAO {
	Connections con = new Connections();

	public ArrayList<GioHangBEAN> getGioHangs(int maKhachHang) {
		ArrayList<GioHangBEAN> ds = new ArrayList<GioHangBEAN>();
		ResultSet rs = null;
		try {
			con.KetNoi();
			String sql = "SELECT GioHang.MaSach, Sach.TenSach, Sach.Anh, Sach.GiaKhuyenMai, GioHang.SoLuong,Sach.SoLuong as SoLuongMax FROM     GioHang INNER JOIN Sach ON GioHang.MaSach = Sach.MaSach Where GioHang.MaKhachHang="
					+ maKhachHang + "";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			rs = cmd.executeQuery();
			while (rs.next()) {
				int maSach = rs.getInt("MaSach");
				String tenSach = rs.getString("TenSach");
				String anh = rs.getString("Anh");
				int soLuong = rs.getInt("SoLuong");
				int soLuongMax = rs.getInt("SoLuongMax");
				Long gia = rs.getLong("GiaKhuyenMai");
				GioHangBEAN s = new GioHangBEAN(maSach, tenSach, anh, soLuong, soLuongMax, gia);
				ds.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (con.cn != null)
					con.cn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ds;

	}

	public int capNhapGioHang(int maKhachHang, int maSach, int soLuong) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "UPDATE GioHang SET SoLuong = ? WHERE MaSach=? and MaKhachHang=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, soLuong);
			cmd.setInt(2, maSach);// trang thái 1 rảnh , 2 bận, 3 đang
			cmd.setInt(3, maKhachHang); // dùng, 4 sửa chữa
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

	public int capNhapGioHangEnter(int maKhachHang, int maSach, int soLuong) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "UPDATE GioHang SET SoLuong =? WHERE MaSach=? and MaKhachHang=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, soLuong);
			cmd.setInt(2, maSach);// trang thái 1 rảnh , 2 bận, 3 đang
			cmd.setInt(3, maKhachHang); // dùng, 4 sửa chữa
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

	public int XoaHangGioDB(int maKhachHang, int maSach) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "DELETE FROM GioHang WHERE MaKhachHang =? and MaSach=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maKhachHang);
			cmd.setInt(2, maSach);
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

	public int XoaTatCaDB(int maKhachHang) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "DELETE FROM GioHang where MaKhachHang=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maKhachHang);
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

	public int themGioHangDB(int maKhachHang, int maSach, int soLuong, long l) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "INSERT INTO GioHang values (?,?,?,?) ";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maKhachHang);
			cmd.setInt(2, maSach);// trang thái 1 rảnh , 2 bận, 3 đang
			cmd.setInt(3, soLuong); // dùng, 4 sửa chữa
			cmd.setLong(4, (long) 0);
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
}

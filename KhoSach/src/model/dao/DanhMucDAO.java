package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.DanhMucBEAN;

public class DanhMucDAO {

	Connections con = new Connections();

	public int them(String tenDanhMuc) {

		int kq = 0;
		try {
			con.KetNoi();
			System.out.println(tenDanhMuc);
			String sql = "INSERT INTO DanhMuc (TenDanhMuc) VALUES (?)";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, tenDanhMuc);
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

	public int capNhap(int maDanhMuc, String tenDanhMuc) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "UPDATE DanhMuc SET TenDanhMuc = ? WHERE MaDanhMuc=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, tenDanhMuc);
			cmd.setInt(2, maDanhMuc);
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

	public DanhMucBEAN getDanhMuc(int maDanhMuc) {
		DanhMucBEAN danhMuc = null;
		try {
			con.KetNoi();
			ResultSet rs = null;
			String sql = "SELECT MaDanhMuc, TenDanhMuc FROM DanhMuc WHERE MaDanhMuc=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maDanhMuc);
			rs = cmd.executeQuery();
			if (rs.next()) {
				int maDM = rs.getInt("MaDanhMuc");
				String tenDanhMuc = rs.getString("TenDanhMuc");
				danhMuc = new DanhMucBEAN(maDM, tenDanhMuc);
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

		return danhMuc;
	}

	public ArrayList<DanhMucBEAN> getDanhSachDanhMuc() {

		ArrayList<DanhMucBEAN> listDanhMuc = new ArrayList<>();
		try {
			con.KetNoi();
			String sql = "SELECT MaDanhMuc, TenDanhMuc FROM DanhMuc";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				int maDanhMuc = rs.getInt("MaDanhMuc");
				String tenDanhMuc = rs.getString("TenDanhMuc");
				DanhMucBEAN danhMuc = new DanhMucBEAN(maDanhMuc, tenDanhMuc);
				listDanhMuc.add(danhMuc);
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

		return listDanhMuc;
	}

	public int xoa(String maDanhMuc) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "DELETE FROM DanhMuc WHERE MaDanhMuc =?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1,Integer.parseInt(maDanhMuc));
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

package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.NhomTheLoaiBEAN;

public class NhomTheLoaiDAO {

	Connections con = new Connections();

	public int them(String tenNhomTheLoai, int maDanhMuc) {

		int kq = 0;
		try {
			con.KetNoi();
			//System.out.println(tenDanhMuc);
			String sql = "INSERT INTO NhomTheLoai (TenNhomTheLoai,MaDanhMuc) VALUES (?,?)";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, tenNhomTheLoai);
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

	public int capNhap(int maNhomTheLoai, String tenNhomTheLoai, int maDanhMuc) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "UPDATE NhomTheLoai SET TenNhomTheLoai = ?, MaDanhMuc =? WHERE MaNhomTheLoai=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, tenNhomTheLoai);
			cmd.setInt(2, maDanhMuc);
			cmd.setInt(3, maNhomTheLoai);
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

	public NhomTheLoaiBEAN getNhomTheLoai(int maNhomTheLoai) {
		NhomTheLoaiBEAN nhomTheLoai = null;
		try {
			con.KetNoi();
			ResultSet rs = null;
			String sql = "SELECT MaDanhMuc, TenDanhMuc, MaNhomTheLoai, TenNhomTheLoai  FROM NhomTheLoaiDanhMuc WHERE MaNhomTheLoai=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maNhomTheLoai);
			rs = cmd.executeQuery();
			if (rs.next()) {
				int maNhomTL = rs.getInt("MaNhomTheLoai");
				String tenNhomTheLoai = rs.getString("TenNhomTheLoai");
				int maDanhMuc = rs.getInt("MaDanhMuc");
				String tenDanhMuc = rs.getString("TenDanhMuc");
				nhomTheLoai = new NhomTheLoaiBEAN(maNhomTL, tenNhomTheLoai, maDanhMuc, tenDanhMuc);
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

		return nhomTheLoai;
	}

	public ArrayList<NhomTheLoaiBEAN> getDanhSachNhomTheLoai() {

		ArrayList<NhomTheLoaiBEAN> listNhomTheLoai = new ArrayList<>();
		try {
			con.KetNoi();
			String sql = "select MaDanhMuc, TenDanhMuc, MaNhomTheLoai, TenNhomTheLoai from NhomTheLoaiDanhMuc";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				int maNhomTheLoai = rs.getInt("MaNhomTheLoai");
				String tenNhomTheLoai = rs.getString("TenNhomTheLoai");
				int maDanhMuc = rs.getInt("MaDanhMuc");
				String tenDanhMuc = rs.getString("TenDanhMuc");
				NhomTheLoaiBEAN nhomTheLoai = new NhomTheLoaiBEAN(maNhomTheLoai, tenNhomTheLoai, maDanhMuc, tenDanhMuc);
				listNhomTheLoai.add(nhomTheLoai);
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

		return listNhomTheLoai;
	}

	public int xoa(String maNhomTheLoai) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "DELETE FROM NhomTheLoai WHERE MaNhomTheLoai =?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1,Integer.parseInt(maNhomTheLoai));
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

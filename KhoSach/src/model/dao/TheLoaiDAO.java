package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.DanhMucBEAN;
import model.bean.TheLoaiBEAN;

public class TheLoaiDAO {

	Connections con = new Connections();

	public int them(String tenTheLoai, int maNhomTheLoai) {

		int kq = 0;
		try {
			con.KetNoi();
			//System.out.println(tenDanhMuc);
			String sql = "INSERT INTO TheLoai (TenTheLoai,MaNhomTheLoai) VALUES (?,?)";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, tenTheLoai);
			cmd.setInt(2, maNhomTheLoai);
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

	public int capNhap(int maTheLoai, String tenTheLoai, int maNhomTheLoai) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "UPDATE TheLoai SET TenTheLoai = ?, MaNhomTheLoai =? WHERE MaTheLoai=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, tenTheLoai);
			cmd.setInt(2, maNhomTheLoai);
			cmd.setInt(3, maTheLoai);
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

	public TheLoaiBEAN getTheLoai(int maTheLoai) {
		TheLoaiBEAN theLoai = null;
		try {
			con.KetNoi();
			ResultSet rs = null;
			String sql = "SELECT MaTheLoai, TenTheLoai, MaNhomTheLoai, TenNhomTheLoai FROM TheLoaiNhomTheLoai WHERE MaTheLoai=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maTheLoai);
			rs = cmd.executeQuery();
			if (rs.next()) {
				int maTL = rs.getInt("MaTheLoai");
				String tenTheLoai = rs.getString("TenTheLoai");
				int maNhomTheLoai = rs.getInt("MaNhomTheLoai");
				String tenNhomTheLoai = rs.getString("TenNhomTheLoai");
				theLoai = new TheLoaiBEAN(maTL, tenTheLoai,maNhomTheLoai,tenNhomTheLoai);
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

		return theLoai;
	}

	public ArrayList<TheLoaiBEAN> getDanhSachTheLoai() {

		ArrayList<TheLoaiBEAN> listTheLoai = new ArrayList<>();
		try {
			con.KetNoi();
			String sql = "select MaTheLoai, TenTheLoai, MaNhomTheLoai, TenNhomTheLoai from TheLoaiNhomTheLoai";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				int maTheLoai = rs.getInt("MaTheLoai");
				String tenTheLoai = rs.getString("TenTheLoai");
				int maNhomTheLoai = rs.getInt("MaNhomTheLoai");
				String tenNhomTheLoai = rs.getString("TenNhomTheLoai");
				TheLoaiBEAN theLoai = new TheLoaiBEAN(maTheLoai, tenTheLoai,maNhomTheLoai,tenNhomTheLoai);
				listTheLoai.add(theLoai);
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

		return listTheLoai;
	}

	public int xoa(String maTheLoai) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "DELETE FROM TheLoai WHERE MaTheLoai =?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1,Integer.parseInt(maTheLoai));
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

package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.AdminBEAN;

public class AdminDAO {
	Connections con = new Connections();

	public boolean kTra(String tenDangNhap) {
		String sql = "SELECT TenDangNhap FROM Admin WHERE TenDangNhap=?";
		PreparedStatement cmd;
		ResultSet rs = null;
		boolean kq = true;
		try {
			cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, tenDangNhap);
			rs = cmd.executeQuery();
			kq = rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return kq;
	}

	public int them(String tenDangNhap, String matKhau) {
		int kq = 0;
		try {
			con.KetNoi();
			if (kTra(tenDangNhap))
				return 0;
			String sql = "INSERT INTO Admin VALUES (?,?)";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, tenDangNhap);
			cmd.setString(2, matKhau);
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

	public int capNhat(String tenDangNhap, String matKhau) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "UPDATE Admin SET MatKhau=? WHERE TenDangNhap=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, matKhau);
			cmd.setString(2, tenDangNhap);
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

	public AdminBEAN getAdmin(String tenDangNhap) {
		AdminBEAN admin= null;
		try {
			con.KetNoi();
			ResultSet rs = null;
			String sql = "SELECT TenDangNhap, MatKhau FROM Admin WHERE TenDangNhap=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, tenDangNhap);
			rs = cmd.executeQuery();
			if (rs.next()) {
				String tenDangNhap1 = rs.getString("TenDangNhap");
				String matKhau = rs.getString("MatKhau");
				admin = new AdminBEAN(tenDangNhap1, matKhau);
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

		return admin;
	}

	public ArrayList<AdminBEAN> getAdmin(){

		ArrayList<AdminBEAN> listAdmin = new ArrayList<>();
		try {
			con.KetNoi();
			String sql = "SELECT * FROM Admin";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String tenDangNhap= rs.getString("TenDangNhap");
				String matKhau = rs.getString("MatKhau");
				AdminBEAN admin = new AdminBEAN(tenDangNhap, matKhau);
				listAdmin.add(admin);
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

		return listAdmin;
//		ArrayList<AdminBEAN> ds = new ArrayList<AdminBEAN>();
//		con.KetNoi();
//		String sql = "select * from Admin";
//		PreparedStatement cmd = con.cn.prepareStatement(sql);
//		ResultSet rs = cmd.executeQuery();
//		while(rs.next()) {
//			String tenDangNhap=rs.getString("TenDangNhap");
//			String matKhau = rs.getString("MatKhau");
//			
//			AdminBEAN s = new AdminBEAN(tenDangNhap, matKhau);
//			ds.add(s);
//		}
//		rs.close();
//		con.cn.close();
//		return ds;
	}

	public int xoa(String tenDangNhap) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "DELETE FROM Admin WHERE TenDangNhap =?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, tenDangNhap);
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
	public boolean checkLogin(String tenDangNhap, String matKhau) {
		con.KetNoi();
		String sql=	"SELECT TenDangNhap FROM Admin WHERE TenDangNhap = ? AND MatKhau = ?";
		ResultSet rs = null;
		try {
			PreparedStatement stmt = con.cn.prepareStatement(sql);
			stmt.setString(1, tenDangNhap);
			stmt.setString(2, matKhau);
			rs = stmt.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con.cn != null)
					con.cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
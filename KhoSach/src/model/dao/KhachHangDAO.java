package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.bean.KhachHangBEAN;

public class KhachHangDAO {
	String sql = "Select MaKhachHang,TenKhachHang,Email,SoDienThoai,DiaChi,NgaySinh,GioiTinh,MatKhau,TenDangNhap from KhachHang";
	Connections kn = new Connections();

	public ArrayList<KhachHangBEAN> layTTKH() {
		ArrayList<KhachHangBEAN> ds = new ArrayList<KhachHangBEAN>();
		try {
			kn.KetNoi();
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				int maKhachHang = rs.getInt("MaKhachHang");
				String tenKhachHang = rs.getString("TenKhachHang");
				String email = rs.getString("Email");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				Date ngaySinh = rs.getDate("NgaySinh");
				boolean gioiTinh = rs.getBoolean("GioiTinh");
				String matKhau = rs.getString("MatKhau");
				String tenDangNhap = rs.getString("TenDangNhap");
				KhachHangBEAN kh = new KhachHangBEAN(maKhachHang, tenKhachHang, email, soDienThoai, diaChi, ngaySinh,
						gioiTinh, matKhau, tenDangNhap);
				ds.add(kh);
			}
			rs.close();
			cmd.close();
		} catch (Exception e1) {
			System.out.println("Đã Xãy ra lỗi");
			System.out.println("Tên lỗi là: " + e1);
		} finally {
			try {
				if(kn.cn !=null) {
	        		kn.cn.close();
	        	}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ds;
	}

	public KhachHangBEAN getKhachHang(int maKhachHang) {
		KhachHangBEAN khachHang = new KhachHangBEAN();
		try {
			kn.KetNoi();
			String sql = "Select MaKhachHang,TenKhachHang,Email,SoDienThoai,DiaChi,NgaySinh,GioiTinh,MatKhau,TenDangNhap from KhachHang WHERE MaKhachHang=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, maKhachHang);
			ResultSet rs = cmd.executeQuery();
			if (rs.next()) {
				int maKH = rs.getInt("MaKhachHang");
				String tenKhachHang = rs.getString("TenKhachHang");
				String email = rs.getString("Email");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				Date ngaySinh = rs.getDate("NgaySinh");
				boolean gioiTinh = rs.getBoolean("GioiTinh");
				String matKhau = rs.getString("MatKhau");
				String tenDN = rs.getString("TenDangNhap");
				khachHang = new KhachHangBEAN(maKH, tenKhachHang, email, soDienThoai, diaChi, ngaySinh, gioiTinh,
						matKhau, tenDN);

			}
			rs.close();
			cmd.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if(kn.cn !=null) {
	        		kn.cn.close();
	        	}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return khachHang;
	}

	public void xoaKhachHang(int maKhachHang) {
		try {
			kn.KetNoi();
			PreparedStatement cmd = kn.cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				if (rs.getInt("MaKhachHang") == maKhachHang) {
					rs.deleteRow();
					rs.close();
					break;
				}
			}
			cmd.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(kn.cn !=null) {
	        		kn.cn.close();
	        	}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void themKhachHang(String tenKhachHang, String email, String soDienThoai, String diaChi, Date ngaySinh,
			boolean gioiTinh, String matKhau, String tenDangNhap) {
		String sql = "Select TenKhachHang,Email,SoDienThoai,DiaChi,NgaySinh,GioiTinh,MatKhau,TenDangNhap from KhachHang";
		try {
			kn.KetNoi();
			PreparedStatement cmd = kn.cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = cmd.executeQuery();
			rs.moveToInsertRow();
			rs.updateString(1, tenKhachHang);
			rs.updateString(2, email);
			rs.updateString(3, soDienThoai);
			rs.updateString(4, diaChi);
			rs.updateDate(5, (java.sql.Date) ngaySinh);
			rs.updateBoolean(6, gioiTinh);
			rs.updateString(7, matKhau);
			rs.updateString(8, tenDangNhap);
			rs.insertRow();
			rs.close();
			cmd.close();
		} catch (Exception e1) {
			System.out.println("Đã Xãy ra lỗi");
			e1.printStackTrace();
		} finally {
			try {
				if(kn.cn !=null) {
	        		kn.cn.close();
	        	}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean kTraMatKhau(String matKhau, int maKhachHang) {
		kn.KetNoi();
		String sql = "SELECT TenDangNhap FRoM KhachHang WHERE MatKhau=? AND maKhachHang =?";
		PreparedStatement cmd;
		ResultSet rs = null;
		boolean kq = true;
		try {
			cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, matKhau);
			cmd.setInt(2, maKhachHang);
			rs = cmd.executeQuery();
			kq = rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (kn.cn != null) {
					kn.cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return kq;
	}

	public void thayDoiMatKhau(String matKhauMoi, int maKhachHang) {
		try {
			kn.KetNoi();
			PreparedStatement cmd = kn.cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				if (rs.getInt("MaKhachHang") == maKhachHang) {
					rs.updateString("MatKhau", matKhauMoi);
					rs.updateRow();
					break;
				}
			}
			rs.close();
			cmd.close();
		} catch (Exception e1) {
			System.out.println("Đã Xãy ra lỗi");
			e1.printStackTrace();
		} finally {
			try {
				if(kn.cn !=null) {
	        		kn.cn.close();
	        	}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void thayDoiThongTin(int maKhachHang, String tenKhachHang, String email, String soDienThoai, String diaChi,
			Date ngaySinh, boolean gioiTinh) {
		try {
			kn.KetNoi();
			PreparedStatement cmd = kn.cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				if (rs.getInt("MaKhachHang") == maKhachHang) {
					rs.updateString("TenKhachHang", tenKhachHang);
					rs.updateString("Email", email);
					rs.updateString("SoDienThoai", soDienThoai);
					rs.updateString("DiaChi", diaChi);
					rs.updateDate("NgaySinh", (java.sql.Date) ngaySinh);
					rs.updateBoolean("GioiTinh", gioiTinh);
					rs.updateRow();
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
				if(kn.cn !=null) {
	        		kn.cn.close();
	        	}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

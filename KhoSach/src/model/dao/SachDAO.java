/*
 * @author VTA
 * @date Apr 17, 2020
 * @version 1.0
 */

package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.bean.AdminBEAN;
import model.bean.SachBEAN;

public class SachDAO {
	Connections con = new Connections();

	public int them(String tenSach, int soLuong, long gia, long giaKhuyenMai, String tacGia, int namXuatBan,
			String nhaXuatBan, String anh, int maTheLoai, String moTa) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "INSERT INTO Sach (TenSach, SoLuong, Gia, GiaKhuyenMai, TacGia, NamXuatBan, NhaXuatBan, Anh, MaTheLoai, NgayNhap, TrangThai, MoTa ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			Date ngayNhap = new Date();
			cmd.setString(1, tenSach);
			cmd.setInt(2, soLuong);
			cmd.setLong(3, gia);
			cmd.setLong(4, giaKhuyenMai);
			cmd.setString(5, tacGia);
			cmd.setInt(6, namXuatBan);
			cmd.setString(7, nhaXuatBan);
			cmd.setString(8, anh);
			cmd.setInt(9, maTheLoai);
			java.sql.Date ngay = new java.sql.Date(ngayNhap.getTime());
			cmd.setDate(10, ngay);
			cmd.setBoolean(11, true);// trạng thái còn sách
			cmd.setString(12, moTa);
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

	public int capNhap(int maSach, String tenSach, int soLuong, long gia, long giaKhuyenMai, String tacGia,
			int namXuatBan, String nhaXuatBan, String anh, int maTheLoai, Date ngayNhap, Boolean trangThai,
			String moTa) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "UPDATE Sach SET TenSach = ?, SoLuong = ?, Gia = ?, GiaKhuyenMai = ?, TacGia = ?, NamXuatBan = ?, NhaXuatBan = ?, Anh = ?, MaTheLoai = ?, NgayNhap = ?, TrangThai = ?, MoTa = ? WHERE MaSach=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, tenSach);
			cmd.setInt(2, soLuong);
			cmd.setLong(3, gia);
			cmd.setLong(4, giaKhuyenMai);
			cmd.setString(5, tacGia);
			cmd.setInt(6, namXuatBan);
			cmd.setString(7, nhaXuatBan);
			cmd.setString(8, anh);
			cmd.setInt(9, maTheLoai);
			java.sql.Date ngay = new java.sql.Date(ngayNhap.getTime());
			cmd.setDate(10, ngay);
			cmd.setBoolean(11, trangThai);
			cmd.setString(12, moTa);
			cmd.setInt(13, maSach);
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

	public SachBEAN getSach(int maSach) {

		SachBEAN sach = new SachBEAN();
		try {
			con.KetNoi();
			String sql = "SELECT MaSach, TenSach, SoLuong, Gia, GiaKhuyenMai, TacGia, NamXuatBan, NhaXuatBan, Anh, MaTheLoai, TenTheLoai, NgayNhap, TrangThai, MoTa  FROM SachTheLoai WHERE MaSach=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maSach);
			ResultSet rs = cmd.executeQuery();
			if (rs.next()) {
				int maSachMoi = rs.getInt("MaSach");
				String tenSach = rs.getString("TenSach");
				int soLuong = rs.getInt("SoLuong");
				long gia = rs.getLong("Gia");
				long giaKhuyenMai = rs.getLong("GiaKhuyenMai");
				String tacGia = rs.getString("TacGia");
				int namXuatBan = rs.getInt("NamXuatBan");
				String nhaXuatBan = rs.getString("NhaXuatBan");
				String anh = rs.getString("Anh");
				int maTheLoai = rs.getInt("MaTheLoai");
				String tenTheLoai = rs.getString("TenTheLoai");
				Date ngayNhap = rs.getDate("NgayNhap");
				Boolean trangThai = rs.getBoolean("TrangThai");
				String moTa = rs.getString("MoTa");

				sach = new SachBEAN(maSachMoi, tenSach, soLuong, gia, giaKhuyenMai, tacGia, namXuatBan, nhaXuatBan, anh,
						maTheLoai, tenTheLoai, ngayNhap, trangThai, moTa);
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

		return sach;
	}

	public ArrayList<SachBEAN> getDanhSachSach() {

		ArrayList<SachBEAN> listSach = new ArrayList<>();
		try {
			con.KetNoi();
			String sql = "SELECT MaSach, TenSach, SoLuong, Gia, GiaKhuyenMai, TacGia, NamXuatBan, NhaXuatBan, Anh, MaTheLoai, TenTheLoai, NgayNhap, TrangThai, MoTa  FROM SachTheLoai";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				int maSachMoi = rs.getInt("MaSach");
				String tenSach = rs.getString("TenSach");
				int soLuong = rs.getInt("SoLuong");
				long gia = rs.getLong("Gia");
				long giaKhuyenMai = rs.getLong("GiaKhuyenMai");
				String tacGia = rs.getString("TacGia");
				int namXuatBan = rs.getInt("NamXuatBan");
				String nhaXuatBan = rs.getString("NhaXuatBan");
				String anh = rs.getString("Anh");
				int maTheLoai = rs.getInt("MaTheLoai");
				String tenTheLoai = rs.getString("TenTheLoai");
				Date ngayNhap = rs.getDate("NgayNhap");
				Boolean trangThai = rs.getBoolean("TrangThai");
				String moTa = rs.getString("MoTa");

				SachBEAN sach = new SachBEAN(maSachMoi, tenSach, soLuong, gia, giaKhuyenMai, tacGia, namXuatBan,
						nhaXuatBan, anh, maTheLoai, tenTheLoai, ngayNhap, trangThai, moTa);
				listSach.add(sach);
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

		return listSach;
	}

	public int xoa(String maSach) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "DELETE FROM Sach WHERE MaSach=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, maSach);
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
	public  ArrayList<SachBEAN> getSachTheoTheLoai(int maTheLoai) {

		ArrayList<SachBEAN> listSach = new ArrayList<>();
		try {
			con.KetNoi();
			String sql = "SELECT MaSach, TenSach, SoLuong, Gia, GiaKhuyenMai, TacGia, NamXuatBan, NhaXuatBan, Anh, MaTheLoai, NgayNhap, TrangThai, MoTa  FROM Sach WHERE MaTheLoai=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maTheLoai);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				int maSachMoi = rs.getInt("MaSach");
				String tenSach = rs.getString("TenSach");
				int soLuong = rs.getInt("SoLuong");
				long gia = rs.getLong("Gia");
				long giaKhuyenMai = rs.getLong("GiaKhuyenMai");
				String tacGia = rs.getString("TacGia");
				int namXuatBan = rs.getInt("NamXuatBan");
				String nhaXuatBan = rs.getString("NhaXuatBan");
				String anh = rs.getString("Anh");
				int maTL= rs.getInt("MaTheLoai");
				Date ngayNhap = rs.getDate("NgayNhap");
				Boolean trangThai = rs.getBoolean("TrangThai");
				String moTa = rs.getString("MoTa");
				SachBEAN sach = new SachBEAN(maSachMoi, tenSach, soLuong, gia, giaKhuyenMai, tacGia, namXuatBan, nhaXuatBan, anh,
						maTL, null, ngayNhap, trangThai, moTa);
				listSach.add(sach);
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

		return listSach;
	}
	public ArrayList<String> getTacGia(int maTheLoai) {
		ArrayList<String> listTacGia = new ArrayList<>();

		try {
			con.KetNoi();
			String sql = "Select Distinct TacGia from Sach Where MaTheLoai = ?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maTheLoai);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String tacGia = rs.getString("TacGia");
				listTacGia.add(tacGia);
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

		return listTacGia;
	}

	public ArrayList<String> getNhaXuatBan(int maTheLoai) {
		ArrayList<String> listNhaXuatBan = new ArrayList<>();

		try {
			con.KetNoi();
			String sql = "Select Distinct NhaXuatBan from Sach Where MaTheLoai = ?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maTheLoai);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String xuatBan = rs.getString("NhaXuatBan");
				listNhaXuatBan.add(xuatBan);
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

		return listNhaXuatBan;
	}
	
	public ArrayList<String> getTacGiaDanhMuc(int maDanhMuc) {
		ArrayList<String> listTacGia = new ArrayList<>();

		try {
			con.KetNoi();
			String sql = "Select Distinct TacGia from SachDanhMuc Where MaDanhMuc = ?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maDanhMuc);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String tacGia = rs.getString("TacGia");
				listTacGia.add(tacGia);
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

		return listTacGia;
	}

	public ArrayList<String> getNhaXuatBanDanhMuc(int maDanhMuc) {
		ArrayList<String> listNhaXuatBan = new ArrayList<>();

		try {
			con.KetNoi();
			String sql = "Select Distinct NhaXuatBan from SachDanhMuc Where MaDanhMuc = ?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maDanhMuc);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String xuatBan = rs.getString("NhaXuatBan");
				listNhaXuatBan.add(xuatBan);
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

		return listNhaXuatBan;
	}
	
	
	public ArrayList<SachBEAN> getSachTheoDanhMuc(int maDanhMuc) {

		ArrayList<SachBEAN> listSach = new ArrayList<>();
		try {
			con.KetNoi();
			String sql = "SELECT MaSach, TenSach, SoLuong, Gia, GiaKhuyenMai, TacGia, NamXuatBan, NhaXuatBan, Anh, NgayNhap, MaTheLoai, TrangThai, MoTa from SachDanhMuc where MaDanhMuc =?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maDanhMuc);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				int maSachMoi = rs.getInt("MaSach");
				String tenSach = rs.getString("TenSach");
				int soLuong = rs.getInt("SoLuong");
				long gia = rs.getLong("Gia");
				long giaKhuyenMai = rs.getLong("GiaKhuyenMai");
				String tacGia = rs.getString("TacGia");
				int namXuatBan = rs.getInt("NamXuatBan");
				String nhaXuatBan = rs.getString("NhaXuatBan");
				String anh = rs.getString("Anh");
				int maTL = rs.getInt("MaTheLoai");
				Date ngayNhap = rs.getDate("NgayNhap");
				Boolean trangThai = rs.getBoolean("TrangThai");
				String moTa = rs.getString("MoTa");
				SachBEAN sach = new SachBEAN(maSachMoi, tenSach, soLuong, gia, giaKhuyenMai, tacGia, namXuatBan, nhaXuatBan, anh, maTL, null, ngayNhap, trangThai, moTa);
				listSach.add(sach);
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

		return listSach;
	}
	
	
	public ArrayList<SachBEAN> getSachTheoNhomTheLoai(int maNhomTheLoai) {

		ArrayList<SachBEAN> listSach = new ArrayList<>();
		try {
			con.KetNoi();
			String sql = "SELECT MaSach, TenSach, SoLuong, Gia, GiaKhuyenMai, TacGia, NamXuatBan, NhaXuatBan, Anh, MaTheLoai, NgayNhap, TrangThai, MoTa  FROM SachNhomTheLoai WHERE MaNhomTheLoai=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maNhomTheLoai);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				int maSachMoi = rs.getInt("MaSach");
				String tenSach = rs.getString("TenSach");
				int soLuong = rs.getInt("SoLuong");
				long gia = rs.getLong("Gia");
				long giaKhuyenMai = rs.getLong("GiaKhuyenMai");
				String tacGia = rs.getString("TacGia");
				int namXuatBan = rs.getInt("NamXuatBan");
				String nhaXuatBan = rs.getString("NhaXuatBan");
				String anh = rs.getString("Anh");
				int maTL = rs.getInt("MaTheLoai");
				Date ngayNhap = rs.getDate("NgayNhap");
				Boolean trangThai = rs.getBoolean("TrangThai");
				String moTa = rs.getString("MoTa");
				SachBEAN sach = new SachBEAN(maSachMoi, tenSach, soLuong, gia, giaKhuyenMai, tacGia, namXuatBan,
						nhaXuatBan, anh, maTL, null, ngayNhap, trangThai, moTa);
				listSach.add(sach);
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

		return listSach;
	}
	
	public ArrayList<String> getTacGiaNhomTheLoai(int maNhomTheLoai) {
		ArrayList<String> listTacGia = new ArrayList<>();

		try {
			con.KetNoi();
			String sql = "Select Distinct TacGia from SachNhomTheLoai Where MaNhomTheLoai = ?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maNhomTheLoai);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String tacGia = rs.getString("TacGia");
				listTacGia.add(tacGia);
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

		return listTacGia;
	}

	public ArrayList<String> getNhaXuatBanNhomTheLoai(int maNhomTheLoai) {
		ArrayList<String> listNhaXuatBan = new ArrayList<>();

		try {
			con.KetNoi();
			String sql = "Select Distinct NhaXuatBan from SachNhomTheLoai Where MaNhomTheLoai = ?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setInt(1, maNhomTheLoai);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String xuatBan = rs.getString("NhaXuatBan");
				listNhaXuatBan.add(xuatBan);
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

		return listNhaXuatBan;
	}
	
	public int capNhatSL(int maSach, int soLuong) {
        int kq = 0;
        try {
            con.KetNoi();
            String sql = "UPDATE Sach SET SoLuong= ? WHERE MaSach=?";
            PreparedStatement cmd = con.cn.prepareStatement(sql);
            cmd.setInt(1, soLuong);
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
	

    public int capNhatTrangThai(int maSach, boolean trangThai) {
        int kq = 0;
        try {
            con.KetNoi();
            String sql = "UPDATE Sach SET TrangThai=? WHERE MaSach=?";
            PreparedStatement cmd = con.cn.prepareStatement(sql);
            cmd.setBoolean(1, trangThai);
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
}

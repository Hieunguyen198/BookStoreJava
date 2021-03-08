/*
 * @author VTA
 * @date Apr 25, 2020
 * @version 1.0
 */

package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.bean.SachBEAN;

public class TimKiemDAO {
	Connections con = new Connections();

	public ArrayList<String> getTimKiem(String tuKhoa) {

		ArrayList<String> listTimKiem = new ArrayList<>();
		PreparedStatement cmd = null;
		try {
			con.KetNoi();
			String sql = "SELECT TenDanhMuc as TenTimKiem FROM DanhMuc WHERE TenDanhMuc LIKE ? UNION SELECT TenNhomTheLoai FROM NhomTheLoai WHERE TenNhomTheLoai LIKE ? UNION SELECT TenTheLoai FROM TheLoai WHERE TenTheLoai LIKE ? UNION SELECT TenSach FROM Sach WHERE TenSach LIKE ? ";
			cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, "%" + tuKhoa + "%");
			cmd.setString(2, "%" + tuKhoa + "%");
			cmd.setString(3, "%" + tuKhoa + "%");
			cmd.setString(4, "%" + tuKhoa + "%");
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String tenTinKiem = rs.getNString("TenTimKiem");
				listTimKiem.add(tenTinKiem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cmd != null)
					cmd.close();
				if (con.cn != null)
					con.cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listTimKiem;
	}

	public ArrayList<SachBEAN> getListSachTimKiem(String tuKhoa) {

		ArrayList<SachBEAN> listSach = new ArrayList<>();
		try {
			con.KetNoi();
			String sql = "SELECT MaSach, TenSach, SoLuong, Gia, GiaKhuyenMai, TacGia, NamXuatBan, NhaXuatBan, Anh, NgayNhap, MaTheLoai, TrangThai, MoTa FROM SachDanhMuc WHERE TenDanhMuc LIKE ? OR TenNhomTheLoai LIKE ?  OR  TenTheLoai LIKE ?  OR  TenSach LIKE ?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, "%" + tuKhoa + "%");
			cmd.setString(2, "%" + tuKhoa + "%");
			cmd.setString(3, "%" + tuKhoa + "%");
			cmd.setString(4, "%" + tuKhoa + "%");
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

	public ArrayList<String> getTacGiaTimKiem(String tuKhoa) {
		ArrayList<String> listTacGia = new ArrayList<>();

		try {
			con.KetNoi();
			String sql = "Select Distinct TacGia FROM SachDanhMuc WHERE TenDanhMuc LIKE ? OR TenNhomTheLoai LIKE ?  OR  TenTheLoai LIKE ?  OR  TenSach LIKE ?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, "%" + tuKhoa + "%");
			cmd.setString(2, "%" + tuKhoa + "%");
			cmd.setString(3, "%" + tuKhoa + "%");
			cmd.setString(4, "%" + tuKhoa + "%");
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

	public ArrayList<String> getNhaXuatBanTimKiem(String tuKhoa) {
		ArrayList<String> listNhaXuatBan = new ArrayList<>();

		try {
			con.KetNoi();
			String sql = "Select Distinct NhaXuatBan FROM SachDanhMuc WHERE TenDanhMuc LIKE ? OR TenNhomTheLoai LIKE ?  OR  TenTheLoai LIKE ?  OR  TenSach LIKE ?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, "%" + tuKhoa + "%");
			cmd.setString(2, "%" + tuKhoa + "%");
			cmd.setString(3, "%" + tuKhoa + "%");
			cmd.setString(4, "%" + tuKhoa + "%");
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

}

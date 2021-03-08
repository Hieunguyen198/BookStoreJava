/*
 * @author VTA
 * @date Apr 22, 2020
 * @version 1.0
 */

package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ChiTietHoaDonBEAN;

public class ChiTietHoaDonDAO {
	Connections con = new Connections();
	public ArrayList<ChiTietHoaDonBEAN > getHoaDon()  {

		ArrayList<ChiTietHoaDonBEAN > listChiTiet = new ArrayList<>();
		try {
			con.KetNoi();
			String sql = "SELECT MaHoaDon,MaSach,TenSach,Anh,SoLuong,Gia FROM ChiTietSachHoaDon";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				int maHoaDon = rs.getInt("MaHoaDon");
				int maSach = rs.getInt("MaSach");
				String tenSach = rs.getString("TenSach");
				String anh = rs.getString("anh");
				int soLuong = rs.getInt("SoLuong");
				int gia =rs.getInt("Gia");
				ChiTietHoaDonBEAN chiTiet = new ChiTietHoaDonBEAN(maHoaDon, maSach, tenSach, anh, soLuong, gia);
				listChiTiet.add(chiTiet);
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

		return listChiTiet;
	}
    public ArrayList<ChiTietHoaDonBEAN> getChiTietHoaDon(String maHoaDon) {
        ArrayList<ChiTietHoaDonBEAN > listChiTiet = new ArrayList<>();
        try {
            con.KetNoi();
            String sql = "SELECT MaHoaDon,MaSach,TenSach,Anh,SoLuong,Gia FROM ChiTietSachHoaDon WHERE MaHoaDon=?";
            PreparedStatement cmd = con.cn.prepareStatement(sql);
            cmd.setString(1, maHoaDon);
            ResultSet rs = cmd.executeQuery();
           while (rs.next()) {
                int maHoaDon1 = rs.getInt("MaHoaDon");
                int maSach = rs.getInt("MaSach");
                String tenSach = rs.getString("TenSach");
                String anh = rs.getString("Anh");
                int soLuong = rs.getInt("SoLuong");
                int gia =rs.getInt("Gia");
                ChiTietHoaDonBEAN chiTiet = new ChiTietHoaDonBEAN(maHoaDon1, maSach, tenSach, anh, soLuong, gia);
                listChiTiet.add(chiTiet);
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

        return listChiTiet;
    }
    
    public int them(int maHoaDon, int maSach, int soLuong, long gia) {
        int kq = 0;
        try {
            con.KetNoi();
            String sql = "INSERT INTO ChiTietHoaDon VALUES (?,?,?,?)";
            PreparedStatement cmd = con.cn.prepareStatement(sql);
            cmd.setInt(1, maHoaDon);
            cmd.setInt(2, maSach);
            cmd.setInt(3, soLuong);
            cmd.setLong(4, gia);
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

package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.HoaDonBEAN;

public class HoaDonDAO {
	Connections con = new Connections();


	public int them( int maKhachHang, int trangThai, java.util.Date ngayLap, int phuongThuc) {
        int kq = 0;
        try {
            con.KetNoi();
            String sql = "INSERT INTO HoaDon VALUES (?,?,?,?)";
            PreparedStatement cmd = con.cn.prepareStatement(sql);
            cmd.setInt(1, maKhachHang);
            cmd.setInt(2, trangThai);
            java.sql.Date nm1 = new java.sql.Date(ngayLap.getTime());
            cmd.setDate(3, nm1);
            cmd.setInt(4, phuongThuc);
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

	

	public HoaDonBEAN getHoaDon(String maHoaDon) {
		HoaDonBEAN hoaDon= null;
		try {
			con.KetNoi();
			ResultSet rs = null;
			String sql = "SELECT * FROM HoaDon WHERE MaHoaDon=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, maHoaDon);
			rs = cmd.executeQuery();
			if (rs.next()) {
				int maHoaDon1 = rs.getInt("MaHoaDon");
				int maKhachHang = rs.getInt("MaKhachHang");
				int trangThai = rs.getInt("TrangThai");
				Date ngayLap = rs.getDate("NgayLap");
				int phuongThucThanhToan = rs.getInt("PhuongThucThanhToan");
				hoaDon = new HoaDonBEAN(maHoaDon1, maKhachHang, trangThai, ngayLap, phuongThucThanhToan);
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

		return hoaDon;
	}

	public ArrayList<HoaDonBEAN> getHoaDon() throws Exception {

		ArrayList<HoaDonBEAN> listHoaDon = new ArrayList<>();
		try {
			con.KetNoi();
			String sql = "SELECT * FROM HoaDon";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				int maHoaDon = rs.getInt("MaHoaDon");
				int maKhachHang = rs.getInt("MaKhachHang");
				int trangThai = rs.getInt("TrangThai");
				Date ngayLap = rs.getDate("NgayLap");
				int phuongThucThanhToan = rs.getInt("PhuongThucThanhToan");
				HoaDonBEAN hoaDon = new HoaDonBEAN(maHoaDon, maKhachHang, trangThai, ngayLap, phuongThucThanhToan);
				listHoaDon.add(hoaDon);
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

		return listHoaDon;
	}

	public int delete(String maXoa) {
		int kq = 0;
		try {
			con.KetNoi();
			String sql = "DELETE FROM HoaDon WHERE MaHoaDon =?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, maXoa);
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



	public int duyet(String maDuyet) {
		int kq=0;
		try {
			con.KetNoi();
			String sql = "UPDATE HoaDon SET TrangThai =TrangThai^1 WHERE MaHoaDon=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, maDuyet);
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
	public int capNhatTrangThai(int maHoaDon, int trangThai) {
        int kq = 0;
        try {
            con.KetNoi();
            String sql = "UPDATE HoaDon SET TrangThai=? WHERE MaHoaDon=?";
            PreparedStatement cmd = con.cn.prepareStatement(sql);
            cmd.setInt(1, trangThai);
            cmd.setInt(2, maHoaDon);
            
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
	public int demMaHD() {
        // TODO Auto-generated method stub
        int maHoaDon = 0;
        try {
            con.KetNoi();
            String sql = "select top 1 MaHoaDon from HoaDon order by MaHoaDon DESC";
            PreparedStatement cmd = con.cn.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                maHoaDon = rs.getInt("MaHoaDon");
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
        return maHoaDon;
    }
}

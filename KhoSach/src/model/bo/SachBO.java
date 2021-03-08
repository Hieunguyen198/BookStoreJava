/*
 * @author VTA
 * @date Apr 18, 2020
 * @version 1.0
 */

package model.bo;

import java.util.ArrayList;
import java.util.Date;

import model.bean.SachBEAN;
import model.dao.SachDAO;

public class SachBO {
	SachDAO sachDao = new SachDAO();
	public ArrayList<SachBEAN> getDanhSachSach() {
		return sachDao.getDanhSachSach();
	}
	public int them(String tenSach, int soLuong, long gia, long giaKhuyenMai, String tacGia, int namXuatBan,
			String nhaXuatBan, String anh, int maTheLoai, String moTa) {
		return sachDao.them(tenSach, soLuong, gia, giaKhuyenMai, tacGia, namXuatBan, nhaXuatBan, anh, maTheLoai, moTa);
	}
	public int xoa(String maSach) {
		return sachDao.xoa(maSach);
	}
	public SachBEAN getSach(int maSach) {
		return sachDao.getSach(maSach);
	}
	public int capNhap(int maSach, String tenSach, int soLuong, long gia, long giaKhuyenMai, String tacGia,
			int namXuatBan, String nhaXuatBan, String anh, int maTheLoai, Date ngayNhap, Boolean trangThai,
			String moTa) {
		return sachDao.capNhap(maSach, tenSach, soLuong, gia, giaKhuyenMai, tacGia, namXuatBan, nhaXuatBan, anh, maTheLoai, ngayNhap, trangThai, moTa);
	}
	public  ArrayList<SachBEAN> getSachTheoTheLoai(int maTheLoai) {
		return sachDao.getSachTheoTheLoai(maTheLoai);
	}
	public  ArrayList<String> getNhaXuatBan(int maTheLoai){
		return sachDao.getNhaXuatBan(maTheLoai);
	}
	
	public  ArrayList<String> getTacGia(int maTheLoai){
		return sachDao.getTacGia(maTheLoai);
		
	}
	
	public ArrayList<SachBEAN> getSachTheoNhomTheLoai(int maNhomTheLoai){
		return sachDao.getSachTheoNhomTheLoai(maNhomTheLoai);
		
	}
	public  ArrayList<String> getNhaXuatBanNhomTheLoai(int maNhomTheLoai){
		return sachDao.getNhaXuatBanNhomTheLoai(maNhomTheLoai);
	}
	
	public  ArrayList<String> getTacGiaNhomTheLoai(int maNhomTheLoai){
		return sachDao.getTacGiaNhomTheLoai(maNhomTheLoai);
		
	}
	
	
	
	public ArrayList<SachBEAN> getSachTheoDanhMuc(int maDanhMuc){
		return sachDao.getSachTheoDanhMuc(maDanhMuc);
		
	}
	public  ArrayList<String> getNhaXuatBanDanhMuc(int maDanhMuc){
		return sachDao.getNhaXuatBanDanhMuc(maDanhMuc);
	}
	
	public  ArrayList<String> getTacGiaDanhMuc(int maDanhMuc){
		return sachDao.getTacGiaDanhMuc(maDanhMuc);
		
	}
	public int capNhatSL(int maSach, int soLuong) {
	    return sachDao.capNhatSL(maSach, soLuong);
	}
	
	public int capNhatTrangThai(int maSach, boolean trangThai) {
	    return sachDao.capNhatTrangThai(maSach, trangThai);
	}
}

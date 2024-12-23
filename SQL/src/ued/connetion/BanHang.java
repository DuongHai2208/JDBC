package ued.connetion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;


import FinalLab.model.Quanlybanhang;

public class BanHang {
//Câu1
public List<Quanlybanhang> getAllQuanlybanhang(){
	List<Quanlybanhang> listHanghoa = new ArrayList<>();//Tạo listHanghoa
	Connection con = null; 
	Statement stm = null;
	ResultSet rs = null;
	try {
		con = ConnectJDBc.getConnection();// ket noi mySQL
		if (con != null)
		{
			String sql = "SELECT * FROM dssv.dsbh;";
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				int maSP = rs.getInt(1);
				String tenSP = rs.getString(2);
				int soLuong = rs.getInt(3);
				float donGia = rs.getFloat(4);
				Quanlybanhang quanlybanhang = new Quanlybanhang(maSP, tenSP, soLuong, donGia);
				listHanghoa.add(quanlybanhang);
			}
			return listHanghoa;
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
	}

	// Câu 2
	public boolean ThemSP(int maSP,String tenSP,int soLuong,float donGia) {
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = ConnectJDBc.getConnection();
			if (con != null) {
				String sql = "INSERT INTO dssv.dsbh(MaSP, TenSP, SoLuong, DonGia) VALUES (?, ?, ?, ?);";
				stm = con.prepareStatement(sql);
				stm.setInt(1, maSP);
				stm.setString(2, tenSP);
				stm.setInt(3, soLuong);
				stm.setFloat(4, donGia);
				
				
				int result = stm.executeUpdate();
				if (result > 0) {
					return true ;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	//Câu 3 
	public boolean deleteSP(String TenSP) {
		Connection con = null;//kết nối với mySQL
		PreparedStatement stm = null;
		try {
			con = ConnectJDBc.getConnection();
			if(con != null)
				{
				String sql = "DELETE FROM dssv.dsbh WHERE TenSP = ? ";
				stm = con.prepareStatement(sql);
				stm.setString(1, TenSP);
				int result = stm.executeUpdate();
				if(result > 0) {
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}
	
	// Câu 4
	public boolean updateSP(int maSP, String tenSP, int soLuong, float donGia) {
		Connection con = null;//kết nối với mySQL
		PreparedStatement stm = null;
		try {
			con = ConnectJDBc.getConnection();
			if(con != null)  
				{
				String sql = "UPDATE dssv.dsbh SET TenSP = ?, SoLuong = ?, DonGia = ?   WHERE MaSP = ?;";
				stm = con.prepareStatement(sql);
				stm.setInt(4, maSP);
				stm.setString(1, tenSP);
				stm.setInt(2, soLuong);
				stm.setFloat(3, donGia);
				int result = stm.executeUpdate();
				if(result > 0) {
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}
	
	//Câu 5
	public List<Quanlybanhang> timSP(String tenSP){
		List<Quanlybanhang> listHanghoa = new ArrayList<>();// tạo 1 listHH 
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			con = ConnectJDBc.getConnection();//kết nối với mySQL
			if (con != null)  
			{
				String sql = "SELECT *FROM dssv.dsbh WHERE TenSP like ?";
				stm = con.prepareStatement(sql);
				stm.setString(1, '%'+tenSP+'%');
				
				rs = stm.executeQuery();
				
				while (rs.next()) {
					int maSP = rs.getInt(1);
					int soLuong = rs.getInt(3);
					float donGia = rs.getFloat(4);
					Quanlybanhang quanlybanhang = new Quanlybanhang(maSP,tenSP, soLuong, donGia);
					listHanghoa.add(quanlybanhang);
				}
				return listHanghoa;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	// Câu 6
	public List<Quanlybanhang> timSLSP(int soLuong){
		List<Quanlybanhang> listHanghoa = new ArrayList<>();
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			//kết nối với mySQL
			if (con != null) 
				{
				String sql = "SELECT *FROM dssv.dsbh WHERE SoLuong like ?";
				stm = con.prepareStatement(sql);
				stm.setInt(1, soLuong);
				
				rs = stm.executeQuery();
				
				while (rs.next()) {
					int maSP = rs.getInt(1);
					String tenSP = rs.getString(2) ;
					float donGia = rs.getFloat(4);
					Quanlybanhang quanlybanhang = new Quanlybanhang(maSP,tenSP, soLuong, donGia);
					listHanghoa.add(quanlybanhang);
				}
				return listHanghoa;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}

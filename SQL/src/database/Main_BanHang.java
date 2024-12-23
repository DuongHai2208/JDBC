package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import FinalLab.model.Quanlybanhang;
import ued.connetion.BanHang;

public class Main_BanHang {
	static List<Quanlybanhang> listHH = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	private static int soLuong;
	public static void main (String[] args) {
		int chon=0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("**********************************");
			System.out.println("Moi ban chon phuong thuc!!!");
			System.out.println("1. Xem Tat Ca Cac San Pham");
			System.out.println("2. Them San Pham");
			System.out.println("3. Xoa San Pham ");
			System.out.println("4. Cap Nhat Thong Tin Theo Ma San Pham");
			System.out.println("5. Tim San Pham Theo Ten");
			System.out.println("6. Tim San Pham Theo So Luong");
			System.out.println("***************************");
			System.out.println("Nhap vao muc ban muon: ");
			chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1: {
				Muc1();
				break;
			}
			case 2: {
				Muc2();
				break;
			}
			case 3: {
				Muc3();
				break;
			}
			case 4: {
				Muc4();
				break;
			}
			case 5: {
				Muc5();
				break;
			}
			case 6: {
				Muc6();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + chon);
			}
			
		} 
		while (chon<=6);
		
	}
	public static void Muc1() {
	BanHang hh = new BanHang(); 
	listHH = hh.getAllQuanlybanhang();
	for (Quanlybanhang quanlybanhang : listHH) 
	{
		System.out.println(quanlybanhang.getMaSP() +
							" - " + quanlybanhang.getTenSP()+
							" - " + quanlybanhang.getSoLuong()+
							" - " + quanlybanhang.getDonGia());
	}
	}
	
	public static void Muc2() {
		BanHang hh = new BanHang();
		System.out.println("Nhap Ma SP: ");
		int maSP = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap Ten SP: ");
		String tenSP = sc.nextLine();
		System.out.println("Nhap So Luong  : ");
		int soLuong = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap Don Gia: ");
		Float donGia = Float.parseFloat(sc.nextLine());
		
		boolean result = hh.ThemSP(maSP, tenSP, soLuong, donGia);
		if(result) {
			System.out.println("Chen du lieu thang cong!");
		} else {
			System.out.println("Chen du lieu that bai!");
		}
	}
	
	public static void Muc3() {
		BanHang hh = new BanHang();
		System.out.println("Nhap TenSP muon xoa: ");
		String TenSP = sc.nextLine();
		boolean result = hh.deleteSP(TenSP);
		if(result) {
			System.out.println("Xoa du lieu thang cong!");
		} else {
			System.out.println("Xoa du lieu that bai!");
		}
	}
	
	public static void Muc4() {
		BanHang hh = new BanHang();
		System.out.println("Nhap Ma SP de cap nhat: ");
		int maSP = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap Ten SP: ");
		String tenSP = sc.nextLine();
		System.out.println("Nhap So Luong  : ");
		int soLuong = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap Don Gia: ");
		Float donGia = Float.parseFloat(sc.nextLine());
		
		boolean result = hh.updateSP(maSP, tenSP, soLuong, donGia );
		if(result) {
			System.out.println("Sua du lieu thang cong!");
		} else {
			System.out.println("Sua du lieu that bai!");
		}
	}
	
	public static void Muc5() {
		BanHang hh = new BanHang();
		System.out.println("Vui long nhap Ten san pham can tim : ");
		String tenSP = sc.nextLine();
		listHH = hh.timSP(tenSP);
		for (Quanlybanhang quanlybanhang : listHH) 
		{
			System.out.println(quanlybanhang.getMaSP() +
								" - " + quanlybanhang.getTenSP()+
								" - " + quanlybanhang.getSoLuong()+
								" - " + quanlybanhang.getDonGia());
		}
	}
	//Goi Muc 6
	public static void Muc6() {
		BanHang hh = new BanHang();
		System.out.println("Vui long nhap So Luong SP can tim : ");
		int n = Integer.parseInt(sc.nextLine());
		listHH = hh.getAllQuanlybanhang();
		for (Quanlybanhang quanlybanhang : listHH) 
		{
			if(quanlybanhang.getSoLuong() >= n) {
			System.out.println(quanlybanhang.getMaSP() +
								" - " + quanlybanhang.getTenSP()+
								" - " + quanlybanhang.getSoLuong()+
								" - " + quanlybanhang.getDonGia());
		}
		}
	}
}


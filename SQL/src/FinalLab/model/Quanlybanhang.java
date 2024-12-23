package FinalLab.model;

public class Quanlybanhang {
 
 
 private int MaSP;
 private String TenSP;
 private int SoLuong;
 private float DonGia;
 
 public Quanlybanhang(int maSP, String tenSP, int soLuong, float donGia) {
  MaSP = maSP;
  TenSP = tenSP;
  SoLuong = soLuong;
  DonGia = donGia;
 }

 public int getMaSP() {
  return MaSP;
 }

 public void setMaSP(int maSP) {
  MaSP = maSP;
 }

 public String getTenSP() {
  return TenSP;
 }

 public void setTenSP(String tenSP) {
  TenSP = tenSP;
 }

 public int getSoLuong() {
  return SoLuong;
 }

 public void setSoLuong(int soLuong) {
  SoLuong = soLuong;
 }

 public float getDonGia() {
  return DonGia;
 }

 public void setDonGia(float donGia) {
  DonGia = donGia;
 }

 
 
 
}

package assign.fa;

import java.util.Scanner;

public class SinhVien {
	String MaSV, HoTen;
	int NamSinh;
	public double DiemKi1, DiemKi2, DiemTB;
	
	public SinhVien() {
		
	}
	
	public SinhVien(String MaSV, String HoTen, int NamSinh, double DiemKi1, double DiemKi2) {
		this.MaSV = MaSV;
		this.HoTen = HoTen;
		this.NamSinh = NamSinh;
		this.DiemKi1 = DiemKi1;
		this.DiemKi2 = DiemKi2;
	}
	
	//this is method which scans information
	public void NhapTT() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma so sinh vien: ");
		MaSV = sc.nextLine();
		System.out.println("Nhap ho ten sinh vien: ");
		HoTen = sc.nextLine();
		System.out.println("Nhap nam sinh: ");
		NamSinh = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap diem hoc ki 1: ");
		DiemKi1 = Double.parseDouble(sc.nextLine());
		System.out.println("Nhap diem hoc ki 2: ");
		DiemKi2 = Double.parseDouble(sc.nextLine());
		System.out.println("Nhap diem trung binh: ");
		DiemTB = Double.parseDouble(sc.nextLine());
	}
	
	//this is method which prints information.
	public void HienThi() {
		System.out.println("Ma so sinh vien: "+ MaSV);
		System.out.println("Ho va ten sinh vien: "+ HoTen);
		System.out.println("Nam sinh: "+ NamSinh);
		System.out.println("Diem hoc ki 1: "+ DiemKi1);
		System.out.println("Diem hoc ki 2: "+ DiemKi2);
		System.out.println("Diem trung binh: "+DiemTB);
	}
//	public static void main(String[] args) {
//		SinhVien sv = new SinhVien();
//		sv.NhapTT();
//		sv.HienThi();
//	}
}

package assign.fa;

import java.util.Scanner;
import java.sql.*;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
	static Connection conn = null;
    public static void main( String[] args )throws Exception
    {
    	String url = "jdbc:mysql://localhost:3306/";
    	String dbName = "assignment";
    	String driver = "com.mysql.jdbc.Driver";
    	String userName = "root";
    	String password = "";
    
    	try {
    		Class.forName(driver).newInstance();
        	conn = DriverManager.getConnection(url+dbName,userName,password);
        	System.out.println("Connected to the database");
    	} catch(Exception e) {
    		System.out.print("Loi");
    	}   	
    	String mysssv,myhoten,mynamsinh,mydk1,mydk2,mydtb;
    	PreparedStatement ps=conn.prepareStatement("insert into sv values(?,?,?,?,?,?)");
    	Statement stmt = conn.createStatement();
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	SinhVien DanhSachSV[] = null;
		int chon;
		System.out.println("1. Nhap vao n sinh vien trong danh sach.");
		System.out.println("2. Tim sinh vien co diem TB cao nhat.");
		System.out.println("3. Tim kiem sinh vien theo ma sinh vien.");
		System.out.println("4. Hien thi nhung sinh vien dat hoc bong.");
		System.out.println("5. Hien thi tat ca sinh vien ra man hinh.");
		System.out.println("6. Thoat.");
		
		do{			
			System.out.println("Moi ban nhap lua chon!");
			Scanner sc= new Scanner(System.in);
			chon = Integer.parseInt(sc.nextLine());
			
			if(chon<1 || chon>6) {
				System.out.println("Lua chon sai!!! Moi ban nhap lai.");
			}
			
			switch(chon) {
			
			//Nhap n sinh vien
			case 1:{
				int n;
				System.out.println("Nhap vao n sinh vien: ");
				n = Integer.parseInt(sc.nextLine());
				DanhSachSV = new SinhVien[n];
				for(int i=0;i<DanhSachSV.length;i++) {
					DanhSachSV[i] = new SinhVien();
					DanhSachSV[i].NhapTT();
					mysssv=br.readLine();
					myhoten=br.readLine();
					mynamsinh=br.readLine();
					mydk1=br.readLine();
					mydk2=br.readLine();
					mydtb=br.readLine();
					
					ps.setString(1,mysssv);
					ps.setString(2,myhoten);
					ps.setString(3,mynamsinh);
					ps.setString(4,mydk1);
					ps.setString(5,mydk2);
					ps.setString(6,mydtb);
					int l=ps.executeUpdate();					
					System.out.println(l+" records added");
					System.out.println("Do you want to continue: y/n");
					String s=br.readLine();
					if(s.startsWith("n")){
					break;
				}
					String sql = "SELECT * from sv";
					ResultSet rs = stmt.executeQuery(sql);
					System.out.println("The records are :");
					while (rs.next())
					{
						mysssv = rs.getString(1);
						myhoten=rs.getString(2);
						mynamsinh=rs.getString(3);
						mydk1=rs.getString(4);
						mydk2=rs.getString(5);
						mydtb=rs.getString(6);
					System.out.println(rs.getRow()+"-"+mysssv+"  "+myhoten+"  "+mynamsinh+"  "+mydk1+"  "+mydk2+"  "+mydtb);
					} //end while
					conn.close();
					}
				break;
			}
			
			//Tim kiem theo ma sinh vien
			case 3:{
				String ma;
				System.out.println("Nhap ma so sinh vien can tim kiem: ");
				ma = sc.nextLine();
				for(int i=0;i<DanhSachSV.length;i++) {
					if(ma.equals(DanhSachSV[i].MaSV)) {
						DanhSachSV[i].HienThi();
						break;
					}
				}
				break;
			}
			
			//Tim kiem sinh vien co diem tb cao nhat
			case 2:{
				int vt=0;
				double max = DanhSachSV[0].DiemTB;
				for(int i=0;i < DanhSachSV.length;i++) {
					if(DanhSachSV[i].DiemTB > max) {
						max = DanhSachSV[i].DiemTB;
						vt = i;
					}
				}
				System.out.println("-----Sinh vien co diem trung binh cao nhat.");
				DanhSachSV[vt].HienThi();
				break;
			}
			
			//Hien thi nhung sinh vie dat hoc bong.
			case 4:{
				for(int i=0; i<DanhSachSV.length;i++) {
					if(DanhSachSV[i].DiemTB >=8) {
						DanhSachSV[i].HienThi();	
						System.out.println("\n");
					}
				}
				break;
			}
			
			//Hien thi tat ca sinh vien ra man hinh
			case 5:{
				for(int i=0;i<DanhSachSV.length;i++) {
					DanhSachSV[i].HienThi();
				}
				break;
			}
			
			//Thoat.
			case 6:{
				break;
			}
			}
		}while(chon!=6);
	}
    

}


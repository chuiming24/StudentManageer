import java.sql.*;

import javax.swing.UIManager;


public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		
		
		
//		Class.forName("org.sqlite.JDBC");
//		Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");	
//		Statement stat = conn.createStatement();
//		stat.executeUpdate("create table tbl1(name varchar(20), salary int);");
//		stat.executeUpdate("insert into tbl1 values('ZhangSan',8000);");//��������  
//		stat.executeUpdate("insert into tbl1 values('LiSi',7800);");  
//		stat.executeUpdate("insert into tbl1 values('WangWu',5800);");  
//		stat.executeUpdate("insert into tbl1 values('ZhaoLiu',9100);");  
//		ResultSet rs = stat.executeQuery("select * from tbl1;");//��ѯ����  
//		while(rs.next()){//����ѯ�������ݴ�ӡ����  
//			System.out.print("name = "+ rs.getString("name")+" ");//������һ  
//			System.out.println("salary = "+ rs.getString("salary"));//�����Զ�  
//		}   
//		System.out.println("connection secuess!!");
//        rs.close();
//        conn.close(); //�������ݿ������ 
//		// TODO Auto-generated method stub
//		new AdminFrame(); 
//		DataBase_OP db = new DataBase_OP();
//		db.getConnection();
//		db.seachList();
//		db.tabbleIsExist("tbl1");
//		db.InitList();
//		new RegisterFrame();		
//		new AdminFrame();
//		new StudentFrame();
//		new TeacherFrame();

		DataBase_OP db = new DataBase_OP();
		db.getConnection();
		if(!db.tabbleIsExist("ADMIN")){
			db.InitList();
			new FirstFrame();
		}else{
			new LoginFrame();
		}
//		new AdminFrame();
		
	}

}

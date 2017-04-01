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
//		stat.executeUpdate("insert into tbl1 values('ZhangSan',8000);");//插入数据  
//		stat.executeUpdate("insert into tbl1 values('LiSi',7800);");  
//		stat.executeUpdate("insert into tbl1 values('WangWu',5800);");  
//		stat.executeUpdate("insert into tbl1 values('ZhaoLiu',9100);");  
//		ResultSet rs = stat.executeQuery("select * from tbl1;");//查询数据  
//		while(rs.next()){//将查询到的数据打印出来  
//			System.out.print("name = "+ rs.getString("name")+" ");//列属性一  
//			System.out.println("salary = "+ rs.getString("salary"));//列属性二  
//		}   
//		System.out.println("connection secuess!!");
//        rs.close();
//        conn.close(); //结束数据库的连接 
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

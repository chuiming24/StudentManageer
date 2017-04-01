import java.sql.*;
import java.util.Vector;
import java.awt.*;

import javax.swing.*;

public class DataBase_OP
{
   
    public DataBase_OP()
    {
        System.out.println("���ݿ��Ѿ�����������24kun����JAVA��ĩ��ҵ��");
   
    }
   
    public Connection getConnection()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            return conn;
        }
        catch(Exception e)
        {
            System.out.println("�������ݿ�ʧ��");
            e.printStackTrace();
            return null;
        }
       
    }
    
    
    
    
    public void InitList()
    {
        try
        {
            Connection conn = getConnection();
            Statement stat = conn.createStatement();
            if(!tabbleIsExist("STUDENT")){
            	stat.executeUpdate(	"CREATE TABLE STUDENT("
            						+"STU_ID INT PRIMARY KEY NOT NULL,"
            						+"PASSWORD TEXT NOT NULL,"
					            	+"NAME TEXT NOT NULL,"
					            	+"SEX TEXT NOT NULL,"
						            +"GRADE TEXT NOT NULL,"
								    +"SKILL TEXT NOT NULL,"
								    + "NOTE TEXT);");
            	System.out.println("the student table creating secuess!!");					    
            }    		
            if(!tabbleIsExist("ADMIN")){
            	stat.executeUpdate(	"CREATE TABLE ADMIN("
            						+"ADMIN_USER TEXT PRIMARY KEY NOT NULL,"
            						+"PASSWORD TEXT NOT NULL);");
            	System.out.println("the admin table creating secuess!!");					    
            }    
//��������Ա���            
//          stat.executeUpdate("INSERT INTO ADMIN (ADMIN_USER,PASSWORD)" +
//         				 "VALUES('admin32', 'admin');");
//����ѧ�����
//            stat.executeUpdate("INSERT INTO STUDENT (STU_ID, PASSWORD, NAME, SEX, GRADE, SKILL)" +
//    					 "VALUES(201602, '3dsdf', '����', '��', '��ϢѧԺ', 'Ƕ��ʽ161');"); 
//������ʦ���
//          stat.executeUpdate("INSERT INTO ADMIN (ADMIN_USER,PASSWORD)" +
//    					 "VALUES('admin32', 'admin');"); 
            
            stat.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    
    
    
  //��ѯָ�����ָ��ID�Ķ�Ӧ����
    public String getData(String list, String id, String dataKey){
    	String data = "";
    	try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM "+ list +" WHERE STU_ID = "+ id +";");
            if(rs.next()){
                data = rs.getString(dataKey);
            }
            System.out.println(data);
            rs.close();			
            stat.close();
            conn.close();						
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "��û�������ʾ", "", JOptionPane.PLAIN_MESSAGE);					
			e.printStackTrace();
		}
		return data;
    }

  //���ù���
    public void setNote(String list, String id, String data){
    	try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
            stat.executeUpdate("UPDATE "+ list +" SET STU_ID = '" + id + "'WHERE NOTE = '"+ data +"';"); 
			JOptionPane.showMessageDialog(null, "���淢���ɹ�", "", JOptionPane.PLAIN_MESSAGE);
            stat.close();
            conn.close();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "���淢��ʧ�ܣ����������ʽ�Ƿ���ȷ", "", JOptionPane.PLAIN_MESSAGE);
		}
    }    
    
    
//���ù���Ա���
    public void setAdmin(String name, String passWord){
    	try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			stat.executeUpdate("INSERT INTO ADMIN (ADMIN_USER,PASSWORD)" +
								"VALUES('"+ name +"', '"+ passWord +"');");
            stat.close();
            conn.close();						
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

  //�޸Ĺ���Ա����
    public void setAdminPassWord(String name, String text){
    	try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
            stat.executeUpdate("UPDATE ADMIN SET PASSWORD = '" + text + "'WHERE ADMIN_USER = '"+ name +"';"); 
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "", JOptionPane.PLAIN_MESSAGE);
            stat.close();
            conn.close();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ����������ʽ�Ƿ���ȷ", "", JOptionPane.PLAIN_MESSAGE);
		}
    } 
    
 //����ѧ����Ϣ    
    public void setStudent(String[] text){
    	try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
            stat.executeUpdate("INSERT INTO STUDENT (STU_ID, PASSWORD, NAME, SEX, GRADE, SKILL)" +
    					 "VALUES("+text[0]+", '"+text[1]+"', '"+text[2]+"', '"+text[3]+"', '"+text[4]+"', '"+text[5]+"');"); 

            stat.close();
            conn.close();	
			JOptionPane.showMessageDialog(null, "��ӳɹ�", "", JOptionPane.PLAIN_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "���ʧ�ܣ����������Ƿ���ȷ", "", JOptionPane.PLAIN_MESSAGE);
		}
    }
    
//ɾ��ѧ����Ϣ
    public void delStudent(String text){
    	try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM STUDENT WHERE STU_ID = "+ text +";"); 

            stat.close();
            conn.close();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "��������ȷ��ʽ��ѧ��", "", JOptionPane.PLAIN_MESSAGE);
		}
    }    
    
//�жϸñ��Ƿ����    
	public boolean tabbleIsExist(String tableName){
        boolean result = false;
        try {
        	Connection conn = getConnection();
        	Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select count(*) as c from sqlite_master where type ='table' and name ='"+tableName+"';");
            if(rs.next()){
                int count = (int)rs.getInt(1);
                if(count>0){
                        result = true;
                }
            }
            System.out.println(result);
            rs.close();
            stat.close();
            conn.close();	                
        } 
        catch (Exception e) 
        {
                // TODO: handle exception
        	System.out.println("�жϺ�������");
        }               
        return result;
	}  
	
//�ж�ָ�����е����������Ƿ���ȷ
	public boolean isAdmin(String list, String nameType, String name, String passWordType, String passWord)
    {
		boolean result = false;
        try
        {
            Connection conn = getConnection();
            Statement stat = conn.createStatement();
    		ResultSet rs = stat.executeQuery("select * from " + list + ";");//��ѯ����              
            int i = 0;
            while (rs.next())
            {
                i++;
                System.out.println("ID:" +i);
                if(name.equals(rs.getString(nameType)))
                {
                	if(passWord.equals(rs.getString(passWordType)))
                	{
                		result = true;
                	}
                }
//                System.out.println("ADMIN_USER: " + rs.getString("ADMIN_USER"));
//                System.out.println("PASSWORD: " + rs.getString("PASSWORD"));                
            }
           
            rs.close();
            stat.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("������������");
        }
		return result;
    }
   
   
   
//��ѯѧ����Ϣ   
    public JTable getTable(String list, String[] column)
    {
    	 Vector colum = new Vector();  
         Vector rows = new Vector();  
   
         // ��ѯ  
         try 
         {  
             Connection conn = getConnection();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM "+ list +";");//��ѯ����       
             ResultSetMetaData rsmd = rs.getMetaData();
             for (int i = 0; i < column.length; i++) {
            	 colum.addElement(column[i]);
             }
             
//             for (int i = 1; i <= rsmd.getColumnCount(); ++i)  
//            	 colum.addElement(rsmd.getColumnName(i));  
             while (rs.next()) {  
                 Vector currow = new Vector();  
                 for (int i = 1; i <= rsmd.getColumnCount(); ++i) {  
                     currow.addElement(rs.getString(i));  
                 }  
                 rows.addElement(currow);  
             }  
             JTable table = new JTable(rows, colum);  
             return table;
//             add(table, BorderLayout.CENTER);  
//             table.setVisible(true);  
//             table.setRowHeight(50);  
             // table.setFillsViewportHeight(true);  
   
         } catch (SQLException e1) {  
             // TODO Auto-generated catch block  
        	 e1.printStackTrace();  
         }
		return null;  
    }
}

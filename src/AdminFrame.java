import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminFrame extends JFrame{
	private String temp1 = new String();
	private String temp2 = new String();
	private String temp3 = new String();
	private String temp = new String();
	
	private JPanel contentPane;//创建面板
	DefaultTableModel update_table;
	JTable table;
	private MenuBar mBar;
	private Menu menu1;
	private MenuItem mi11;
	private MenuItem mi12;
	private MenuItem mi14;
	private MenuItem mi21;	
	private JToolBar TToolBar;
	private JButton jb11;
	private JButton jb12;
	private JButton jb13;
	private JButton jb21;
	private JButton jb14;	
	
	public AdminFrame()
	{
		
		//数据库初始化
		DataBase_OP db = new DataBase_OP();
		db.getConnection();		
		
		String[][] row=new String[20][10];
		String[] column={"学号","学生密码","名字","性别","系院","专业"};
//		DefaultTableModel tmd=new DefaultTableModel(row,column);
//		JTable table = new JTable(tmd);
		JTable table = db.getTable("STUDENT", column);
		JScrollPane JSP= new JScrollPane(table);
		add(JSP, BorderLayout.CENTER);  
		table.setVisible(true);  
		table.setRowHeight(50);  		
		
		//设置布局配置
		this.setTitle("管理员界面");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认退出
		this.setBounds(100, 100, 800, 750);//设置窗体的大小 
		this.contentPane = new JPanel();//初始化面板  
		this.contentPane.setLayout(null);//设置布局NULL
	
		//设置控件内容	
		mBar = new MenuBar();
		menu1 = new Menu("文件");
		mi11 = new MenuItem("学生信息录入");
		mi12 = new MenuItem("学生信息删除");
		mi21 = new MenuItem("修改管理员密码");
		mi14 = new MenuItem("退出");
		TToolBar = new JToolBar();
		jb11 = new JButton("学生信息录入");
		jb12 = new JButton("学生信息删除");
		jb13 = new JButton("发布提示");
		jb21 = new JButton("修改管理员密码");
		jb14 = new JButton("退出");
		
		//设置控件属性	
		
		//添加控件		
		setMenuBar(mBar);
		mBar.add(menu1);
		menu1.add(mi11);
		menu1.add(mi12);
		menu1.add(mi21);
		TToolBar.addSeparator();
		menu1.add(mi14);
		this.add(TToolBar,BorderLayout.NORTH);
		TToolBar.add(jb11);
		TToolBar.add(jb12);
		TToolBar.add(jb13);
		TToolBar.add(jb21);
		TToolBar.add(jb14);		
		
		//设置控件事件
		mi11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new RegisterFrame();
				dispose();
			}
		});
		
		mi12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				temp = JOptionPane.showInputDialog("请输入要删除的学号");
				DataBase_OP db = new DataBase_OP();
				db.getConnection();	
				db.delStudent(temp);		
				new AdminFrame();
			}
		});
		
		mi14.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new LoginFrame();
				dispose();
			}
		});
		
		mi21.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DataBase_OP db = new DataBase_OP();
				db.getConnection();	
				// TODO Auto-generated method stub
				temp1 = JOptionPane.showInputDialog("请输入当前管理员帐号");
				temp2 = JOptionPane.showInputDialog("请输入管理员密码");
				temp3 = JOptionPane.showInputDialog("请再次输入管理员密码");
				if(temp2.equals(temp3) && db.isAdmin("ADMIN", "ADMIN_USER", temp1, "PASSWORD", temp2)){
					temp = JOptionPane.showInputDialog("身份确认正确，请输入新的密码：");
					db.setAdminPassWord(temp1, temp);
				}else{
					JOptionPane.showMessageDialog(null, "认证失败，请确认管理员账户以及密码正确", "", JOptionPane.PLAIN_MESSAGE);
										
				}				
			}
		});

		jb11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new RegisterFrame();
				dispose();
			}
		});		
		
		jb12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				temp = JOptionPane.showInputDialog("请输入要删除的学号");
				DataBase_OP db = new DataBase_OP();
				db.getConnection();	
				db.delStudent(temp);		
				new AdminFrame();
			}
		});		
		
		jb14.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new LoginFrame();
				dispose();
			}
		});	
		
		jb21.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DataBase_OP db = new DataBase_OP();
				db.getConnection();	
				// TODO Auto-generated method stub
				temp1 = JOptionPane.showInputDialog("请输入当前管理员帐号");
				temp2 = JOptionPane.showInputDialog("请输入管理员密码");
				temp3 = JOptionPane.showInputDialog("请再次输入管理员密码");
				if(temp2.equals(temp3) && db.isAdmin("ADMIN", "ADMIN_USER", temp1, "PASSWORD", temp2)){
					temp = JOptionPane.showInputDialog("身份确认正确，请输入新的密码：");
					db.setAdminPassWord(temp1, temp);
				}else{
					JOptionPane.showMessageDialog(null, "认证失败，请确认管理员账户以及密码正确", "", JOptionPane.PLAIN_MESSAGE);
										
				}				
			}
		});	
		
		jb13.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DataBase_OP db = new DataBase_OP();
				db.getConnection();	
				// TODO Auto-generated method stub
				temp1 = JOptionPane.showInputDialog("请输入要对其发布提示的同学的学号");				
				temp2 = JOptionPane.showInputDialog("请输入要发布的提示：");
				db.setNote("STUDENT", temp1, temp2);
			}
		});
		//设置窗口界面
		
		this.setLocationRelativeTo(null);
		this.setResizable(true);
//		this.add(this.contentPane);  
	    this.setVisible(true);  		
	}
}

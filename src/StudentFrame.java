import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class StudentFrame extends JFrame{
	
	
	private JPanel contentPane;//创建面板
	
	private MenuBar mBar;
	private Menu menu1;
	private MenuItem mi12;
	private MenuItem mi14;
	private JToolBar TToolBar;
	private JButton jb12;
	private JButton jb14;
	
	private JLabel welcome;
	private JLabel note;
	
	public StudentFrame(String stuID)
	{
		//数据库初始化		
		DataBase_OP db = new DataBase_OP();
		db.getConnection();
		
		//设置布局配置
		this.setTitle("学生界面界面");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认退出
		this.setBounds(100, 100, 600, 500);//设置窗体的大小 
		this.contentPane = new JPanel();//初始化面板  
		this.contentPane.setLayout(null);//设置布局NULL
		
		//设置控件内容	
		mBar = new MenuBar();
		menu1 = new Menu("文件");
		mi12 = new MenuItem("个人信息修改");
		mi14 = new MenuItem("退出");
		TToolBar = new JToolBar();
		jb12 = new JButton("个人信息查看");
		jb14 = new JButton("退出");
		
		welcome = new JLabel("欢迎光临！"+ db.getData("STUDENT", stuID, "NAME"));
		if(db.getData("STUDENT", stuID, "NOTE" )!= ""){
			note = new JLabel(db.getData("STUDENT", stuID, "NOTE"));
		}
		
		//设置控件属性	
		welcome.setForeground(Color.pink);
		welcome.setFont(new java.awt.Font("楷体",1,25));
		note.setForeground(Color.black);
		note.setFont(new java.awt.Font("黑体",1,25));		
		
		//添加控件
		this.contentPane.add(welcome);
		this.contentPane.add(note);
		mBar.add(menu1);
		menu1.add(mi12);
		TToolBar.addSeparator();
		menu1.add(mi14);
		setMenuBar(mBar);
		TToolBar.add(jb12);
		TToolBar.add(jb14);		
		this.add(TToolBar,BorderLayout.NORTH);		
		
		//设置控件位置
		this.welcome.setBounds(130, 25, 500, 30);
		this.note.setBounds(130, 100, 500, 30);
		
		//设置控件事件
		
		mi14.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new LoginFrame();
				dispose();
			}
		});
		
		jb14.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new LoginFrame();
				dispose();
			}
		});
		
		//设置窗口界面
		
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.add(this.contentPane);  
	    this.setVisible(true); 	
	}
}

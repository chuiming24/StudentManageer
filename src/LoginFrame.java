import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class LoginFrame extends JFrame {
	private JPanel wPane;//创建面板
	private JPanel contentPane;//创建面板
	
	private JPanel allLoginText;
	private JPanel allLoginBtn;
	
	private JLabel welcome;
	private JLabel loginManLabel;
	private Choice whoMan;
	private JLabel namLabele;
	private TextField name;
	private JLabel passwordLabel;
	private TextField password;
	private JButton loginBtn;
	private JButton resBtn;
	private JButton retBtn;
	
	private String theMan;

	
	public LoginFrame()
	{
		theMan = "ERROR";
		//设置布局配置

		
		dispose();
		setUndecorated(true);
		setVisible(true);
		
		this.setTitle("学生信息管理系统登陆界面");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认退出
		this.setBounds(100, 100, 500, 280);//设置窗体的大小 
		
		this.wPane = new JPanel();
		this.wPane.setLayout(null);//设置布局NULL
		
		this.contentPane = new JPanel();//初始化面板  
		this.contentPane.setLayout(null);//设置布局NULL
		
		this.allLoginText = new JPanel();
		this.allLoginText.setLayout(new GridLayout(3, 2, 10, 15));
		
		this.allLoginBtn = new JPanel();//初始化面板  
		this.allLoginBtn.setLayout(new GridLayout(1, 3, 50, 5));
		
		this.wPane.add(contentPane);
		this.contentPane.setBounds(10, 10, 480, 260);
		
		this.contentPane.add(allLoginText);
		this.allLoginText.setBounds(100, 70, 300, 100);
		
		
		this.contentPane.add(allLoginBtn);		
		this.allLoginBtn.setBounds(80, 200, 340, 30);
		
					
		//设置控件内容
		welcome = new JLabel("欢迎使用学生信息管理系统");
		loginManLabel = new JLabel("登陆人员");
		whoMan = new Choice();
		whoMan.add("");
		whoMan.add("管理员");
//		whoMan.add("老师");
		whoMan.add("学生");
		namLabele = new JLabel("用户名");
		name = new TextField(30);
		passwordLabel = new JLabel("密码");
		password = new TextField(30);
		loginBtn = new JButton("登陆");
		resBtn = new JButton("重置");
		retBtn = new JButton("退出");
		
		//设置控件属性
		welcome.setForeground(Color.pink);
		welcome.setFont(new java.awt.Font("楷体",1,18));
		password.setEchoChar('*');
		wPane.setBackground(Color.ORANGE);
		
		//添加控件
		this.contentPane.add(welcome);
		
		this.allLoginText.add(loginManLabel);
		this.allLoginText.add(whoMan);
		this.allLoginText.add(namLabele);
		this.allLoginText.add(name);
		this.allLoginText.add(passwordLabel);
		this.allLoginText.add(password);
		
		this.allLoginBtn.add(loginBtn);
		this.allLoginBtn.add(resBtn);	
		this.allLoginBtn.add(retBtn);		
		
		//设置控件位置
		this.welcome.setBounds(130, 25, 250, 30);
		
		//设置控件事件
		
		
		whoMan.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				theMan = (String)e.getItem();
			}
		});
		
		
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DataBase_OP db = new DataBase_OP();
				db.getConnection();
				// TODO Auto-generated method stub
				switch (theMan) {
				case "管理员":
					if(db.isAdmin("ADMIN", "ADMIN_USER", name.getText(), "PASSWORD", password.getText())){
						new AdminFrame();
						dispose();							
					}else{
						JOptionPane.showMessageDialog(null, "管理员账户或密码输入错误", "错误", JOptionPane.PLAIN_MESSAGE);
					}
					
					break;
				case "老师":
					new TeacherFrame();
					dispose();					
					break;
				case "学生":
					if(db.isAdmin("STUDENT", "STU_ID", name.getText(), "PASSWORD", password.getText())){
						new StudentFrame(name.getText());
						dispose();							
					}else{
						JOptionPane.showMessageDialog(null, "学生账户或密码输入错误", "错误", JOptionPane.PLAIN_MESSAGE);
					}			
					break;
				default:
					JOptionPane.showMessageDialog(null, "请选择正确的用户类型", "错误", JOptionPane.PLAIN_MESSAGE);					
					break;
				}
			}
		});
		
		resBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				name.setText("\0");
				password.setText("\0");
			}
		});
		
		retBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		//设置窗口界面

		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(this.wPane);  
	    this.setVisible(true);  		
	}


}

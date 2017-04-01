import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RegisterFrame extends JFrame{
	
	//用户名，密码，再次输入密码，姓名，性别，电子邮箱，家庭住址，年龄，系
	String[] resText = {"学号","密码","姓名", "性别", "系院", "专业"};
	String[] setRes = new String[6];  
	
	private JPanel contentPane;//创建面板

	private JPanel allRegisterLable;
	private JPanel allRegisterBtn;
	
	private JLabel title;	
	private JButton yesBtn;
	private JButton resBtn;
	private JButton retBtn;
	private JLabel[] resLable;
	private TextField[] setResText;
	
	
	public RegisterFrame()
	{
		//设置布局配置
		this.setTitle("学生信息录入");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认退出
		this.setBounds(100, 100, 500, 550);//设置窗体的大小 
		this.contentPane = new JPanel();//初始化面板  


		
		this.allRegisterLable = new JPanel();
		this.allRegisterLable.setLayout(new GridLayout(6, 2, 5, 30));		
		this.allRegisterBtn = new JPanel();//初始化面板  
		this.allRegisterBtn.setLayout(new GridLayout(1, 3, 50, 5));

		
		
		
		//设置控件内容
		title = new JLabel("学生信息录入");
		
		setResText = new TextField[6];
		resLable = new JLabel[6];
		for(int i = 0; i < 6; i++){
			setResText[i] = new TextField(30);
			resLable[i] = new JLabel(resText[i]);
		}
		
		yesBtn = new JButton("确定");
		resBtn = new JButton("重置");
		retBtn = new JButton("返回");
		
		
		//设置控件属性
		title.setForeground(Color.pink);
		title.setFont(new java.awt.Font("宋体",1,25));
		
		//添加控件
		this.contentPane.add(title);
		
		this.contentPane.add(allRegisterLable);	
		for(int i = 0; i < 6; i++){
			this.allRegisterLable.add(resLable[i]);
			this.allRegisterLable.add(setResText[i]);
		}
		
		this.contentPane.add(allRegisterBtn);		
		this.allRegisterBtn.add(yesBtn);
		this.allRegisterBtn.add(resBtn);	
		this.allRegisterBtn.add(retBtn);
		
		//设置控件位置
		this.title.setBounds(170, 30, 340, 30);
		this.allRegisterLable.setBounds(80, 100, 340, 300);
		this.allRegisterBtn.setBounds(80, 450, 340, 30);
		
		//设置控件事件http://linux.linuxidc.com
	
		yesBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < 6; i++) {
					setRes[i] = setResText[i].getText();
				}								
				DataBase_OP db = new DataBase_OP();
				db.getConnection();	
				db.setStudent(setRes);
				new AdminFrame();
				dispose();
			}
		});
		
		resBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (int i = 0; i < 6; i++) {
					setResText[i].setText("\0");
				}
			}
		});
		
		retBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminFrame();
				dispose();
			}
		});
		
		//设置窗口界面

		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(this.contentPane);  
	    this.setVisible(true);  		
	}
}

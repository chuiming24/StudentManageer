import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FirstFrame extends JFrame{
	private JPanel contentPane;//创建面板
	
	private JPanel allTxetLable;
	private JPanel allBtn;	
	
	private JLabel nameLabel, passWordLabel;
	private TextField nameText, passWordText;
	private JButton yesBtn, exitBtn;
	
	
	public FirstFrame()
	{
		//初始化
		JOptionPane.showMessageDialog(null, "初次使用，请设置管理员帐号以及密码：", "欢迎使用", JOptionPane.PLAIN_MESSAGE);
		
		//设置布局配置
		this.setTitle("请设置管理员账户与密码");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 300, 250);//设置窗体的大小 
		
		this.contentPane = new JPanel();//初始化面板  
		this.allTxetLable = new JPanel();//初始化面板
		this.allTxetLable.setLayout(new GridLayout(2, 2, 10, 40));
		this.allBtn = new JPanel();//初始化面板
		this.allBtn.setLayout(new GridLayout(1, 2, 5, 30));
		
		//设置控件内容
		nameLabel = new JLabel("管理员帐号");
		passWordLabel = new JLabel("管理员密码");
		nameText = new TextField(30);
		passWordText = new TextField(30);
		yesBtn = new JButton("确定");
		exitBtn = new JButton("退出");
		
		//设置控件属性
//		passWordText.setEchoChar('*');
		
		//添加控件
		this.allTxetLable.add(nameLabel);
		this.allTxetLable.add(nameText);
		this.allTxetLable.add(passWordLabel);
		this.allTxetLable.add(passWordText);
		this.add(allTxetLable);
		
		this.allBtn.add(yesBtn);
		this.allBtn.add(exitBtn);
		this.add(allBtn);
		
		
		
		//设置控件位置
		this.allTxetLable.setBounds(20, 20, 250, 80);
		this.allBtn.setBounds(20, 150, 250, 30);
		
		
		
		//设置控件事件
		
		yesBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DataBase_OP db = new DataBase_OP();
				db.getConnection();		
				db.setAdmin(nameText.getText(), passWordText.getText());
				new LoginFrame();
				dispose();
			}
		});
		
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		//设置窗口界面
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(this.contentPane);  
	    this.setVisible(true); 		
		
	}
}

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class TeacherFrame extends JFrame{
	
	
	private JPanel contentPane;//创建面板
	
	private MenuBar mBar;
	private Menu menu1;
	private MenuItem mi11;
	private MenuItem mi12;
	private MenuItem mi14;
	private JToolBar TToolBar;
	private JButton jb11;
	private JButton jb12;
	private JButton jb14;
	
	
	public TeacherFrame()
	{
		//设置布局配置
		this.setTitle("老师界面界面");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认退出
		this.setBounds(100, 100, 800, 750);//设置窗体的大小 
		this.contentPane = new JPanel();//初始化面板  
		this.contentPane.setLayout(null);//设置布局NULL
	
		//设置控件内容	
		mBar = new MenuBar();
		menu1 = new Menu("文件");
		mi11 = new MenuItem("学生成绩录入");
		mi12 = new MenuItem("个人信息修改/删除");
		mi14 = new MenuItem("退出");
		TToolBar = new JToolBar();
		jb11 = new JButton("课程信息查询");
		jb12 = new JButton("个人信息修改/删除");
		jb14 = new JButton("退出");
		
		//设置控件属性	
		
		//添加控件		
		setMenuBar(mBar);
		mBar.add(menu1);
		menu1.add(mi11);
		menu1.add(mi12);
		TToolBar.addSeparator();
		menu1.add(mi14);
		this.add(TToolBar,BorderLayout.NORTH);
		TToolBar.add(jb11);
		TToolBar.add(jb12);
		TToolBar.add(jb14);		
		
		//设置控件事件
		mi14.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		jb14.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});		
		//设置窗口界面
		
		this.setLocationRelativeTo(null);
		this.setResizable(true);
//		this.add(this.contentPane);  
	    this.setVisible(true); 	
	}
}

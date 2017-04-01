import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class StudentFrame extends JFrame{
	
	
	private JPanel contentPane;//�������
	
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
		//���ݿ��ʼ��		
		DataBase_OP db = new DataBase_OP();
		db.getConnection();
		
		//���ò�������
		this.setTitle("ѧ���������");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Ĭ���˳�
		this.setBounds(100, 100, 600, 500);//���ô���Ĵ�С 
		this.contentPane = new JPanel();//��ʼ�����  
		this.contentPane.setLayout(null);//���ò���NULL
		
		//���ÿؼ�����	
		mBar = new MenuBar();
		menu1 = new Menu("�ļ�");
		mi12 = new MenuItem("������Ϣ�޸�");
		mi14 = new MenuItem("�˳�");
		TToolBar = new JToolBar();
		jb12 = new JButton("������Ϣ�鿴");
		jb14 = new JButton("�˳�");
		
		welcome = new JLabel("��ӭ���٣�"+ db.getData("STUDENT", stuID, "NAME"));
		if(db.getData("STUDENT", stuID, "NOTE" )!= ""){
			note = new JLabel(db.getData("STUDENT", stuID, "NOTE"));
		}
		
		//���ÿؼ�����	
		welcome.setForeground(Color.pink);
		welcome.setFont(new java.awt.Font("����",1,25));
		note.setForeground(Color.black);
		note.setFont(new java.awt.Font("����",1,25));		
		
		//��ӿؼ�
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
		
		//���ÿؼ�λ��
		this.welcome.setBounds(130, 25, 500, 30);
		this.note.setBounds(130, 100, 500, 30);
		
		//���ÿؼ��¼�
		
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
		
		//���ô��ڽ���
		
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.add(this.contentPane);  
	    this.setVisible(true); 	
	}
}

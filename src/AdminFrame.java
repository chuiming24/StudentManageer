import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminFrame extends JFrame{
	private String temp1 = new String();
	private String temp2 = new String();
	private String temp3 = new String();
	private String temp = new String();
	
	private JPanel contentPane;//�������
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
		
		//���ݿ��ʼ��
		DataBase_OP db = new DataBase_OP();
		db.getConnection();		
		
		String[][] row=new String[20][10];
		String[] column={"ѧ��","ѧ������","����","�Ա�","ϵԺ","רҵ"};
//		DefaultTableModel tmd=new DefaultTableModel(row,column);
//		JTable table = new JTable(tmd);
		JTable table = db.getTable("STUDENT", column);
		JScrollPane JSP= new JScrollPane(table);
		add(JSP, BorderLayout.CENTER);  
		table.setVisible(true);  
		table.setRowHeight(50);  		
		
		//���ò�������
		this.setTitle("����Ա����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Ĭ���˳�
		this.setBounds(100, 100, 800, 750);//���ô���Ĵ�С 
		this.contentPane = new JPanel();//��ʼ�����  
		this.contentPane.setLayout(null);//���ò���NULL
	
		//���ÿؼ�����	
		mBar = new MenuBar();
		menu1 = new Menu("�ļ�");
		mi11 = new MenuItem("ѧ����Ϣ¼��");
		mi12 = new MenuItem("ѧ����Ϣɾ��");
		mi21 = new MenuItem("�޸Ĺ���Ա����");
		mi14 = new MenuItem("�˳�");
		TToolBar = new JToolBar();
		jb11 = new JButton("ѧ����Ϣ¼��");
		jb12 = new JButton("ѧ����Ϣɾ��");
		jb13 = new JButton("������ʾ");
		jb21 = new JButton("�޸Ĺ���Ա����");
		jb14 = new JButton("�˳�");
		
		//���ÿؼ�����	
		
		//��ӿؼ�		
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
		
		//���ÿؼ��¼�
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
				temp = JOptionPane.showInputDialog("������Ҫɾ����ѧ��");
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
				temp1 = JOptionPane.showInputDialog("�����뵱ǰ����Ա�ʺ�");
				temp2 = JOptionPane.showInputDialog("���������Ա����");
				temp3 = JOptionPane.showInputDialog("���ٴ��������Ա����");
				if(temp2.equals(temp3) && db.isAdmin("ADMIN", "ADMIN_USER", temp1, "PASSWORD", temp2)){
					temp = JOptionPane.showInputDialog("���ȷ����ȷ���������µ����룺");
					db.setAdminPassWord(temp1, temp);
				}else{
					JOptionPane.showMessageDialog(null, "��֤ʧ�ܣ���ȷ�Ϲ���Ա�˻��Լ�������ȷ", "", JOptionPane.PLAIN_MESSAGE);
										
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
				temp = JOptionPane.showInputDialog("������Ҫɾ����ѧ��");
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
				temp1 = JOptionPane.showInputDialog("�����뵱ǰ����Ա�ʺ�");
				temp2 = JOptionPane.showInputDialog("���������Ա����");
				temp3 = JOptionPane.showInputDialog("���ٴ��������Ա����");
				if(temp2.equals(temp3) && db.isAdmin("ADMIN", "ADMIN_USER", temp1, "PASSWORD", temp2)){
					temp = JOptionPane.showInputDialog("���ȷ����ȷ���������µ����룺");
					db.setAdminPassWord(temp1, temp);
				}else{
					JOptionPane.showMessageDialog(null, "��֤ʧ�ܣ���ȷ�Ϲ���Ա�˻��Լ�������ȷ", "", JOptionPane.PLAIN_MESSAGE);
										
				}				
			}
		});	
		
		jb13.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DataBase_OP db = new DataBase_OP();
				db.getConnection();	
				// TODO Auto-generated method stub
				temp1 = JOptionPane.showInputDialog("������Ҫ���䷢����ʾ��ͬѧ��ѧ��");				
				temp2 = JOptionPane.showInputDialog("������Ҫ��������ʾ��");
				db.setNote("STUDENT", temp1, temp2);
			}
		});
		//���ô��ڽ���
		
		this.setLocationRelativeTo(null);
		this.setResizable(true);
//		this.add(this.contentPane);  
	    this.setVisible(true);  		
	}
}

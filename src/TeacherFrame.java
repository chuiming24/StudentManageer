import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class TeacherFrame extends JFrame{
	
	
	private JPanel contentPane;//�������
	
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
		//���ò�������
		this.setTitle("��ʦ�������");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Ĭ���˳�
		this.setBounds(100, 100, 800, 750);//���ô���Ĵ�С 
		this.contentPane = new JPanel();//��ʼ�����  
		this.contentPane.setLayout(null);//���ò���NULL
	
		//���ÿؼ�����	
		mBar = new MenuBar();
		menu1 = new Menu("�ļ�");
		mi11 = new MenuItem("ѧ���ɼ�¼��");
		mi12 = new MenuItem("������Ϣ�޸�/ɾ��");
		mi14 = new MenuItem("�˳�");
		TToolBar = new JToolBar();
		jb11 = new JButton("�γ���Ϣ��ѯ");
		jb12 = new JButton("������Ϣ�޸�/ɾ��");
		jb14 = new JButton("�˳�");
		
		//���ÿؼ�����	
		
		//��ӿؼ�		
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
		
		//���ÿؼ��¼�
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
		//���ô��ڽ���
		
		this.setLocationRelativeTo(null);
		this.setResizable(true);
//		this.add(this.contentPane);  
	    this.setVisible(true); 	
	}
}

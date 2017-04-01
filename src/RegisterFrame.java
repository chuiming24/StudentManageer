import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RegisterFrame extends JFrame{
	
	//�û��������룬�ٴ��������룬�������Ա𣬵������䣬��ͥסַ�����䣬ϵ
	String[] resText = {"ѧ��","����","����", "�Ա�", "ϵԺ", "רҵ"};
	String[] setRes = new String[6];  
	
	private JPanel contentPane;//�������

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
		//���ò�������
		this.setTitle("ѧ����Ϣ¼��");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Ĭ���˳�
		this.setBounds(100, 100, 500, 550);//���ô���Ĵ�С 
		this.contentPane = new JPanel();//��ʼ�����  


		
		this.allRegisterLable = new JPanel();
		this.allRegisterLable.setLayout(new GridLayout(6, 2, 5, 30));		
		this.allRegisterBtn = new JPanel();//��ʼ�����  
		this.allRegisterBtn.setLayout(new GridLayout(1, 3, 50, 5));

		
		
		
		//���ÿؼ�����
		title = new JLabel("ѧ����Ϣ¼��");
		
		setResText = new TextField[6];
		resLable = new JLabel[6];
		for(int i = 0; i < 6; i++){
			setResText[i] = new TextField(30);
			resLable[i] = new JLabel(resText[i]);
		}
		
		yesBtn = new JButton("ȷ��");
		resBtn = new JButton("����");
		retBtn = new JButton("����");
		
		
		//���ÿؼ�����
		title.setForeground(Color.pink);
		title.setFont(new java.awt.Font("����",1,25));
		
		//��ӿؼ�
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
		
		//���ÿؼ�λ��
		this.title.setBounds(170, 30, 340, 30);
		this.allRegisterLable.setBounds(80, 100, 340, 300);
		this.allRegisterBtn.setBounds(80, 450, 340, 30);
		
		//���ÿؼ��¼�http://linux.linuxidc.com
	
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
		
		//���ô��ڽ���

		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(this.contentPane);  
	    this.setVisible(true);  		
	}
}

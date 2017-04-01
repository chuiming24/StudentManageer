import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class LoginFrame extends JFrame {
	private JPanel wPane;//�������
	private JPanel contentPane;//�������
	
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
		//���ò�������

		
		dispose();
		setUndecorated(true);
		setVisible(true);
		
		this.setTitle("ѧ����Ϣ����ϵͳ��½����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Ĭ���˳�
		this.setBounds(100, 100, 500, 280);//���ô���Ĵ�С 
		
		this.wPane = new JPanel();
		this.wPane.setLayout(null);//���ò���NULL
		
		this.contentPane = new JPanel();//��ʼ�����  
		this.contentPane.setLayout(null);//���ò���NULL
		
		this.allLoginText = new JPanel();
		this.allLoginText.setLayout(new GridLayout(3, 2, 10, 15));
		
		this.allLoginBtn = new JPanel();//��ʼ�����  
		this.allLoginBtn.setLayout(new GridLayout(1, 3, 50, 5));
		
		this.wPane.add(contentPane);
		this.contentPane.setBounds(10, 10, 480, 260);
		
		this.contentPane.add(allLoginText);
		this.allLoginText.setBounds(100, 70, 300, 100);
		
		
		this.contentPane.add(allLoginBtn);		
		this.allLoginBtn.setBounds(80, 200, 340, 30);
		
					
		//���ÿؼ�����
		welcome = new JLabel("��ӭʹ��ѧ����Ϣ����ϵͳ");
		loginManLabel = new JLabel("��½��Ա");
		whoMan = new Choice();
		whoMan.add("");
		whoMan.add("����Ա");
//		whoMan.add("��ʦ");
		whoMan.add("ѧ��");
		namLabele = new JLabel("�û���");
		name = new TextField(30);
		passwordLabel = new JLabel("����");
		password = new TextField(30);
		loginBtn = new JButton("��½");
		resBtn = new JButton("����");
		retBtn = new JButton("�˳�");
		
		//���ÿؼ�����
		welcome.setForeground(Color.pink);
		welcome.setFont(new java.awt.Font("����",1,18));
		password.setEchoChar('*');
		wPane.setBackground(Color.ORANGE);
		
		//��ӿؼ�
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
		
		//���ÿؼ�λ��
		this.welcome.setBounds(130, 25, 250, 30);
		
		//���ÿؼ��¼�
		
		
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
				case "����Ա":
					if(db.isAdmin("ADMIN", "ADMIN_USER", name.getText(), "PASSWORD", password.getText())){
						new AdminFrame();
						dispose();							
					}else{
						JOptionPane.showMessageDialog(null, "����Ա�˻��������������", "����", JOptionPane.PLAIN_MESSAGE);
					}
					
					break;
				case "��ʦ":
					new TeacherFrame();
					dispose();					
					break;
				case "ѧ��":
					if(db.isAdmin("STUDENT", "STU_ID", name.getText(), "PASSWORD", password.getText())){
						new StudentFrame(name.getText());
						dispose();							
					}else{
						JOptionPane.showMessageDialog(null, "ѧ���˻��������������", "����", JOptionPane.PLAIN_MESSAGE);
					}			
					break;
				default:
					JOptionPane.showMessageDialog(null, "��ѡ����ȷ���û�����", "����", JOptionPane.PLAIN_MESSAGE);					
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
		
		//���ô��ڽ���

		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(this.wPane);  
	    this.setVisible(true);  		
	}


}

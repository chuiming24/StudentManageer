import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FirstFrame extends JFrame{
	private JPanel contentPane;//�������
	
	private JPanel allTxetLable;
	private JPanel allBtn;	
	
	private JLabel nameLabel, passWordLabel;
	private TextField nameText, passWordText;
	private JButton yesBtn, exitBtn;
	
	
	public FirstFrame()
	{
		//��ʼ��
		JOptionPane.showMessageDialog(null, "����ʹ�ã������ù���Ա�ʺ��Լ����룺", "��ӭʹ��", JOptionPane.PLAIN_MESSAGE);
		
		//���ò�������
		this.setTitle("�����ù���Ա�˻�������");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 300, 250);//���ô���Ĵ�С 
		
		this.contentPane = new JPanel();//��ʼ�����  
		this.allTxetLable = new JPanel();//��ʼ�����
		this.allTxetLable.setLayout(new GridLayout(2, 2, 10, 40));
		this.allBtn = new JPanel();//��ʼ�����
		this.allBtn.setLayout(new GridLayout(1, 2, 5, 30));
		
		//���ÿؼ�����
		nameLabel = new JLabel("����Ա�ʺ�");
		passWordLabel = new JLabel("����Ա����");
		nameText = new TextField(30);
		passWordText = new TextField(30);
		yesBtn = new JButton("ȷ��");
		exitBtn = new JButton("�˳�");
		
		//���ÿؼ�����
//		passWordText.setEchoChar('*');
		
		//��ӿؼ�
		this.allTxetLable.add(nameLabel);
		this.allTxetLable.add(nameText);
		this.allTxetLable.add(passWordLabel);
		this.allTxetLable.add(passWordText);
		this.add(allTxetLable);
		
		this.allBtn.add(yesBtn);
		this.allBtn.add(exitBtn);
		this.add(allBtn);
		
		
		
		//���ÿؼ�λ��
		this.allTxetLable.setBounds(20, 20, 250, 80);
		this.allBtn.setBounds(20, 150, 250, 30);
		
		
		
		//���ÿؼ��¼�
		
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
		
		//���ô��ڽ���
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(this.contentPane);  
	    this.setVisible(true); 		
		
	}
}

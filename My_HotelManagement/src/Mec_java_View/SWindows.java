package Mec_java_View;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SWindows implements IWindowView{
	private JFrame jfrMainFrame;
	private Container container;
	
	private JLabel jlblUser;
	private JTextField jtxtUser;
	
	private JLabel jlblPassword;
	private JPasswordField jpswPassWord;
	
	private JButton jbtnLogin;
	private JButton jbtnExit;
	
	private static final int Max_PADDING = 50;
	private static final int PADDING = 50;

	public SWindows() {
		initView();
		reinitView();
		dealAction();	
	}
	
	@Override
	public void initView() {
		Font normalFont = new Font("宋体",Font.PLAIN,25);
		int fontSize = normalFont.getSize();
		
		Font btnFont = new Font("宋体", Font.PLAIN, 20);
		int btnFontSize = btnFont.getSize();
		
		jfrMainFrame = new JFrame("系统登录界面");
		container = jfrMainFrame.getContentPane();
		container.setLayout(null);
		
		
		int mainWidth = 600;
		int mainHeight = 300;
		
		int textFieldWidth = fontSize * 13;
		int labelWidth = 5 * fontSize;
		int normalHeight = fontSize + 2;
		int btnWidth = 6*btnFontSize;
		int btnHeight = 2*btnFontSize;
		
		jfrMainFrame.setSize(mainWidth, mainHeight);
		jfrMainFrame.setLocationRelativeTo(null);
		jfrMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int top = Max_PADDING;
		jlblUser = new JLabel("用户名");
		jlblUser.setFont(normalFont);
		jlblUser.setBounds(Max_PADDING, top, labelWidth, normalHeight);
		container.add(jlblUser);
		
		jtxtUser = new JTextField();
		jtxtUser.setFont(normalFont);
		jtxtUser.setBounds(Max_PADDING + jlblUser.getWidth() + PADDING,top ,textFieldWidth, normalHeight);
		jtxtUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtxtUser.requestFocus();
				
			}
		});
		jtxtUser.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				jtxtUser.selectAll();
			}
			
		});
		container.add(jtxtUser);
		
		top += jlblUser.getHeight() + PADDING;
		jlblPassword = new JLabel("密码",JLabel.CENTER);
		jlblPassword.setFont(normalFont);
		jlblPassword.setBounds(Max_PADDING, top, labelWidth, normalHeight);
		container.add(jlblPassword);
		
		jpswPassWord = new JPasswordField();
		jpswPassWord.setFont(normalFont);
		jpswPassWord.setBounds(Max_PADDING + jlblUser.getWidth() + PADDING, top, 
				textFieldWidth, normalHeight + 4);
		container.add(jpswPassWord);
		
		top +=jlblPassword.getHeight() +PADDING; 
		int left = 3 * Max_PADDING;
		jbtnLogin = new JButton("登陆");
		jbtnLogin.setFont(btnFont);
		jbtnLogin.setSize(btnWidth, btnHeight);
		jbtnLogin.setLocation(left,top);
		container.add(jbtnLogin);
		
		left += 5 * Max_PADDING;
		jbtnExit = new JButton("退出");
		jbtnExit.setFont(btnFont);
		jbtnExit.setSize(btnWidth, btnHeight);
		jbtnExit.setLocation(left,top);
		container.add(jbtnExit);
	}

	@Override
	public void reinitView() {
		
	}

	@Override
	public void dealAction() {
		jbtnLogin.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					if(isUserRight()) {
					SeverWindow jfrSeverFrame = new SeverWindow();
						jfrSeverFrame.show();
						jfrMainFrame.dispose();
					}
					else {
						upFrame("用户名/密码错误");
						jtxtUser.selectAll();
						jpswPassWord.setText("");
					}
				}
			});
		
		jbtnExit.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					jfrMainFrame.dispose();;
				}
			});
		
	}

	@Override
	public void show() {
		jfrMainFrame.setVisible(true);
	}



	public boolean isUserRight() {
		String userId = jtxtUser.getText().trim();
		@SuppressWarnings("deprecation")
		String userPassword = String.valueOf(jpswPassWord.getText().trim().hashCode());
		boolean n = false;
		  try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mec_hotel", 
										"root", "root");
			
			String sqlString = "SELECT id,password FROM mec_hotel_user ";
			PreparedStatement Statement = connection.prepareStatement(sqlString);//准备操作
			ResultSet rs = Statement.executeQuery();//执行查询存放在结果集中
			while(rs.next()) {//遍历结果集
				String id = rs.getString("id");
				String password = rs.getString("password");
				if(userId.equals(id) && userPassword.equals(password))
					n = true;
			}
			Statement.close();
			connection.close();//关闭所有资源（短链接）
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  return n;
	}
	
	public void upFrame(String message) {
		JOptionPane.showMessageDialog(jfrMainFrame, message, "温馨提示", JOptionPane.OK_OPTION);
	}
		
	}
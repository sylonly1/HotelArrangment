package Mec_java_View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import Mec_java_Sever.Hotel;

public class SeverWindow implements IWindowView{
	private static JFrame jfrmMainFrame;
	private static Container container;
	
	private JLabel jlblTopic;
	private List<JLabel> jlblHome;
	
	private ImageIcon icon;
	
	private JScrollPane jslpRoom;
	
	private JPanel jpanRoom;
	
	private JLabel jlblUser;
	private JTextField jtxtUser;
	
	private JLabel jlblUserId;
	private JTextField jtxtUserId;
	
	private JLabel jlblUserType;
	private JComboBox<String> jcbUserType;
	
	private JLabel jlblRoom;
	private JTextField jtxtRoom;
	
	private JLabel jlblRoomId;
	private JTextField jtxtRoomId;
	
	private JLabel jlblRoomType;
	private JComboBox<String> jcbRoomType;
	
	private JLabel jlblBeginTime;
	private JTextField jtxtBeginTime;
	
	private JLabel jlblEndTime;
	private JTextField jtxtEndTime;
	
	private JLabel jlblTime;
	
	private ImageIcon imgBackground;
	private JPanel imgBack;
	
	private JButton jbtOder;
	
	private JButton jbtRefund;
	
	private JButton jbtExit;
	
	Hotel hotel;
	
	private static final int Max_PADDING = 50;
	private static final int PADDING = 115;
	
	Font topicFont = new Font("微软雅黑",Font.BOLD,40);
	Color topicColor = new Color(10,21,250);
	
	Font normalFont = new Font("宋体",Font.BOLD,25);
	int fontSize = normalFont.getSize();
	
	Font jlblFont = new Font("微软雅黑",Font.BOLD,30);
	Color jlblColor = new Color(10,200,21);
	Color jlblFalseColor = new Color(255,0,0);
	
	Font jlblTimeFont = new Font("宋体",Font.BOLD,30);
	Color timeColor = new Color(255,0,0);
	
	Font btnFont = new Font("宋体",Font.BOLD,30);
	int btnFontSize = normalFont.getSize();
	
	
	public SeverWindow() {
		initView();
		reinitView();
		dealAction();	
	}

	@Override
	public void initView() {
		hotel = new Hotel();
		hotel.init();
		
		jfrmMainFrame = new JFrame("酒店管理系统界面");
		icon = new ImageIcon("F:/25340/Pictures/Saved Pictures/house-icon.jpg");
		icon.setImage(icon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT));
		container = jfrmMainFrame.getContentPane();
		container.setLayout(null);
		
		int mainWidth = 1200;
		int mainHeight = 800;
		
		int middleLight = 50 + 3 * 125 + 100;
		int textFieldWidth = fontSize * 13;
		int normalHeight = fontSize + 2;
		
		int btnWidth = 6*btnFontSize;
		int btnHeight = 2*btnFontSize;

		//自动居中
		jfrmMainFrame.setSize(mainWidth, mainHeight);
		jfrmMainFrame.setLocationRelativeTo(null);
		jfrmMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		imgBackground = new ImageIcon("F:/25340/Pictures/Saved Pictures/timg.jpg");
		JLabel label = new JLabel(imgBackground);
		label.setOpaque(true);
		label.setBounds(0, 0, imgBackground.getIconWidth(), imgBackground.getIconHeight());
		imgBack = (JPanel)jfrmMainFrame.getContentPane();
		imgBack.setOpaque(false);
		jfrmMainFrame.getLayeredPane().setLayout(null);
		jfrmMainFrame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		
		jlblTopic = new JLabel("欢迎使用微易码酒店管理界面",JLabel.CENTER);
		jlblTopic.setFont(topicFont);
		jlblTopic.setForeground(topicColor);
		jlblTopic.setBounds(0,0,mainWidth,topicFont.getSize()+2);
		container.add(jlblTopic);
		
		jpanRoom = new JPanel();
		jpanRoom.setVisible(true);
		jpanRoom.setPreferredSize(new Dimension(0,7 * 125));
		jpanRoom.setLayout(null);
		jpanRoom.setOpaque(false);
		
		jslpRoom = new JScrollPane(jpanRoom);
		jslpRoom.setVisible(true);
		jslpRoom.setOpaque(false);
		jslpRoom.getViewport().setOpaque(false);;
		jslpRoom.setBounds(40, jlblTopic.getHeight() + 10, 3*125 +50,5 * 125);
		container.add(jslpRoom);
		
		jlblTime = new JLabel();
		new Thread(new ShowTime(jlblTime)).start();
		jlblTime.setFont(jlblTimeFont);
		jlblTime.setBounds(50, jlblTopic.getHeight() + 25 + 5 * 125, 400,50);
		jlblTime.setForeground(timeColor);
		container.add(jlblTime);
		
		jlblHome = new ArrayList<JLabel>();
		for(int index = 0;index < hotel.getRoom().size();index++) {
			JLabel jl = new JLabel(String.valueOf(index + 1001).substring(1),icon,JLabel.LEFT);
			int x = 0 + index % 3 * 125;
			int y = 0 + index / 3 * 125;
			jl.setFont(jlblFont);
			if(hotel.getRoom().get(String.valueOf(index+1)).isRoomState())
				jl.setForeground(jlblFalseColor);
			else
				jl.setForeground(jlblColor);
			jl.setIcon(icon);
			if(index<9)
				jl.setToolTipText("标准");
			else if(index<15)
				jl.setToolTipText("奢华");
			else if(index<20)
				jl.setToolTipText("总统");
			jl.setBounds(x, y, mainWidth, topicFont.getSize()+2);
			jlblHome.add(index,jl);
			jpanRoom.add(jl);
		}
		
		int left = middleLight;
		jlblUser = new JLabel("客户姓名",JLabel.LEFT);
		jlblUser.setFont(normalFont);
		jlblUser.setBounds(left, jlblTopic.getHeight() + 25, textFieldWidth, normalHeight);
		container.add(jlblUser);
		
		left += PADDING;
		jtxtUser = new JTextField();
		jtxtUser.setFont(normalFont);
		jtxtUser.setBounds(left,jlblTopic.getHeight() + 25 ,textFieldWidth, normalHeight);
		container.add(jtxtUser);
		
		left = middleLight;
		jlblUserId = new JLabel("客户身份证号",JLabel.LEFT);
		jlblUserId.setFont(normalFont);
		jlblUserId.setBounds(left ,jlblTopic.getHeight() + 25 * 3 , textFieldWidth, normalHeight);
		container.add(jlblUserId);
		
		left += PADDING;
		jtxtUserId = new JTextField();
		jtxtUserId.setFont(normalFont);
		jtxtUserId.setBounds(left + 50,jlblTopic.getHeight() + 25 * 3,textFieldWidth - 50, normalHeight);
		container.add(jtxtUserId);
		
		left = middleLight;
		jlblUserType = new JLabel("租赁类型",JLabel.LEFT);
		jlblUserType.setFont(normalFont);
		jlblUserType.setBounds(left ,jlblTopic.getHeight() + 25 * 5 , textFieldWidth, normalHeight);
		container.add(jlblUserType);
		
		left += PADDING;
		String strRentType[] = {"小时","过夜","包月"};
		jcbUserType = new JComboBox<String>(strRentType);
		jcbUserType.setFont(normalFont);
		jcbUserType.setBounds(left ,jlblTopic.getHeight() + 25 * 5,textFieldWidth , normalHeight + 8);
		container.add(jcbUserType);
		
		left = middleLight;
		jlblRoom = new JLabel("总金额",JLabel.LEFT);
		jlblRoom.setFont(normalFont);
		jlblRoom.setBounds(left, jlblTopic.getHeight() + 25 * 7, textFieldWidth, normalHeight);
		container.add(jlblRoom);
		
		left += PADDING;
		jtxtRoom = new JTextField();
		jtxtRoom.setFont(normalFont);
		jtxtRoom.setBounds(left - 25,jlblTopic.getHeight() + 25 *7 ,textFieldWidth + 25, normalHeight);
		container.add(jtxtRoom);
		
		left = middleLight;
		jlblRoomId = new JLabel("房间编号",JLabel.LEFT);
		jlblRoomId.setFont(normalFont);
		jlblRoomId.setBounds(left,jlblTopic.getHeight() + 25 * 9 , textFieldWidth , normalHeight);
		container.add(jlblRoomId);
		
		left += PADDING;
		jtxtRoomId = new JTextField();
		jtxtRoomId.setFont(normalFont);
		jtxtRoomId.setBounds(left ,jlblTopic.getHeight() + 25 * 9,textFieldWidth , normalHeight);
		container.add(jtxtRoomId);
		
		left = middleLight;
		jlblRoomType = new JLabel("房间类型",JLabel.LEFT);
		jlblRoomType.setFont(normalFont);
		jlblRoomType.setBounds(left ,jlblTopic.getHeight() + 25 * 11 , textFieldWidth, normalHeight);
		container.add(jlblRoomType);
		
		left += PADDING;
		String strRoomType[] = {"标准","奢华","总统"};
		jcbRoomType = new JComboBox<String>(strRoomType);
		jcbRoomType.setFont(normalFont);
		jcbRoomType.setBounds(left ,jlblTopic.getHeight() + 25 * 11,textFieldWidth , normalHeight + 8);
		container.add(jcbRoomType);
		
		left = middleLight;
		jlblBeginTime = new JLabel("开始时间",JLabel.LEFT);
		jlblBeginTime.setFont(normalFont);
		jlblBeginTime.setBounds(left,jlblTopic.getHeight() + 25 * 13 , textFieldWidth , normalHeight);
		container.add(jlblBeginTime);
		
		left += PADDING;
		jtxtBeginTime = new JTextField();
		jtxtBeginTime.setFont(normalFont);
		jtxtBeginTime.setBounds(left ,jlblTopic.getHeight() + 25 * 13,textFieldWidth , normalHeight);
		container.add(jtxtBeginTime);
		
		left = middleLight;
		jlblEndTime = new JLabel("结束时间",JLabel.LEFT);
		jlblEndTime.setFont(normalFont);
		jlblEndTime.setBounds(left,jlblTopic.getHeight() + 25 * 15 , textFieldWidth , normalHeight);
		container.add(jlblEndTime);
		
		left += PADDING;
		jtxtEndTime = new JTextField();
		jtxtEndTime.setFont(normalFont);
		jtxtEndTime.setBounds(left ,jlblTopic.getHeight() + 25 * 15,textFieldWidth , normalHeight);
		container.add(jtxtEndTime);
		
		left = middleLight;
		jbtOder = new JButton("订房");
		jbtOder.setFont(btnFont);
		jbtOder.setBounds(left, jlblTopic.getHeight() + 25 + 5 * 125, btnWidth,btnHeight);
		container.add(jbtOder);
		
		left += 2*PADDING;
		jbtRefund = new JButton("退房");
		jbtRefund.setFont(btnFont);
		jbtRefund.setBounds(left, jlblTopic.getHeight() + 25 + 5 * 125, btnWidth,btnHeight);
		container.add(jbtRefund);
		
		left += 2*PADDING;
		jbtExit = new JButton("退出");
		jbtExit.setFont(btnFont);
		jbtExit.setBounds(left, jlblTopic.getHeight() + 25 + 5 * 125, btnWidth,btnHeight);
		container.add(jbtExit);
		
	}
		
	@Override
	public void reinitView() {
		jfrmMainFrame.dispose();
	}

	@Override
	public void dealAction() {
		jfrmMainFrame.addWindowListener(new WindowAdapter() {
			
			public void windowOpened(WindowEvent e) {
				jtxtRoomId.requestFocus();
			}
			
		});
		
		jbtExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jfrmMainFrame.dispose();
				
			}
		});
		
		
		jbtOder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		jtxtRoomId.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				jbtOder.setEnabled(false);
				jbtRefund.setEnabled(false);
				jtxtRoom.setText("");
				jtxtBeginTime.setText("");
				jtxtEndTime.setText("");
				jtxtRoom.setEnabled(false);
				jtxtUser.setEnabled(false);
				jtxtUserId.setEnabled(false);
				jcbUserType.setEnabled(false);
				jcbRoomType.setEnabled(false);
			}
			
		});
		
		jtxtRoomId.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == KeyEvent.VK_ENTER) {
					String id=jtxtRoomId.getText();
					jtxtUser.setText("");
					jtxtUserId.setText("");
					if(id.equals("")) {
						JOptionPane.showMessageDialog(jfrmMainFrame, "给个房号行不", "温馨提示", JOptionPane.OK_OPTION);
					}
					if(Integer.valueOf(id) <=0 || Integer.valueOf(id) > hotel.getRoom().size()) {
						JOptionPane.showMessageDialog(jfrmMainFrame, "请重新输入房号", "温馨提示", JOptionPane.OK_OPTION);
					}
					else{
					if(!hotel.getRoom().get(id).isRoomState()) {
						jbtOder.setEnabled(true);
						jbtRefund.setEnabled(false);
						jtxtRoom.setEnabled(true);
						jtxtUser.setEnabled(true);
						jtxtUserId.setEnabled(true);
						jcbUserType.setEnabled(true);
						jcbRoomType.setEnabled(true);
						jcbUserType.setSelectedIndex(0);
						jcbRoomType.setSelectedIndex(Integer.valueOf(hotel.getRoom().get(id).getRoomTypeId())-1);
					}
					else
					{
						jbtOder.setEnabled(false);
						jbtRefund.setEnabled(true);
						jcbRoomType.setEnabled(false);
						jcbUserType.setEnabled(false);
						jtxtUser.setEnabled(false);
						jtxtUserId.setEnabled(false);
						jtxtUserId.setText(hotel.getRoom().get(id).getUserId());
						jtxtUser.setText(hotel.getRoom().get(id).getUserName());
						jtxtBeginTime.setText(hotel.getRoom().get(id).getBeginTime());
						jcbRoomType.setSelectedIndex(hotel.getRoom().get(id).getRoomTypeId()-1);
						jcbUserType.setSelectedIndex(hotel.getRoom().get(id).getRentTypeId());
					}
					}
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		jbtOder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jtxtUserId.getText().equals("") || jtxtUser.getText().equals(""))
					JOptionPane.showMessageDialog(jfrmMainFrame, "请提供入住必要信息，否则我们保留一切权力", "温馨提示", JOptionPane.OK_OPTION);
				else
				{
					jtxtBeginTime.setText(hotel.getTime());
					hotel.OrderRoom(jtxtUser.getText(), jtxtUserId.getText(), jtxtRoomId.getText()
							, jcbUserType.getSelectedIndex(), true,jtxtBeginTime.getText());
					jbtOder.setEnabled(false);
					jbtRefund.setEnabled(true);
					jcbRoomType.setEnabled(false);
					jcbUserType.setEnabled(false);
					jtxtUser.setEnabled(false);
					jtxtUserId.setEnabled(false);
					jlblHome.get(Integer.valueOf(jtxtRoomId.getText())-1).setForeground(jlblFalseColor);
					jfrmMainFrame.setVisible(true);
				}
			}
		});
		
		jbtRefund.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jtxtRoomId.getText() == "")
					JOptionPane.showMessageDialog(jfrmMainFrame, "请提供房间号", "温馨提示", JOptionPane.OK_OPTION);
				else{
				jtxtEndTime.setText(hotel.getTime());
				hotel.WriteHistory(jtxtRoomId.getText(), jtxtUser.getText(),jtxtUserId.getText(), jtxtBeginTime.getText(), jtxtEndTime.getText(), 0.0);
				hotel.OrderRoom("", "", jtxtRoomId.getText(), 0, false,"");
				jlblHome.get(Integer.valueOf(jtxtRoomId.getText())-1).setForeground(jlblColor);
				System.out.println(jcbRoomType.getSelectedIndex()+1);
				int i = hotel.HowMunch(jcbRoomType.getSelectedIndex(), jcbUserType.getSelectedIndex()+1);
				jtxtRoom.setText(String.valueOf(i));
				jtxtUser.setText("");
				jtxtUserId.setText("");
				jbtOder.setEnabled(true);
				jbtRefund.setEnabled(false);
				jtxtRoom.setEnabled(true);
				jtxtUser.setEnabled(true);
				jtxtUserId.setEnabled(true);
				jcbUserType.setEnabled(true);
				jcbRoomType.setEnabled(true);
				jcbRoomType.setSelectedIndex(0);
				jcbUserType.setSelectedIndex(0);
				jfrmMainFrame.setVisible(true);
				}
				
			}
		});
	}

	@Override
	public void show() {
		jfrmMainFrame.setVisible(true);
	}
	

}
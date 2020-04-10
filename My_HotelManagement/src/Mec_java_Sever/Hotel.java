package Mec_java_Sever;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Mec_java_dao.Dao;
import Mec_java_pojo.History;
import Mec_java_pojo.Price;
import Mec_java_pojo.RentType;
import Mec_java_pojo.Room;
import Mec_java_pojo.RoomType;

public class Hotel {
	private Map<String, Room> room;
	private List<Price> price;
	private List<RentType> rentType;
	private List<RoomType> roomType;
	Dao dao = new Dao();
	
	
	public Hotel() {
		this.init();
	}
	
	
	public void setRoom(Map<String, Room> room) {
		this.room = room;
	}
	
	public void setPrice(List<Price> price) {
		this.price = price;
	}

	public void setRentType(List<RentType> rentType) {
		this.rentType = rentType;
	}

	public void setRoomType(List<RoomType> roomType) {
		this.roomType = roomType;
	}

	public Map<String, Room> getRoom() {
		return room;
	}

	public List<Price> getPrice() {
		return price;
	}

	public List<RentType> getRentType() {
		return rentType;
	}

	public List<RoomType> getRoomType() {
		return roomType;
	}

	public void init() {
		this.room = dao.intiRoom();
		this.price = dao.intiPrice();
		this.roomType = dao.intiRoomType();
		this.rentType = dao.intiRentType();
		
//		System.out.println("�����:" + room.get("1").getRoomId()+ " " + "��������:" + roomType.get(1).getRoomName()
//				+" "+ "��������:" + rentType.get(1).getRentName() + " " + "����۸�" + price.get(1).getPrice() );// + rentType.size());
	}
	
	public void OrderRoom (String UserName,String userId,String roomId,int rentType,Boolean state ,String beginTime) {
		Room usedRoom = new Room();
		
		usedRoom.setUserName(UserName);
		usedRoom.setUserId(userId);
		usedRoom.setRoomId(roomId);
		usedRoom.setRoomTypeId(room.get(roomId).getRoomTypeId());
		usedRoom.setRentTypeId(rentType);
		usedRoom.setRoomState(state);
		usedRoom.setBeginTime(beginTime);
		
		room.put(roomId, usedRoom);
		dao.updateRoom(usedRoom);
	}
	
	public void WriteHistory(String roomid, String username, String userid, String beginTime, String endTime, Double cost) {
		History history = new History();
		
		history.setRoomid(roomid);
		history.setUsername(username);
		history.setUserid(userid);
		history.setBeginTime(beginTime);
		history.setEndTime(endTime);
		history.setCost(cost);
		
		dao.WriteHistory(history);
	}
	
//	public void WriteHistory (History history) {
//		 try {
//				Class.forName("com.mysql.jdbc.Driver");
//				Connection connection =  DriverManager.getConnection("jdbc:mysql://192.168.1.4:3306/myfirstsql", 
//											"root", "root");
//				
//				String sqlString = "SELECT id,hobby FROM sys_hobby_info ";
//				PreparedStatement Statement = connection.prepareStatement(sqlString);//׼������
//				//�����ݿ��в�������
//				
//				Statement.executeUpdate("INSERT INTO mec_hotel_history"
//						+ "(roomid,username,userid,begintime,endtime,cost)" 
//						+ "VALUES('"+ "+"','��С��',"
//						+ history.getName() + "','"
//						+ history.getPassworld() + "','"
//						+ history.getSex() + "','"
//						+ history.getBirthday() + "');");
//				Statement.close();
//				connection.close();//�ر�������Դ�������ӣ�
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//	}
	
	public int HowMunch (int roomTypeId,int rentTypeId) {
		int i = (roomTypeId) *3 + rentTypeId;
		
		System.out.println(roomTypeId + " " +  rentTypeId);
		return price.get(i).getPrice();
		
	}
	
	public String getTime() {
		String str ;
		 
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		str = sdf.format(d);
		
		return str;
		
	}
	
	public static void main(String[] args) {
		 Hotel h = new Hotel();
		 h.init();
		 System.out.println(h.getTime());
	}
}

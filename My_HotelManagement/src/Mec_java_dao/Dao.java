package Mec_java_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Mec_java_pojo.History;
import Mec_java_pojo.Price;
import Mec_java_pojo.RentType;
import Mec_java_pojo.Room;
import Mec_java_pojo.RoomType;

public class Dao {
	public Map<String, Room> intiRoom() {
		 Map<String, Room> room = new HashMap<String, Room>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mec_hotel", 
										"root", "root");
			
			String sqlString = "SELECT id,name,renttype,roomtype,roomid,state FROM  mec_hotel_room";
			PreparedStatement Statement = connection.prepareStatement(sqlString);//׼������
			ResultSet rs = Statement.executeQuery();//ִ�в�ѯ����ڽ������
			while(rs.next()) {//���������
				Room aRoom = new Room();
				aRoom.setUserId(rs.getString("id"));
				aRoom.setUserName(rs.getString("name"));
				aRoom.setRentTypeId(rs.getInt("renttype"));
				aRoom.setRoomTypeId(rs.getInt("roomtype"));
				aRoom.setRoomId(rs.getString("roomid"));
				aRoom.setRoomState(rs.getBoolean("state"));
				room.put(rs.getString("roomid"), aRoom);
			}
			
			rs.close();
			Statement.close();
			connection.close();//�ر�������Դ�������ӣ�
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;
	}
	
	public List<Price> intiPrice() {
		 List<Price> price = new ArrayList<Price>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mec_hotel", 
										"root", "root");
			
			String sqlString = "SELECT number,roomtypeid,renttypeid,price FROM mec_hotel_price ";
			PreparedStatement Statement = connection.prepareStatement(sqlString);//׼������
			ResultSet rs = Statement.executeQuery();//ִ�в�ѯ����ڽ������
			while(rs.next()) {//���������
			//	System.out.println(id + "   " +hobby);
				Price aPrice  = new Price();
				aPrice.setPrice(rs.getInt("price"));
				aPrice.setRoomTypeId(rs.getInt("roomtypeid"));
				aPrice.setRentType(rs.getInt("renttypeid"));
				price.add(aPrice);
			}
			
			rs.close();
			Statement.close();
			connection.close();//�ر�������Դ�������ӣ�
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}
	
	public List<RoomType> intiRoomType() {
		List<RoomType> roomType = new ArrayList<RoomType>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mec_hotel", 
										"root", "root");
			
			String sqlString = "SELECT roomname,roomid FROM mec_hotel_roomtype ";
			PreparedStatement Statement = connection.prepareStatement(sqlString);//׼������
			ResultSet rs = Statement.executeQuery();//ִ�в�ѯ����ڽ������
			while(rs.next()) {//���������
				RoomType aroomType  = new RoomType();
				aroomType.setRoomName(rs.getString("roomname"));
				aroomType.setRoomId(rs.getInt("roomid"));
				roomType.add(aroomType);
			} 
			
			rs.close();
			Statement.close();
			connection.close();//�ر�������Դ�������ӣ�
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return roomType;
	}
	
	public List<RentType> intiRentType() {
		List<RentType> rentType = new ArrayList<RentType>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mec_hotel", 
										"root", "root");
			
			String sqlString = "SELECT rentname,rentid FROM mec_hotel_renttype ";
			PreparedStatement Statement = connection.prepareStatement(sqlString);//׼������
			ResultSet rs = Statement.executeQuery();//ִ�в�ѯ����ڽ������
			while(rs.next()) {//���������
				RentType aRentType  = new RentType();
				aRentType.setRentName(rs.getString("rentname"));
				aRentType.setRentid(rs.getInt("rentid"));
				rentType.add(aRentType);
			}
			
			rs.close();
			Statement.close();
			connection.close();//�ر�������Դ�������ӣ�
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rentType;
	}
	
	public void updateRoom (Room usedRoom) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mec_hotel?useUnicode=true&characterEncoding=utf-8", 
										"root", "root");
			
			String sqlString = "Update mec_hotel_room set id =? ,name =? ,renttype =?,state =?,begintime =? where roomid =? ";
			PreparedStatement Statement = connection.prepareStatement(sqlString);//׼������
			Statement.setString(1,usedRoom.getUserId());
			Statement.setString(2, usedRoom.getUserName());
			Statement.setInt(3, usedRoom.getRentTypeId());
			Statement.setBoolean(4, usedRoom.isRoomState());
			Statement.setString(5, usedRoom.getBeginTime());
			Statement.setInt(6, Integer.valueOf(usedRoom.getRoomId()));
			Statement.execute();
			Statement.close();
			connection.close();//�ر�������Դ�������ӣ�
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void WriteHistory (History history) {
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mec_hotel", 
											"root", "root");
				
				String sqlString = "SELECT roomid,username,userid,begintime,endtime,cost FROM mec_hotel_history ";
				PreparedStatement Statement = connection.prepareStatement(sqlString);//׼������
				//�����ݿ��в�������
				
				Statement.executeUpdate("INSERT INTO mec_hotel_history"
						+ "(roomid,username,userid,begintime,endtime,cost)" 
						+ "VALUES('"
						+ history.getRoomid() + "','"
						+ history.getUsername() + "','"
						+ history.getUserid().toString()+ "','"
						+ history.getBeginTime().toString()+ "','"
						+ history.getEndTime().toString() + "','"
						+ history.getCost() + "');");
				Statement.close();
				connection.close();//�ر�������Դ�������ӣ�
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}

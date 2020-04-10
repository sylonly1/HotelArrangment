package Mec_java_pojo;

public class Room {
	private String UserId;
	private String UserName;
	private String roomId;
	private int roomTypeId;
	private int rentTypeId;
	private int money;
	private boolean RoomState;
	private String BeginTime;
	
	
	
	public String getBeginTime() {
		return BeginTime;
	}

	public void setBeginTime(String beginTime) {
		BeginTime = beginTime;
	}

	public Room() {
		
	}
	
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public int getRentTypeId() {
		return rentTypeId;
	}

	public void setRentTypeId(int rentTypeId) {
		this.rentTypeId = rentTypeId;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getUserId() {
		return UserId;
	}



	public void setUserId(String userId) {
		UserId = userId;
	}



	public int getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	
	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String string) {
		this.roomId = string;
	}
	
	public boolean isRoomState() {
		return RoomState;
	}

	public void setRoomState(boolean roomState) {
		RoomState = roomState;
	}

	
//	@Override
//	public String toString() {
//		return "[" + id + "](" + HotelPrice.getRoomTypeName(roomTypeId)
//				+ "):" + (constomer == null ? "����":constomer.getName() + ":" 
//				+ HotelPrice.getRentTypeName(constomer.getRentTypeId()));
//	}
	
}

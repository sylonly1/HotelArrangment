package Mec_java_pojo;

public class History {
	private String roomid;
	private String username;
	private String userid;
	private String beginTime;
	private String endTime;
	private Double cost;
	public String getRoomid() {
		return roomid;
	}
	
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getBeginTime() {
		return beginTime;
	}
	
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public Double getCost() {
		return cost;
	}
	
	@Override
	public String toString() {
		return "History [roomid=" + roomid + ", username=" + username
				+ ", userid=" + userid + ", beginTime=" + beginTime
				+ ", endTime=" + endTime + ", cost=" + cost + "]";
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
	
}

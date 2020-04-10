package Mec_java_pojo;

public class RoomType {
	private int RoomId;
	private String RoomName;
	
	public int getRoomId() {
		return RoomId;
	}
	
	public void setRoomId(int roomId) {
		RoomId = roomId;
	}
	
	public String getRoomName() {
		return RoomName;
	}
	
	public void setRoomName(String roomName) {
		RoomName = roomName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoomType other = (RoomType) obj;
		if (RoomId != other.RoomId)
			return false;
		if (RoomName == null) {
			if (other.RoomName != null)
				return false;
		} else if (!RoomName.equals(other.RoomName))
			return false;
		return true;
	}
	
	
}

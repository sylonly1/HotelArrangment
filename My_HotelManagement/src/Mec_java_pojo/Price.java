package Mec_java_pojo;

public class Price {
	private int number;
	private int roomTypeId;
	private int rentType;
	private int price;
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getRoomTypeId() {
		return roomTypeId;
	}
	
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	
	public int getRentType() {
		return rentType;
	}
	
	public void setRentType(int rentType) {
		this.rentType = rentType;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Price other = (Price) obj;
		if (number != other.number)
			return false;
		if (price != other.price)
			return false;
		if (rentType != other.rentType)
			return false;
		if (roomTypeId != other.roomTypeId)
			return false;
		return true;
	}
	
	
}

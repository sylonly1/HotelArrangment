package Mec_java_pojo;

public class RentType {
	private int Rentid;
	private String RentName;
	
	public int getRentid() {
		return Rentid;
	}
	
	public void setRentid(int rentid) {
		Rentid = rentid;
	}
	
	public String getRentName() {
		return RentName;
	}
	
	public void setRentName(String rentName) {
		RentName = rentName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentType other = (RentType) obj;
		if (RentName == null) {
			if (other.RentName != null)
				return false;
		} else if (!RentName.equals(other.RentName))
			return false;
		if (Rentid != other.Rentid)
			return false;
		return true;
	}
	
	
}

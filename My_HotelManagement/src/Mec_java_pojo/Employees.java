package Mec_java_pojo;

public class Employees {
 private int workId;
 private String Id;
 private String name;
 private String password;
public int getWorkId() {
	return workId;
}

public void setWorkId(int workId) {
	this.workId = workId;
}

public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employees other = (Employees) obj;
	if (Id == null) {
		if (other.Id != null)
			return false;
	} else if (!Id.equals(other.Id))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (workId != other.workId)
		return false;
	return true;
}

@Override
public String toString() {
	return "Employees [workId=" + workId + ", password=" + password + "]";
}
}

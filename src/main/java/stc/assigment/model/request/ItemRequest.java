package stc.assigment.model.request;

import stc.assigment.model.Type;

public class ItemRequest {

	String folderName;
	String userEmail;
	String parent;
	Type type;
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parentSpace) {
		this.parent = parentSpace;
	}	
	
}

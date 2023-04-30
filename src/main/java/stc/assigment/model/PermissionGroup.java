package stc.assigment.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "permission_Group")
public class PermissionGroup {
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String groupName;
	
	@OneToMany(mappedBy="permissionGroup")
    private Set<Item> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	

}

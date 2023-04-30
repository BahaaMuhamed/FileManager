package stc.assigment.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Type type;
	
	@Column
	private String name;
	
	@ManyToOne
    @JoinColumn(name="permission_group_id", nullable=false)
	private PermissionGroup permissionGroup;
	
	@OneToOne(mappedBy = "item")
	private File file;
	
	@ManyToOne
	private Item parentItem;

	@OneToMany(mappedBy="parentItem")
	private List<Item> items;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PermissionGroup getPermissionGroup() {
		return permissionGroup;
	}

	public void setPermissionGroup(PermissionGroup permissionGroup) {
		this.permissionGroup = permissionGroup;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Item getParentItem() {
		return parentItem;
	}

	public void setParentItem(Item parentItem) {
		this.parentItem = parentItem;
	}
	
}

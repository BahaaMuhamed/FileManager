package stc.assigment.model;

import jakarta.persistence.*;

@Entity
@Table(name = "permission")
public class Permission {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "permission_level")
	private PermissionLevel level;

	@ManyToOne
	@JoinColumn(name="permission_group_id")
	private PermissionGroup permission;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public PermissionLevel getLevel() {
		return level;
	}

	public void setLevel(PermissionLevel level) {
		this.level = level;
	}

}

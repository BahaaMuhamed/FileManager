package stc.assigment.model;

import jakarta.persistence.*;

@Entity
@Table(name = "file")
public class File {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	@Column
	private byte[] content;
	
	
	@OneToOne
	@JoinColumn(name = "item_id", referencedColumnName = "id")
	private Item item;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public byte[] getContent() {
		return content;
	}


	public void setContent(byte[] content) {
		this.content = content;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}
	
}

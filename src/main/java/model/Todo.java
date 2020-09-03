package model;

import java.time.ZonedDateTime;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "creation_time", nullable = false)
	private ZonedDateTime creationTime;
	
	@Column(name = "description", length = 500)
	private String description;
	
	@Column(name = "modification_time")
	private ZonedDateTime modificationTime;
	
	@Column(name = "title", nullable = false, length = 100)
	private String title;
	
	public Todo() {
		
	}

	public Todo(Long id, ZonedDateTime creationTime, String description, ZonedDateTime modificationTime, String title) {
		super();
		this.id = id;
		this.creationTime = creationTime;
		this.description = description;
		this.modificationTime = modificationTime;
		this.title = title;
	}
}

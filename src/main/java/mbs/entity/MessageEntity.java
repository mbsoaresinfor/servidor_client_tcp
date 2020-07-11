package mbs.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "MESSAGE")
public class MessageEntity implements Serializable{

	
	private static final long serialVersionUID = 5808825789341744489L;

	@Id
	 @GeneratedValue(strategy= GenerationType.AUTO)
	 private Long id;
	 
	 @Column()
	 private String message;
	 
	 @Column()
	 private Date dateReceiver;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateReceiver() {
		return dateReceiver;
	}

	public void setDateReceiver(Date dateReceiver) {
		this.dateReceiver = dateReceiver;
	}
	 
	 
	 
	 
	
}

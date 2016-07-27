package net.rabiang.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Comment extends BaseEntity {

	private String name;

	private String email;

	private String body;

	private String ipAddress;

	private Date createdDate;

	private Date modifiedDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = this.createdDate = new Date();
	}

	@PrePersist
	public void prePersist() {
		this.createdDate = new Date();
		this.modifiedDate = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		this.modifiedDate = new Date();
	}
}

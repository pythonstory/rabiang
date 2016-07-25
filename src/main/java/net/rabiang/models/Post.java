package net.rabiang.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import net.rabiang.forms.PostForm;

@Entity
public class Post extends BaseEntity {
	public static final int STATUS_DRAFT = 0;
	public static final int STATUS_PUBLIC = 1;
	public static final int STATUS_DELETED = 2;

	public static final int FORMAT_TEXT = 0;
	public static final int FORMAT_HTML = 1;
	public static final int FORMAT_MARKDOWN = 2;

	private String title;

	private String slug;

	private String body;

	private int status;

	private int format;

	private Date createdDate;

	private Date modifiedDate;

	public Post() {
	}

	public Post(PostForm form) {
		this.id = form.getId();
		this.title = form.getTitle();
		this.slug = form.getSlug();
		this.body = form.getBody();
		this.status = form.getStatus();
		this.format = form.getFormat();

		this.modifiedDate = new Date();
		
		if (this.isNew()) {
			this.createdDate = new Date();
		}
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getFormat() {
		return format;
	}

	public void setFormat(int format) {
		this.format = format;
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
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + "]";
	}

}

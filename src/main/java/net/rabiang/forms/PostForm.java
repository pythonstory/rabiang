package net.rabiang.forms;

import org.hibernate.validator.constraints.NotEmpty;

import net.rabiang.models.Post;

public class PostForm {

	private Long id;

	@NotEmpty
	private String title;

	@NotEmpty
	private String slug;

	@NotEmpty
	private String body;

	private int status;

	private int format;

	private String tag;
	
	public PostForm() {
		
	}
	
	public PostForm(Post post) {
		this.id = post.getId();
		this.title = post.getTitle();
		this.slug = post.getSlug();
		this.body = post.getBody();
		this.status = post.getStatus();
		this.format = post.getFormat();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}

package net.rabiang.forms;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import net.rabiang.models.Post;
import net.rabiang.models.Tag;

public class PostForm {

	private Long id;

	@NotEmpty
	private String title;

	@NotEmpty
	private String slug;

	@NotEmpty
	private String body;

	private int stage;

	private int format;

	private String tag;

	private String category;

	public PostForm() {
	}

	public PostForm(Post post) {
		this.id = post.getId();
		this.title = post.getTitle();
		this.slug = post.getSlug();
		this.body = post.getBody();
		this.stage = post.getStage();
		this.format = post.getFormat();

		List<String> tags = new ArrayList<String>();

		for (Tag tag : post.getTags()) {
			tags.add(tag.getName());
		}

		this.tag = String.join(",", tags);

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

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}

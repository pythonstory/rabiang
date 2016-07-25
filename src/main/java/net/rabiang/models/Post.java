package net.rabiang.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

	private int stage;

	private int format;

	private Date createdDate;

	private Date modifiedDate;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags = new ArrayList<Tag>();

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

	public void populate(PostForm form) {
		this.id = form.getId();
		this.title = form.getTitle();
		this.slug = form.getSlug();
		this.body = form.getBody();
		this.stage = form.getStage();
		this.format = form.getFormat();

		Set<String> newTagSet = new HashSet<String>(Arrays.asList(form.getTag().split("\\s*(,\\s*)+")));

		Set<String> oldTagSet = new HashSet<String>();

		for (Tag t : this.tags) {
			oldTagSet.add(t.getName());
		}

		newTagSet.removeAll(oldTagSet);

		Iterator<String> iterator = newTagSet.iterator();

		while (iterator.hasNext()) {
			Tag tag = new Tag();
			tag.setName(iterator.next());
			this.tags.add(tag);
		}

		this.modifiedDate = new Date();

		if (this.isNew()) {
			this.createdDate = new Date();
		}
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + "]";
	}
}

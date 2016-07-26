package net.rabiang.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

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

	@Transient
	private String tagString;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<Tag> tags;

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

	public String getTagString() {
		return tagString;
	}

	public void setTagString(String tagString) {
		this.tagString = tagString;
	}

	public Set<Tag> getTags() {
		if (tags == null) {
			tags = new HashSet<Tag>();
		}
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public void populate(PostForm form) {
		this.id = form.getId();
		this.title = form.getTitle();
		this.slug = form.getSlug();
		this.body = form.getBody();
		this.stage = form.getStage();
		this.format = form.getFormat();
		this.tagString = form.getTagString();

		this.modifiedDate = new Date();

		if (this.isNew()) {
			this.createdDate = new Date();
		}
	}

	public void addTag(Tag tag) {
		this.tags.add(tag);
	}

	public void removeTag(Tag tag) {
		this.tags.remove(tag);
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + "]";
	}
}

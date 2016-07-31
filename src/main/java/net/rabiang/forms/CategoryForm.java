package net.rabiang.forms;

import org.hibernate.validator.constraints.NotEmpty;

import net.rabiang.models.Category;

public class CategoryForm {

	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String slug;

	private int position;

	private Category parent;

	public CategoryForm() {
	}
	
	public CategoryForm(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		this.slug = category.getSlug();
		this.position = category.getPosition();		
		this.parent = category.getParent();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "CategoryForm [id=" + id + ", name=" + name + ", position=" + position + ", parent=" + parent + "]";
	}
}

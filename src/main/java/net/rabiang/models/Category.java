package net.rabiang.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category extends NamedEntity {

	private String slug;

	private int position;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	private Category parent;

	@OneToMany(mappedBy = "parent")
	private Set<Category> children = new HashSet<Category>();

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
		return "Category [parent=" + parent + ", id=" + id + ", getName()=" + getName() + "]";
	}

}

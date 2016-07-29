package net.rabiang.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PostCategory extends NamedEntity {

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private PostCategory parent;

	@OneToMany(mappedBy = "parent")
	private Set<PostCategory> children;
	
	@OneToMany(mappedBy = "category")
	private List<Post> posts;

	public PostCategory getParent() {
		return parent;
	}

	public void setParent(PostCategory parent) {
		this.parent = parent;
	}

	public Set<PostCategory> getChildren() {
		if (children == null) {
			children = new HashSet<PostCategory>();
		}
		return children;
	}

	public void setChildren(Set<PostCategory> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "PostCategory [parent=" + parent + ", id=" + id + ", getName()=" + getName() + "]";
	}
}

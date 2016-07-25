package net.rabiang.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
public class Tag extends NamedEntity {

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
	private List<Post> posts = new ArrayList<Post>();

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + getName() + "]";
	}

}

package net.rabiang.utils.helpers;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

	private T data;

	private Node<T> parent;

	private List<Node<T>> children;

	public Node(T data) {
		this.data = data;
		this.children = new ArrayList<Node<T>>();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public List<Node<T>> getChildren() {
		return children;
	}

	public void setChildren(List<Node<T>> children) {
		this.children = children;
	}

	public Node<T> addChild(T child) {
		Node<T> childNode = new Node<T>(child);
		childNode.parent = this;
		this.children.add(childNode);
		return childNode;
	}
}

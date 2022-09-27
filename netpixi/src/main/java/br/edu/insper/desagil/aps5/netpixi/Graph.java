package br.edu.insper.desagil.aps5.netpixi;

import java.util.ArrayList;
import java.util.List;

public abstract class Graph extends Element {
	private List<Vertex> vertices;

	public Graph() {
		this.vertices = new ArrayList<>();
	}

	public Vertex vertex(int i) {
		return vertices.get(i);
	}

	public void addVertex() {
		vertices.add(new Vertex());
	}

	public abstract void addEdge(int i, int j);
}

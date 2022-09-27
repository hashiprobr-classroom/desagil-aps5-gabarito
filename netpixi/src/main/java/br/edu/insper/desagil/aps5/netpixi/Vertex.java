package br.edu.insper.desagil.aps5.netpixi;

import java.util.ArrayList;
import java.util.List;

public class Vertex extends Element {
	private List<Edge> edges;

	public List<Vertex> neighbors() {
		List<Vertex> neighbors = new ArrayList<>();
		for (Edge edge : edges) {
			neighbors.add(edge.getTarget());
		}
		return neighbors;
	}

	public void addNeighbor(Vertex target) {
		edges.add(new Edge(target));
	}
}

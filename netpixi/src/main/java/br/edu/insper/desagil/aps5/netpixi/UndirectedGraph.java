package br.edu.insper.desagil.aps5.netpixi;

public class UndirectedGraph extends Graph {
	@Override
	public void addEdge(int i, int j) {
		Vertex u = vertex(i);
		Vertex v = vertex(j);
		u.addNeighbor(v);
		v.addNeighbor(u);
	}
}

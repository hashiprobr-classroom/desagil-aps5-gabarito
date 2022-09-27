package br.edu.insper.desagil.aps5.netpixi;

public class Edge extends Element {
	private Vertex target;

	public Edge(Vertex target) {
		this.target = target;
	}

	public Vertex getTarget() {
		return target;
	}
}

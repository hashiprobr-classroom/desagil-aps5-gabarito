package br.edu.insper.desagil.aps5.wrestling;

public class Wrestler {
	private int id;
	private String name;
	private double weight;

	public Wrestler(int id, String name, double weight) {
		this.id = id;
		this.name = name;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}
}

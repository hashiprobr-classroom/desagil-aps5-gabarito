package br.edu.insper.desagil.aps5.wrestling;

public class Team {
	private int idFirst;
	private int idSecond;

	public Team(int idFirst, int idSecond) {
		this.idFirst = idFirst;
		this.idSecond = idSecond;
	}

	public int getIdFirst() {
		return idFirst;
	}

	public int getIdSecond() {
		return idSecond;
	}
}

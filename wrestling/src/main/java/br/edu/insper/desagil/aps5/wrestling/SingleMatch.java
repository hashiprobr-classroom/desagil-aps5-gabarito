package br.edu.insper.desagil.aps5.wrestling;

public class SingleMatch {
	private int idWinner;
	private int idLoser;

	public SingleMatch(int idWinner, int idLoser) {
		this.idWinner = idWinner;
		this.idLoser = idLoser;
	}

	public int getIdWinner() {
		return idWinner;
	}

	public int getIdLoser() {
		return idLoser;
	}

	public int calculatePoints(int id) {
		if (idWinner == id) {
			return 2;
		}
		return 0;
	}
}

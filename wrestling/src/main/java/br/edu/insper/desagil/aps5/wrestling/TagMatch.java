package br.edu.insper.desagil.aps5.wrestling;

public class TagMatch {
	private int idWinnerTeamFirstMember;
	private int idWinnerTeamSecondMember;
	private int idLoserTeamFirstMember;
	private int idLoserTeamSecondMember;

	public TagMatch(int idWinnerTeamFirstMember, int idWinnerTeamSecondMember, int idLoserTeamFirstMember, int idLoserTeamSecondMember) {
		this.idWinnerTeamFirstMember = idWinnerTeamFirstMember;
		this.idWinnerTeamSecondMember = idWinnerTeamSecondMember;
		this.idLoserTeamFirstMember = idLoserTeamFirstMember;
		this.idLoserTeamSecondMember = idLoserTeamSecondMember;
	}

	public int getIdWinnerTeamFirstMember() {
		return idWinnerTeamFirstMember;
	}

	public int getIdWinnerTeamSecondMember() {
		return idWinnerTeamSecondMember;
	}

	public int getIdLoserTeamFirstMember() {
		return idLoserTeamFirstMember;
	}

	public int getIdLoserTeamSecondMember() {
		return idLoserTeamSecondMember;
	}

	public int calculatePoints(int id) {
		if (idWinnerTeamFirstMember == id || idLoserTeamSecondMember == id) {
			return 1;
		}
		return 0;
	}
}

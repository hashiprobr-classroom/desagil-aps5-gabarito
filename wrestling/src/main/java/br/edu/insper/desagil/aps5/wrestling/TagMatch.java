package br.edu.insper.desagil.aps5.wrestling;

public class TagMatch extends Match {
	private Team winnerTeam;
	private Team loserTeam;

	public TagMatch(int idWinnerTeamFirstMember, int idWinnerTeamSecondMember, int idLoserTeamFirstMember, int idLoserTeamSecondMember) {
		this.winnerTeam = new Team(idWinnerTeamFirstMember, idWinnerTeamSecondMember);
		this.loserTeam = new Team(idLoserTeamFirstMember, idLoserTeamSecondMember);
	}

	public int getIdWinnerTeamFirstMember() {
		return winnerTeam.getIdFirst();
	}

	public int getIdWinnerTeamSecondMember() {
		return winnerTeam.getIdSecond();
	}

	public int getIdLoserTeamFirstMember() {
		return loserTeam.getIdFirst();
	}

	public int getIdLoserTeamSecondMember() {
		return loserTeam.getIdSecond();
	}

	@Override
	public int calculatePoints(int id) {
		if (winnerTeam.getIdFirst() == id || loserTeam.getIdSecond() == id) {
			return 1;
		}
		return 0;
	}
}

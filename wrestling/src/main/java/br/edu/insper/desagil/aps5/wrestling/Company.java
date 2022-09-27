package br.edu.insper.desagil.aps5.wrestling;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private List<SingleMatch> singleMatches;
	private List<TagMatch> tagMatches;

	public Company() {
		this.singleMatches = new ArrayList<>();
		this.tagMatches = new ArrayList<>();
	}

	public void addSingleMatch(SingleMatch match) {
		singleMatches.add(match);
	}

	public void addTagMatch(TagMatch match) {
		tagMatches.add(match);
	}

	public int points(Wrestler wrestler) {
		int points = 0;

		int id = wrestler.getId();

		for (SingleMatch match : singleMatches) {
			if (match.getIdWinner() == id) {
				points += 2;
			}
		}

		for (TagMatch match : tagMatches) {
			if (match.getIdWinnerTeamFirstMember() == id || match.getIdLoserTeamSecondMember() == id) {
				points += 1;
			}
		}

		return points;
	}
}

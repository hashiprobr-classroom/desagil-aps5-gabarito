package br.edu.insper.desagil.aps5.wrestling;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private List<Match> matches;

	public Company() {
		this.matches = new ArrayList<>();
	}

	public void addSingleMatch(SingleMatch match) {
		matches.add(match);
	}

	public void addTagMatch(TagMatch match) {
		matches.add(match);
	}

	public int points(Wrestler wrestler) {
		int points = 0;

		int id = wrestler.getId();

		for (Match match : matches) {
			points += match.calculatePoints(id);
		}

		return points;
	}
}

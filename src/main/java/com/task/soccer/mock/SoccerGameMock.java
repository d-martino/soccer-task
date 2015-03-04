package com.task.soccer.mock;

import java.util.ArrayList;
import java.util.List;

import com.task.soccer.data.SoccerData;

/**
 * Provides a possible implementation of the {@link SoccerGame} interface.
 * It is a mock that contains the current soccer game data that are pulled
 * by {@link SoccerData} object.
 * 
 * @author Daniela Martino
 * @since 0.0.1
 */
public class SoccerGameMock implements SoccerGame {

	private int goalsTeamA;
	private int goalsTeamB;
	private int currentMinute;
	private List<Integer> scoringTimesA = new ArrayList<>();
	private List<Integer> scoringTimesB = new ArrayList<>();

	@Override
	public int getGoalsTeamA() {
		return goalsTeamA;
	} 

	@Override
	public void setGoalsTeamA(int goalsTeamA) {
		this.goalsTeamA = goalsTeamA;
	}

	@Override
	public int getGoalsTeamB() {
		return goalsTeamB;
	}

	@Override
	public void setGoalsTeamB(int goalsTeamB) {
		this.goalsTeamB = goalsTeamB;
	}

	@Override
	public int getCurrentMinute() {
		return currentMinute;
	}

	@Override
	public void setCurrentMinute(int currentMinute) {
		this.currentMinute = currentMinute;
	}

	@Override
	public List<Integer> getScoringTimesA() {
		return scoringTimesA;
	}

	@Override
	public List<Integer> getScoringTimesB() {
		return scoringTimesB;
	}

	@Override
	public void storeScoringTimesA() {
		scoringTimesA.add(currentMinute);
	}

	@Override
	public void storeScoringTimesB() {
		scoringTimesB.add(currentMinute);
	}

}

package com.task.soccer.mock;

import java.util.List;

/**
 * A class can implements the SoccerGame interface when it wants get and
 * provide a soccer game data. The data include goals and goals times scored by each team
 * and time elapsed.
 * 
 * @author Daniela Martino
 * @since 0.0.1
 */
public interface SoccerGame {

	/**
	 * Return the updated number of goals scored by "team A".
	 * @return the number of goals scored by "team A".
	 */
	int getGoalsTeamA();

	/**
	 * Return the updated number of goals scored by "team B".
	 * @return the number of goals scored by "team B".
	 */
	int getGoalsTeamB();

	/**
	 * Return the current minute of the game.
	 * @return the current minute of the game.
	 */
	int getCurrentMinute();

	/**
	 * Return the list of times for the goals scored by "team A".
	 * @return the list of times.
	 */
	List<Integer> getScoringTimesA();

	/**
	 * Return the list of times for the goals scored by "team B".
	 * @return the list of times.
	 */
	List<Integer> getScoringTimesB();
	
	/**
	 * Set the total number of goals scored by "team A".
	 * @param goalsA the total number of goals scored by "team A".
	 */
	void setGoalsTeamA(int goalsA);

	/**
	 * Set the total number of goals scored by "team B".
	 * @param goalsB the total number of goals scored by "team B".
	 */
	void setGoalsTeamB(int goalsB);

	/**
	 * Set the current minute of the soccer game.
	 * @param currentMinute the current minute of the soccer game.
	 */
	void setCurrentMinute(int currentMinute);

	/**
	 * Store each goal time scored by "team A".
	 */
	void storeScoringTimesA();

	/**
	 * Store each goal time scored by "team B".
	 */
	void storeScoringTimesB();
}

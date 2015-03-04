package com.task.soccer.data;

import java.util.List;
import java.util.Observable;

import com.task.soccer.displays.Display;
import com.task.soccer.mock.SoccerGame;

/**
 * Tracks the data of a soccer game, e.g. teams goals, elapsed time and game statistics.
 * It is an observable object that notifies the registered observant displays 
 * whenever a data status change occurs.
 * It extends the {@link Observable} class.
 *  
 * @author Daniela Martino
 * @since 0.0.1
 */
public class SoccerData extends Observable {

	private SoccerGame soccerGame;

	public SoccerData(SoccerGame soccerGame) {
		this.soccerGame = soccerGame;
	}
	
	/**
	 * Return the updated number of goals scored by "team A".
	 * @return the number of goals scored by "team A".
	 */
	public int getGoalsTeamA() {
		return soccerGame.getGoalsTeamA();
	}

	/**
	 * Return the updated number of goals scored by "team B".
	 * @return the number of goals scored by "team B".
	 */
	public int getGoalsTeamB() {
		return soccerGame.getGoalsTeamB();
	}

	/**
	 * Return the current minute of the game.
	 * @return the current minute of the game.
	 */
	public int getCurrentMinute() {
		return soccerGame.getCurrentMinute();
	}

	/**
	 * Return the list of times for the goals scored by "team A".
	 * @return the list of times.
	 */
	public List<Integer> getScoringTimesA() {
		return soccerGame.getScoringTimesA(); 
	}

	/**
	 * Return the list of times for the goals scored by "team B".
	 * @return the list of times.
	 */
	public List<Integer> getScoringTimesB() {
		return soccerGame.getScoringTimesB();
	}

	/**
	 * Notifies all observant displays that some measurement is changed.
	 * It should be called whenever a status change of the soccer data occurs, 
	 * e.g. new goal, new minute, etc.
	 */
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}

	/**
	 * Adds the specified display interested to the soccer data status change.
	 * @param display the display to add.
	 */
	public void addDisplay(Display display) {
		addObserver(display);
	}

	/**
	 * Adds the specified list of displays interested to the soccer data
	 * status change.
	 * @param displays the list of displays to add.
	 */
	public void addDisplays(List<Display> displays) {
		for (Display display : displays) {
			addObserver(display);
		}
	}

	/**
	 * Removes the specified display no longer interested to the soccer data 
	 * status change.
	 * @param display the display to remove.
	 */
	public void removeDisplay(Display display) {
		deleteObserver(display);
	}

	/**
	 * Removes the specified list of displays no longer interested to the 
	 * soccer data status change.
	 * @param displays the list of displays to remove.
	 */
	public void removeDisplays(List<Display> displays) {
		for (Display display : displays) {
			deleteObserver(display);
		}
	}

	/**
	 * Removes all displays observing the soccer data status change.
	 */
	public void removeAllDisplays() {
		deleteObservers();
	}
}

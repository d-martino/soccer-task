package com.task.soccer.displays;

import java.util.List;
import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.task.soccer.data.SoccerData;

/**
 * A display to show the game statistics notified from the observable object, {@link SoccerData}, 
 * whenever its data status changed.
 * It implements the {@link Display} interface.
 * 
 * @author Daniela Martino
 * @since 0.0.1
 */
public class GameStatistics implements Display {
	
	private final Logger logger = LoggerFactory.getLogger(GameStatistics.class);

	@Override
	public void update(Observable o, Object arg) {
		SoccerData soccerData = (SoccerData) o;
		logger.info(buildStatistics(soccerData.getScoringTimesA(),
				soccerData.getScoringTimesB()));
	}

	private String buildStatistics(List<Integer> scoringTimesA,
			List<Integer> scoringTimesB) {
//		StringBuilder statisticsText = new StringBuilder("-------------------\n");
		StringBuilder statisticsText = new StringBuilder("\n");

		statisticsText.append("Statistics Team A \n");
		for (Integer minute : scoringTimesA) {
			statisticsText.append("Goal at minute " + minute + "\n");
		}
		statisticsText.append("\nStatistics Team B \n");
		for (Integer minute : scoringTimesB) {
			statisticsText.append("Goal at minute " + minute + "\n");
		}
		statisticsText.append("\n===================\n");
		return statisticsText.toString();
	}
}

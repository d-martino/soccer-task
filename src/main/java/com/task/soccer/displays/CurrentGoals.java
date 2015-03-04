package com.task.soccer.displays;

import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.task.soccer.data.SoccerData;

/**
 * A display to show the current goals notified from the observable object, {@link SoccerData}, 
 * whenever its data status changed.
 * It implements the {@link Display} interface.
 * 
 * @author Daniela Martino
 * @since 0.0.1
 */
public class CurrentGoals implements Display {
	
	private final Logger logger = LoggerFactory.getLogger(CurrentGoals.class);
	
	public void update(Observable o, Object arg) {
		SoccerData soccerData = (SoccerData) o;
		logger.info("[CURRENT GOALS A - B] " + soccerData.getGoalsTeamA()
				+ " - " + soccerData.getGoalsTeamB());
	}

}

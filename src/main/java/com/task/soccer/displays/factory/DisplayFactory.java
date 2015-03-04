package com.task.soccer.displays.factory;

import java.util.ArrayList;
import java.util.List;

import com.task.soccer.displays.CurrentGoals;
import com.task.soccer.displays.Display;
import com.task.soccer.displays.ElapsedTime;
import com.task.soccer.displays.GameStatistics;

/**
 * A factory method to create displays.
 * 
 * @author Daniela Martino
 * @since 0.0.1
 */
public class DisplayFactory {

	/**
	 * Creates a new display according to a given display type.
	 * {@link DisplayType}.
	 * 
	 * @param displayType the display Type.
	 */
	public static Display createDisplay(DisplayType displayType) {
		Display display = null;
		switch (displayType) {
		case CURRENT_GOALS:
			display = new CurrentGoals();
			break;
		case ELAPSED_TIME:
			display = new ElapsedTime();
			break;
		case GAME_STATISTICS:
			display = new GameStatistics();
			break;
		}
		return display;
	}

	/**
	 * Creates all known display types.
	 * {@link DisplayType}.
	 * 
	 * @return the list of the created displays.
	 */
	public static List<Display> createAllDisplayTypes() {
		List<Display> displays = new ArrayList<>();
		for (DisplayType displayType : DisplayType.values()) {
			displays.add(DisplayFactory.createDisplay(displayType));
		}
		return displays;
	}
}

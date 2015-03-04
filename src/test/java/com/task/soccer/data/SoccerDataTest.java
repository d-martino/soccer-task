package com.task.soccer.data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.task.soccer.displays.Display;
import com.task.soccer.displays.factory.DisplayType;
import com.task.soccer.displays.factory.DisplayFactory;
import com.task.soccer.mock.SoccerGame;
import com.task.soccer.mock.SoccerGameMock;

/**
 * Test class for soccer data object.
 * 
 * @author Daniela Martino
 * @since 0.0.1
 */
public class SoccerDataTest {

	private SoccerGame soccerGame;
	private SoccerData soccerData;

	@Before
	public void setUp() {
		soccerGame = new SoccerGameMock();
		soccerData = new SoccerData(soccerGame);
	}

	/**
	 * Tests the addition of a single display.
	 */
	@Test
	public void addDisplay() {
		soccerData.addDisplay(DisplayFactory
				.createDisplay(DisplayType.CURRENT_GOALS));
		assertThat("The number of observant displays should be 1",
				soccerData.countObservers(), is(1));
	}

	/**
	 *  Tests the addition of all displays.
	 */
	@Test
	public void addDisplays() {
		List<Display> displays = DisplayFactory.createAllDisplayTypes();
		soccerData.addDisplays(displays);
		
		int expectedSize = DisplayType.values().length;
		assertThat("The number of observant displays should be " + expectedSize,
				soccerData.countObservers(), is(expectedSize));

	}

	/**
	 *  Tests the remotion of a single display.
	 */
	@Test
	public void removeDisplay() {
		List<Display> displays = DisplayFactory.createAllDisplayTypes();
		soccerData.addDisplays(displays);
		
		int currentObservers = soccerData.countObservers();

		soccerData.deleteObserver(displays.get(0));
		assertThat("The number of observant displays should be 2",
				soccerData.countObservers(), is(currentObservers - 1));
	}

	/**
	 *  Tests the remotion of a list of displays.
	 */
	@Test
	public void removeDisplays() {
		List<Display> displays = DisplayFactory.createAllDisplayTypes();
		soccerData.addDisplays(displays);
		soccerData.addDisplay(DisplayFactory.createDisplay(DisplayType.GAME_STATISTICS));

		soccerData.removeDisplays(displays);
		assertThat("The number of observant displays should be 1",
				soccerData.countObservers(), is(1));
		
	}

	/**
	 * Tests the remotion of all displays.
	 */
	@Test
	public void removeAllDisplays() {
		List<Display> displays = DisplayFactory.createAllDisplayTypes();
		soccerData.addDisplays(displays);
		
		soccerData.removeAllDisplays();
		assertThat("The number of observant displays should be 0",
				soccerData.countObservers(), is(0));
	}
}

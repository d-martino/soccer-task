package com.task.soccer.displays.factory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.Test;

import com.task.soccer.displays.Display;

/**
 * Test class for the displays factory.
 * 
 * @author Daniela Martino
 * @since 0.0.1
 */
public class DisplayFactoryTest {

	/**
	 * Tests the creation of a single display. 
	 */
	@Test
	public void createDisplay() {
		Display display = DisplayFactory.createDisplay(DisplayType.CURRENT_GOALS);
		assertThat("Display is not null",
				display, is(notNullValue()));
	}
	
	/**
	 * Tests the creation of all display types.
	 */
	@Test
	public void createAllDisplayTypes() {
		List<Display> displays = DisplayFactory.createAllDisplayTypes();
		int expectedSize = DisplayType.values().length;
		assertThat("Display list is not null",
				displays, is(notNullValue()));
		assertThat("The number of created display is " + expectedSize, displays.size(),
				is(expectedSize));
	}

}

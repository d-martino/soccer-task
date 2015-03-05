package com.task.soccer.runner;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.task.soccer.data.SoccerData;
import com.task.soccer.displays.factory.DisplayFactory;
import com.task.soccer.mock.SoccerGame;
import com.task.soccer.mock.SoccerGameMock;

public class GameRunner {

	private static final Random RANDOM = new Random();

	public static void main(String[] args) {
		final SoccerGame soccerGame = new SoccerGameMock();
		final SoccerData soccerData = new SoccerData(soccerGame);
		soccerData.addDisplays(DisplayFactory.createAllDisplayTypes());

		// To simulate the passing of the game time. The period is a second 
		// instead of a minute to have a faster simulation.  
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				if (soccerGame.getCurrentMinute() <= 90) {
					soccerGame.setCurrentMinute(soccerGame.getCurrentMinute() + 1);
					soccerData.measurementsChanged();
					if (goalProbability() > 90) {
						if (RANDOM.nextBoolean()) {
							setMeasureTeamA(soccerGame);
						} else {
							setMeasureTeamB(soccerGame);

						}
						soccerData.measurementsChanged();
					}
				} else {
					timer.cancel();
					timer.purge();
				}
			}
		}, 3000, 1000);
	}

	private static int goalProbability() {
		return RANDOM.nextInt(101);
	}

	private static void setMeasureTeamA(SoccerGame soccerGame) {
		soccerGame.setGoalsTeamA(soccerGame.getGoalsTeamA() + 1);
		soccerGame.storeScoringTimesA();
	}

	private static void setMeasureTeamB(SoccerGame soccerGame) {
		soccerGame.setGoalsTeamB(soccerGame.getGoalsTeamB() + 1);
		soccerGame.storeScoringTimesB();
	}

}

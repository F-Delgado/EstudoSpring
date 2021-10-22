package com.luv2code.springdemo;

public class FightCoach implements Coach {
	@Override
	public String getDailyWorkout() {
		return "Lets Do It MF!";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

}

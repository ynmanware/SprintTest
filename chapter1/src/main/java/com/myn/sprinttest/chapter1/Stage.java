package com.myn.sprinttest.chapter1;


public class Stage {
	private static Stage instance = new Stage();

	private Stage() {
		System.out.println("Instance created");
	}

	private static class StageSingletonHolder {
		public static Stage instance = new Stage();
	}

	public static Stage getInstance() {
		return instance;
	}
}

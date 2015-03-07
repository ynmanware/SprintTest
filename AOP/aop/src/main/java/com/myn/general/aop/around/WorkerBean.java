package com.myn.general.aop.around;

public class WorkerBean {
	public void doSomeWork(int noOfTimes) {
		for (int x = 0; x < noOfTimes; x++) {
			work();
		}
	}

	private void work() {
		System.out.print("");
	}
}
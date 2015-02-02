package com.myn.bean_injection;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * 
 * @author Yogesh.Manware
 *
 */

@Named
public class TestBeanInjection {
	
	@Inject
	private A a;

	@Inject
	private B b;

	public A getA() {
		return a;
	}

	public B getB() {
		return b;
	}

	
	
}

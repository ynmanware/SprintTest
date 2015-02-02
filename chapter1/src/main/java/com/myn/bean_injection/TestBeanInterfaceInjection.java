package com.myn.bean_injection;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Yogesh.Manware
 *
 */
@Named
public class TestBeanInterfaceInjection {

	@Inject
	@Named("a")
	private Identifiable i;

	public Identifiable getI() {
		return i;
	}
}

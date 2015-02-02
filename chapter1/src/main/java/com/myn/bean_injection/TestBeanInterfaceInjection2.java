package com.myn.bean_injection;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Yogesh.Manware
 *
 */
@Named
public class TestBeanInterfaceInjection2 {

	@Autowired
	@Qualifier("a2")
	private Identifiable2 i;

	public Identifiable2 getI() {
		return i;
	}
}

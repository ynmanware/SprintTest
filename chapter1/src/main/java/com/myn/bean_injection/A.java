package com.myn.bean_injection;

import javax.inject.Named;

/**
 * 
 * @author Yogesh.Manware
 *
 */
@Named
public class A implements Identifiable {
	public String identify() {
		return "A";
	}
}

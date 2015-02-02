package com.myn.bean_injection;

import javax.inject.Named;

/**
 * 
 * @author Yogesh.Manware
 *
 */
@Named
public class B implements Identifiable {
	public String identify() {
		return "B";
	}
}

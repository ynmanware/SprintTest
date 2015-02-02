package com.myn.bean_injection;

import javax.inject.Named;
/**
 * 
 * @author Yogesh.Manware
 *
 */
@Named
public class B2 implements Identifiable2 {
	public String identify() {
		return "B2";
	}
}

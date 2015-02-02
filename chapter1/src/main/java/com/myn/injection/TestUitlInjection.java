package com.myn.injection;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * @author Yogesh.Manware
 *
 */
@Component
public class TestUitlInjection {

	@Resource()
	private Map<String, String> delegationConfiguration;
	
	public Map<String, String> getConfigValues() {
		return delegationConfiguration;
	}

	public void setConfigValues(Map<String, String> configValues) {
		configValues = configValues;
	}

}

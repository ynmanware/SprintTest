package com.myn.injection;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class TestUitlInjection {

	@Resource(name="delegationConfiguration")
	private Map<String, String> configValues;
	
	public Map<String, String> getConfigValues() {
		return configValues;
	}

	public void setConfigValues(Map<String, String> configValues) {
		configValues = configValues;
	}

}

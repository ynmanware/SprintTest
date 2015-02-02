package com.myn.properties;

import java.util.Locale;
import java.util.Properties;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.google.gson.Gson;

/**
 *
 * @Author Yogesh.Manware
 *
 */

public class RestCommon extends ReloadableResourceBundleMessageSource {

	public String getAllProp() {
		Properties properties = getMergedProperties(Locale.ENGLISH).getProperties();
		Gson g = new Gson();
		return g.toJson(properties);
	}

}

var UrlHelper = UrlHelper || (function() {
	var _urls = [];
	var _urlsLibrary = [];
	return {
		include : function(updateContextPath) {
			include(_urlsLibrary, updateContextPath, true);
			include(_urls, updateContextPath);
		},
		add : function(url) {
			_urls.push(url);
		},
		addLibrary : function(url) {
			_urlsLibrary.push(url);
		}
	};
}());

function getContextPath(updateContextPath) {
	// expose it as a global variable to able to access across application
	if (!updateContextPath && !(typeof _sd_contextPath == 'undefined')) {
		return _sd_contextPath;
	}
	var contextPath = "UNKNOWN_CONTEXT";
	var allIncludes = document.getElementsByTagName("script");
	for ( var j = 0; j < allIncludes.length; j++) {
		if (allIncludes[j].src.indexOf("Url_Helper.js") > -1) {
			var matches = allIncludes[j].src.split("/");
			for ( var k = 0; k < matches.length; k++) {
				// if ("plugins" == matches[k]) {
				// TODO: adjust based on project setup
				contextPath = "/" + matches[3];
				break;
				// }
			}
			if (contextPath != "UNKNOWN_CONTEXT") {
				break;
			}
		}
	}
	_sd_contextPath = contextPath;
	return _sd_contextPath;
}

function getProductVersion(updateProductVersion) {
	// expose it as a global variable to able to access across application
	if (!updateProductVersion && !(typeof _sd_productVersion == 'undefined')) {
		return _sd_productVersion;
	}
	var productVersion = document.getElementById('productVersion');
	return productVersion ? productVersion.value : "UNKNOWN_PRODUCT_VERSION";
}

function include(urls, updateContextPath, library) {

	var contextPath = getContextPath(updateContextPath);
	var productVersion = getProductVersion(updateContextPath);

	var head = document.getElementsByTagName('head')[0];
	if (urls.length > 0) {
		for ( var i = 0; i < urls.length; i++) {
			var newUrl = urls[i];

			if (!library) {
				if (urls[i].indexOf("/") > -1) {
					var lios = newUrl.lastIndexOf("/");
					newUrl = newUrl.substring(0, lios + 1) + productVersion
							+ "/" + newUrl.substring(lios + 1);
				} else {
					newUrl = productVersion + "/" + newUrl;
				}

				if (newUrl.indexOf("/") != 0) {
					newUrl = "/" + newUrl;
				}
			}
			addScriptTag(head, contextPath + newUrl);
		}
	}

	function addScriptTag(head, src) {
		var s = document.createElement('script');
		s.setAttribute('src', src);
		s.setAttribute('type', "text/javascript");
		head.appendChild(s);
	}
}
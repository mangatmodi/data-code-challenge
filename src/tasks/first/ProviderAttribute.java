package tasks.first;

import main.ParseRouteFile;

public class ProviderAttribute {
	private String display_name;

	private String provider_icon_url;

	private String disclaimer;

	private String ios_app_url;

	private String ios_itunes_url;

	private String android_package_name;

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getProvider_icon_url() {
		return provider_icon_url;
	}

	public void setProvider_icon_url(String provider_icon_url) {
		this.provider_icon_url = provider_icon_url;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public String getIos_app_url() {
		return ios_app_url;
	}

	public void setIos_app_url(String ios_app_url) {
		this.ios_app_url = ios_app_url;
	}

	public String getIos_itunes_url() {
		return ios_itunes_url;
	}

	public void setIos_itunes_url(String ios_itunes_url) {
		this.ios_itunes_url = ios_itunes_url;
	}

	public String getAndroid_package_name() {
		return android_package_name;
	}

	public void setAndroid_package_name(String android_package_name) {
		this.android_package_name = android_package_name;
	}

	public static ProviderAttribute create(String jsonString) {
		return ParseRouteFile.gson.fromJson(jsonString, ProviderAttribute.class);
	}

	public void cleanData() {
		if (display_name == null) {
			display_name = "";
		}
		if (provider_icon_url == null) {
			provider_icon_url = "";
		}
		if (disclaimer == null) {
			disclaimer = "";
		}
		if (ios_app_url == null) {
			ios_app_url = "";
		}
		if (ios_itunes_url == null) {
			ios_itunes_url = "";
		}
		if (android_package_name == null) {
			android_package_name = "";
		}
	}
	@Override
	public String toString() {
		return display_name + '\u0001' + provider_icon_url + '\u0001' + disclaimer + '\u0001' + ios_app_url + '\u0001'
				+ ios_itunes_url + '\u0001' + android_package_name;
	}
}

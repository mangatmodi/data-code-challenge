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

	@Override
	public String toString() {
		return "ClassPojo [display_name = " + display_name + ", provider_icon_url = " + provider_icon_url
				+ ", disclaimer = " + disclaimer + ", ios_app_url = " + ios_app_url + ", ios_itunes_url = "
				+ ios_itunes_url + ", android_package_name = " + android_package_name + "]";
	}
}

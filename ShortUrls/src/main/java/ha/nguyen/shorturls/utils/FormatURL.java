package ha.nguyen.shorturls.utils;

public class FormatURL {
	public static String formatUrl(String originUrl) {
		String urlFormat = originUrl;
		if(urlFormat.contains("https://")) {
			urlFormat = urlFormat.substring(8);
		}else if(urlFormat.contains("http://")){
			urlFormat = urlFormat.substring(7);
		}
		if(urlFormat.charAt(urlFormat.length()-1)=='/') {
			urlFormat = urlFormat.substring(0,urlFormat.length());
		}
		return urlFormat;
	}
}

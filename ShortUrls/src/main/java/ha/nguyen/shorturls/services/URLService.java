package ha.nguyen.shorturls.services;

import java.net.UnknownHostException;

public interface URLService {
	String saveNewShortURL(String url) throws UnknownHostException;
	String getOriginalURL(String urlShorten) throws UnknownHostException;
}

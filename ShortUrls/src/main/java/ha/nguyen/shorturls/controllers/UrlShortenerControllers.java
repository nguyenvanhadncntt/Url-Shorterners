package ha.nguyen.shorturls.controllers;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import ha.nguyen.shorturls.services.URLService;

@Controller
@CrossOrigin
public class UrlShortenerControllers {

	@Autowired
	private URLService urlService;
	
	@PostMapping("/getUrlShorten")
	@ResponseBody
	public String getUrlShorten(@RequestParam("url") String url) {
		try {
			String urlShorten = urlService.saveNewShortURL(url);
			return urlShorten;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/{urlShorten}")
	public RedirectView redirectOriginUrl(@PathVariable String urlShorten) {
		RedirectView rv = new RedirectView();
		String originUrl = null;
		try {
			originUrl = urlService.getOriginalURL(urlShorten);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rv.setUrl(originUrl);
		return rv;
	}
}

package ha.nguyen.shorturls.services.impl;

import java.net.UnknownHostException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ha.nguyen.shorturls.repositories.URLRepository;
import ha.nguyen.shorturls.repositories.entities.URLShortener;
import ha.nguyen.shorturls.services.URLService;
import ha.nguyen.shorturls.utils.Base62;

@Service
public class URLServiceImpl implements URLService{
	
	@Autowired
	private URLRepository urlRespository;
	
	@Override
	public String saveNewShortURL(String url) throws UnknownHostException {
		Long idURL = urlRespository.getNumberGenerateNext();
		if(idURL==null) {
			idURL = new Long(10000);
		}else {
			idURL = idURL + 1;
		}
		
		Optional<URLShortener> optUrlShorten = urlRespository.findById(idURL);
		if(!optUrlShorten.isPresent()) {
			URLShortener urlShortener = new URLShortener();
			urlShortener.setId(idURL);
			urlShortener.setOriginalURL(url);
			urlRespository.save(urlShortener);
		}
		
		return Base62.toBase62(idURL);
	}


	@Override
	public String getOriginalURL(String urlShorten) throws UnknownHostException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(urlShorten);
		Long idURL = Base62.convertId(sb.toString());
		Optional<URLShortener> optUrlShorten = urlRespository.findById(idURL);
		if(optUrlShorten.isPresent())
		return optUrlShorten.get().getOriginalURL();
		
		return null;
	}
	
	
}

package ha.nguyen.shorturls.repositories.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class URLShortener {
	@Id
	@Column(name="id")
	private Long id;
	@Column(name = "onCreate")
	private Date onCreate = new Date();
	@Column(name = "originalURL")
	private String originalURL;
	public URLShortener(Long id, Date onCreate, String originalURL) {
		super();
		this.id = id;
		this.onCreate = onCreate;
		this.originalURL = originalURL;
	}
	public URLShortener() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getOnCreate() {
		return onCreate;
	}
	public void setOnCreate(Date onCreate) {
		this.onCreate = onCreate;
	}
	public String getOriginalURL() {
		return originalURL;
	}
	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}
	
	
}

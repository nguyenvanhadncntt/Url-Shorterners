package ha.nguyen.shorturls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ha.nguyen.shorturls.repositories.entities.URLShortener;

@Repository
public interface URLRepository extends JpaRepository<URLShortener, Long> {
	@Query(nativeQuery = true, value = "SELECT Max(ID) from URLSHORTENER")
	Long getNumberGenerateNext();
}

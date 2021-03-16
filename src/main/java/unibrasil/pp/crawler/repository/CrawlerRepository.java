package unibrasil.pp.crawler.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import unibrasil.pp.crawler.model.Crawler;

public interface CrawlerRepository  extends PagingAndSortingRepository<Crawler, Long> {
}

package unibrasil.pp.crawler.endpoint.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import unibrasil.pp.crawler.model.Crawler;
import unibrasil.pp.crawler.repository.CrawlerRepository;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CrawlerService {
    private final CrawlerRepository crawlerRepository;

    public Iterable<Crawler> list (Pageable pageable){
        log.info("Listing all Crawlers");
        return crawlerRepository.findAll(pageable);
    }
}

package unibrasil.pp.crawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unibrasil.pp.crawler.model.WebCrawlerModel;

import java.util.List;

@Repository
public interface CrawlerRepository extends JpaRepository<WebCrawlerModel, Long> {
    List<WebCrawlerModel> findAll();
}

package unibrasil.pp.crawler.endpoint.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unibrasil.pp.crawler.model.WebCrawlerModel;
import unibrasil.pp.crawler.repository.CrawlerRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CrawlerService {
    private final CrawlerRepository crawlerRepository;
    private List<WebCrawlerModel> webCrawlerModelList;


    public void addData(WebCrawlerModel webCrawlerModel) {
        webCrawlerModelList.add(webCrawlerModel);
    }
}

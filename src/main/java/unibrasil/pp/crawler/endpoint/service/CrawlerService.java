package unibrasil.pp.crawler.endpoint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unibrasil.pp.crawler.model.WebCrawlerModel;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CrawlerService {
    private List<WebCrawlerModel> webCrawlerModelList;


    public void addData(WebCrawlerModel webCrawlerModel) {
        webCrawlerModelList.add(webCrawlerModel);
    }
}

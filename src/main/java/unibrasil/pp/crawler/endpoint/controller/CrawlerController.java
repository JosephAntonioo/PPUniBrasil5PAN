package unibrasil.pp.crawler.endpoint.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unibrasil.pp.crawler.endpoint.service.CrawlerService;
import unibrasil.pp.crawler.model.Crawler;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("v1/admim/crawler")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CrawlerController {
    private final CrawlerService crawlerService;

    @GetMapping(produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Iterable<Crawler>> list(Pageable pageadble){
        return new ResponseEntity<>(crawlerService.list(pageadble), HttpStatus.OK);
    }
}

package unibrasil.pp.crawler.endpoint.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import unibrasil.pp.crawler.endpoint.WebCrawler.WebCrawler;
import unibrasil.pp.crawler.endpoint.service.CrawlerService;
import unibrasil.pp.crawler.model.WebCrawlerModel;
import unibrasil.pp.crawler.repository.CrawlerRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/admim/crawler")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CrawlerController {
    private final CrawlerService crawlerService;
    WebCrawler webCrawler;

    @Autowired
    CrawlerRepository crawlerRepository;

    /*@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)*/
    @RequestMapping(method = RequestMethod.POST, value="/save")
    @CrossOrigin
    public List<WebCrawlerModel> addData() throws IOException {
        Document doc = Jsoup.connect("https://brasil.io/covid19/PR/").timeout(6000).get();
        Elements tabela = doc.select("tbody");
        List<WebCrawlerModel> listCrawler = new ArrayList<>();
        //System.out.println(tabela.select("tr").size());
        for (Element e : tabela.select("tr")) {
            final WebCrawlerModel webCrawlerModel = new WebCrawlerModel();
            String data = e.select("td").attr("data-search");
            System.out.println(data);
            if(data != null) {
                webCrawlerModel.setData(data);
            }

            String cidade = e.select("td:nth-child(2)").text();
            System.out.println(cidade);
            webCrawlerModel.setCidade(cidade);

            String confirmado = e.select("td:nth-child(3)").text();
            System.out.println(confirmado);
            webCrawlerModel.setConfirmado(confirmado);

            String confirmado100k = e.select("td:nth-child(4)").text();
            System.out.println(confirmado100k);
            webCrawlerModel.setConfirmado100k(confirmado100k);

            String obito = e.select("td:nth-child(5)").text();
            System.out.println(obito);
            webCrawlerModel.setObito(obito);

            String letalidade = e.select("td:nth-child(6)").text();
            System.out.println(letalidade);
            webCrawlerModel.setLetalitade(letalidade);

            String obito100k = e.select("td:nth-child(7)").text();
            System.out.println(obito100k);
            webCrawlerModel.setObito100k(obito100k);
            var t = crawlerRepository.save(webCrawlerModel);
            listCrawler.add(webCrawlerModel);
        }
        return listCrawler;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listAll")
    public List<WebCrawlerModel> listAll(){
        return crawlerRepository.findAll();
    }
}


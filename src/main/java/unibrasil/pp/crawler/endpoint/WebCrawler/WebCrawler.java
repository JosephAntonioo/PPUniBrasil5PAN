package unibrasil.pp.crawler.endpoint.WebCrawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import unibrasil.pp.crawler.model.WebCrawlerModel;
import unibrasil.pp.crawler.repository.CrawlerRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebCrawler {
    @Autowired
    CrawlerRepository crawlerRepository;
    public List<WebCrawlerModel> getWebCrawler() throws IOException {

        Document doc = Jsoup.connect("https://brasil.io/covid19/PR/").timeout(6000).get();
        Elements tabela = doc.select("tbody");
        List<WebCrawlerModel> listCrawler = new ArrayList<>();
        //System.out.println(tabela.select("tr").size());
        for (Element e : tabela.select("tr")) {
            final WebCrawlerModel webCrawlerModel = null;
            String data = e.select("td").attr("data-search");
            System.out.println(data);
            webCrawlerModel.setData(data);

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
            listCrawler.add(webCrawlerModel);
        }
        return listCrawler;
    }
}
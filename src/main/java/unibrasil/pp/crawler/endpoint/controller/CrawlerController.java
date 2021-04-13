package unibrasil.pp.crawler.endpoint.controller;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import unibrasil.pp.crawler.model.WebCrawlerModel;
import unibrasil.pp.crawler.repository.CrawlerRepository;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("v1/admim/crawler")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CrawlerController {
    @Autowired
    CrawlerRepository crawlerRepository;

    /*@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)*/
    @RequestMapping(method = RequestMethod.POST, value="/save")
<<<<<<< HEAD
    @CrossOrigin
    public List<WebCrawlerModel> addData() throws IOException {
=======
    public List<WebCrawlerModel> addData() throws IOException, InterruptedException {
>>>>>>> e67d828bed3cfbe9dd15d42e8a046baf2a785f77
        Document doc = Jsoup.connect("https://brasil.io/covid19/PR/").timeout(6000).get();
        Elements tabela = doc.select("tbody");
        List<WebCrawlerModel> listCrawler = new ArrayList<>();
				//System.out.println(tabela.select("tr").size());
				int repeticoes = 5;
				int horas = 1;
				for(int i = 0; i < repeticoes;i++){
					SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-YYYY 'as' HH:mm:ss z");
					Date date = new Date(System.currentTimeMillis());
					System.out.println("Repetição numero " + i + " de " + (repeticoes+1) + " começando no dia " + formatter.format(date));
					for (Element e : tabela.select("tr")) {
            final WebCrawlerModel webCrawlerModel = new WebCrawlerModel();
            String data = e.select("td").attr("data-search");
            //System.out.println(data);
            webCrawlerModel.setData(data);

            String cidade = e.select("td:nth-child(2)").text();
            // System.out.println(cidade);
            webCrawlerModel.setCidade(cidade);

            String confirmado = e.select("td:nth-child(3)").text();
            // System.out.println(confirmado);
            webCrawlerModel.setConfirmado(confirmado);

            String confirmado100k = e.select("td:nth-child(4)").text();
            // System.out.println(confirmado100k);
            webCrawlerModel.setConfirmado100k(confirmado100k);

            String obito = e.select("td:nth-child(5)").text();
            // System.out.println(obito);
            webCrawlerModel.setObito(obito);

            String letalidade = e.select("td:nth-child(6)").text();
            // System.out.println(letalidade);
            webCrawlerModel.setLetalitade(letalidade);

            String obito100k = e.select("td:nth-child(7)").text();
            // System.out.println(obito100k);
            webCrawlerModel.setObito100k(obito100k);

						crawlerRepository.save(webCrawlerModel);
            listCrawler.add(webCrawlerModel);
        }
				date = new Date(System.currentTimeMillis());
				System.out.println("Repetição numero " + i + " de " + (repeticoes+1) + ". Finalizada no dia " + formatter.format(date));
				date = new Date(System.currentTimeMillis());
				System.out.println("Repetição numero " + i + " de " + (repeticoes+1) + ". A próxima atualização é em " + horas + " horas." + formatter.format(date));
				TimeUnit.HOURS.sleep(horas);
			}
			SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-YYYY 'as' HH:mm:ss z");
			Date date = new Date(System.currentTimeMillis());
			System.out.println("Finalizado no dia " + formatter.format(date));

        return listCrawler;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listAll")
    public List<WebCrawlerModel> listAll(){
        return crawlerRepository.findAll();
    }
}


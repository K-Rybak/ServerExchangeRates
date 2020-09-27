package exchangerates.rate;

import exchangerates.domain.Rate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

// Использую библотеку jsoup для парсинга страницы
public class RateUSD {
    public Document document;

    public RateUSD() {
        connect();
    }

    public void connect() {
        try {
            document = Jsoup.connect("https://ifin.kz/nbrk/USD").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNameRate() {
        Elements elements = document.getElementsByClass("currency-name");
        return elements.text();
    }

    public String getValueRate() {
        Elements elements = document.getElementsByClass("currency-rate-big");
        return elements.text();
    }

    public Rate getRate() {
        return new Rate(getNameRate(), getValueRate());
    }
}


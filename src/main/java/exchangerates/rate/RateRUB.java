package exchangerates.rate;

import org.jsoup.Jsoup;

import java.io.IOException;

public class RateRUB extends RateUSD {
    @Override
    public void connect() {
        try {
            document = Jsoup.connect("https://ifin.kz/nbrk/RUB").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

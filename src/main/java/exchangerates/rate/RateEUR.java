package exchangerates.rate;

import org.jsoup.Jsoup;

import java.io.IOException;

public class RateEUR extends RateUSD {
    @Override
    public void connect() {
        try {
            document = Jsoup.connect("https://ifin.kz/nbrk/EUR").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

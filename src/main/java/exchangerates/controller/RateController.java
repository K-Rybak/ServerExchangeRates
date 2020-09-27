package exchangerates.controller;

import exchangerates.domain.Rate;
import exchangerates.rate.RateEUR;
import exchangerates.rate.RateRUB;
import exchangerates.rate.RateUSD;
import exchangerates.repos.RateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rates")
public class RateController {
    private RateUSD usd = new RateUSD();
    private RateEUR eur = new RateEUR();
    private RateRUB rub = new RateRUB();

    @Autowired
    private RateRepo rateRepo;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Rate> getAllRates() {
        return rateRepo.findTop3ByOrderByIdDesc();
    }

    @PostMapping
    @Scheduled(fixedRate = 600000)
    public void create() {
        Rate rateUsd = usd.getRate();
        rateRepo.save(rateUsd);
        Rate rateEur = eur.getRate();
        rateRepo.save(rateEur);
        Rate rateRub = rub.getRate();
        rateRepo.save(rateRub);
    }

}

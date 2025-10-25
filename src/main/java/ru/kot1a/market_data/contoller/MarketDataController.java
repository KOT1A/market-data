package ru.kot1a.market_data.contoller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.market_data.contoller.dto.CandleRequest;
import ru.kot1a.market_data.repository.entity.Security;
import ru.kot1a.market_data.service.CandleService;
import ru.kot1a.market_data.client.dto.Candles;
import ru.kot1a.market_data.service.SecurityService;

import java.util.List;

@RestController
@RequestMapping("v1/market_data")
@Slf4j
@RequiredArgsConstructor
public class MarketDataController {

    private final CandleService candleService;
    private final SecurityService securityService;

    @PostMapping("/candles")
    public Candles getCandles(@RequestBody CandleRequest candleRequest){
        log.debug("Тело запроса POST v1/market/data/candles для получения свечей указанного инструмента за" +
                "определённый период: {}", candleRequest);
        return candleService.getCandles(candleRequest);
    }

    @GetMapping("/securities")
    public List<Security> getSecurities(){
        return securityService.getSecurities();
    }
}

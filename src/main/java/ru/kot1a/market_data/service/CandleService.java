package ru.kot1a.market_data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kot1a.market_data.client.MoexClient;
import ru.kot1a.market_data.client.dto.Candles;
import ru.kot1a.market_data.contoller.dto.CandleRequest;

@Service
@RequiredArgsConstructor
public class CandleService {

    private final MoexClient moexClient;

    public Candles getCandles(CandleRequest candleRequest){
        return moexClient.getCandles(
                candleRequest.getEngine(),
                candleRequest.getMarket(),
                candleRequest.getBoard(),
                candleRequest.getSecurity(),
                candleRequest.getFrom(),
                candleRequest.getInterval());
    }
}

package ru.kot1a.market_data.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.market_data.client.MoexClient;
import ru.kot1a.market_data.client.dto.DataFromMoex;

import java.sql.Timestamp;
import java.time.Instant;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/market/data")
public class MarketDataController {

    private final MoexClient moexClient;

    @GetMapping
    public DataFromMoex getMarketData() {
        return moexClient.getCandlesWithParameters(
                "stock",
                "bonds",
                "TQOB",
                "SU26233RMFS5",
                Timestamp.from(Instant.now().minusSeconds(10800)),
                1);
    }

}

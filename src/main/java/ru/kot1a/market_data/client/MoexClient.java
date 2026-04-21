package ru.kot1a.market_data.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kot1a.market_data.client.dto.Candles;
import ru.kot1a.market_data.client.dto.Securities;

import java.sql.Timestamp;

@FeignClient(name = "moex-client", url = "${integrations.moex.url}")
public interface MoexClient {

    /**
     * Получает исторические данные указанного финансового инструмента за заданный период в виде японских свечей
     * (open, high, low, close, value, volume).
     *
     * @param engine   движок (рыночная площадка)
     * @param market   рынок внутри движка
     * @param board    режим торгов
     * @param security тикер ценной бумаги
     * @param interval временной интервал свечи:<br>
     *                 1 - 1 минута<br>
     *                 10 - 10 минут<br>
     *                 60 - 1 час<br>
     *                 24 - 1 день<br>
     *                 7 - 1 неделя<br>
     *                 31 - 1 месяц<br>
     *                 4 - 1 кварта
     * @return свечную историю (candles) для указанного финансового инструмента за заданный период
     */
    @GetMapping("/iss/engines/{engine}/markets/{market}/boards/{board}/securities/{security}/candles.json")
    Candles getCandles(@PathVariable String engine,
                       @PathVariable String market,
                       @PathVariable String board,
                       @PathVariable String security,
                       @RequestParam(required = false) Timestamp from,
                       @RequestParam(required = false) int interval);

    /**
     * @param start номер строки (отсчет с нуля), с которой следует начать порцию возвращаемых данных (см. рук-во
     *              разработчика). Получение ответа без данных означает, что указанное значение превышает число строк,
     *              возвращаемых запросом.
     * @return список бумаг торгуемых на московской бирже.
     */
    @GetMapping("/iss/securities.json")
    Securities getSecurities(@RequestParam(required = false) int start,
                             @RequestParam(required = false) int limit);
}


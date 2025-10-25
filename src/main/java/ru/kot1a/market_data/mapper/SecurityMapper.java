package ru.kot1a.market_data.mapper;

import org.springframework.stereotype.Component;
import ru.kot1a.market_data.repository.entity.Security;

import java.util.ArrayList;
import java.util.List;

import static ru.kot1a.market_data.MarketDataConst.TRUE_STRING;

@Component
public class SecurityMapper {

    public List<Security> map(List<List<String>> data) {
        List<Security> securities = new ArrayList<>();
        for (List<String> listValues : data) {
            Security security = Security.builder()
                    .ticker(listValues.get(0))
                    .shortname(listValues.get(1))
                    .regnumber(listValues.get(2))
                    .name(listValues.get(3))
                    .isin(listValues.get(4))
                    .isTraded(TRUE_STRING.equals(listValues.get(5)))
                    .emitentId(listValues.get(6))
                    .emitentTitle(listValues.get(7))
                    .emitentInn(listValues.get(8))
                    .emitentOkpo(listValues.get(9))
                    .board(listValues.get(12))
                    .market(listValues.get(11).split("_")[0])
                    .engine(listValues.get(11).split("_")[1])
                    .build();
            securities.add(security);
        }
        return securities;
    }
}
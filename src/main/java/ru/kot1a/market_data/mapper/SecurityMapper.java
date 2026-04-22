package ru.kot1a.market_data.mapper;

import org.springframework.stereotype.Component;
import ru.kot1a.market_data.entity.Security;

import java.util.ArrayList;
import java.util.List;

@Component
public class SecurityMapper {

    private static final String TRUE_STRING = "1";

    public List<Security> map(List<List<String>> data) {
        List<Security> securities = new ArrayList<>();
        for (List<String> listValues : data) {
            Security security = Security.builder()
                    .secId(listValues.get(0))
                    .shortname(listValues.get(1))
                    .regNumber(listValues.get(2))
                    .name(listValues.get(3))
                    .isin(listValues.get(4))
                    .isTraded(TRUE_STRING.equals(listValues.get(5)))
                    .emitentId(listValues.get(6))
                    .emitentTitle(listValues.get(7))
                    .emitentInn(listValues.get(8))
                    .emitentOkpo(listValues.get(9))
                    .type(listValues.get(10))
                    .group(listValues.get(11))
                    .primaryBoardId(listValues.get(12))
                    .marketPriceBoardId(listValues.get(13))
                    .build();
            securities.add(security);
        }
        return securities;
    }
}
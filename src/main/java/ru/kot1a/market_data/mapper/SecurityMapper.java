package ru.kot1a.market_data.mapper;

import org.springframework.stereotype.Component;
import ru.kot1a.market_data.repository.entity.Security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.kot1a.market_data.MarketDataConst.TRUE_STRING;

@Component
public class SecurityMapper {

    public List<Security> map(List<List<String>> data) {
        if (data == null || data.isEmpty()) {
            return Collections.emptyList();
        }
        List<Security> securities = new ArrayList<>();
        for (List<String> listValues : data) {
            String group = getValue(listValues, 11);
            String[] groupParts = splitGroup(group);
            Security security = Security.builder()
                    .ticker(getValue(listValues, 0))
                    .shortname(getValue(listValues, 1))
                    .regnumber(getValue(listValues, 2))
                    .name(getValue(listValues, 3))
                    .isin(getValue(listValues, 4))
                    .isTraded(TRUE_STRING.equals(getValue(listValues, 5)))
                    .emitentId(getValue(listValues, 6))
                    .emitentTitle(getValue(listValues, 7))
                    .emitentInn(getValue(listValues, 8))
                    .emitentOkpo(getValue(listValues, 9))
                    .board(getValue(listValues, 12))
                    .market(groupParts[0])
                    .engine(groupParts[1])
                    .build();
            securities.add(security);
        }
        return securities;
    }

    private String getValue(List<String> values, int index) {
        if (values == null || index < 0 || index >= values.size()) {
            return null;
        }
        return values.get(index);
    }

    private String[] splitGroup(String group) {
        if (group == null || group.isBlank()) {
            return new String[]{null, null};
        }
        String[] parts = group.split("_", 2);
        String market = parts.length > 0 ? parts[0] : null;
        String engine = parts.length > 1 ? parts[1] : null;
        return new String[]{market, engine};
    }
}
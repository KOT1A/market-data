package ru.kot1a.market_data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kot1a.market_data.client.MoexClient;
import ru.kot1a.market_data.client.dto.DataFromMoex;
import ru.kot1a.market_data.client.dto.Securities;
import ru.kot1a.market_data.mapper.SecurityMapper;
import ru.kot1a.market_data.repository.entity.Security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SecurityService {

    private static final int PAGE_LIMIT = 100;

    private final MoexClient moexClient;
    private final SecurityMapper securityMapper;

    public List<Security> getSecurities() {
        List<Security> securities = new ArrayList<>();
        int start = 0;

        while (true) {
            Securities response = moexClient.getSecurities(start, PAGE_LIMIT);
            List<List<String>> pageData = extractData(response);
            if (pageData.isEmpty()) {
                break;
            }

            securities.addAll(securityMapper.map(pageData));
            if (pageData.size() < PAGE_LIMIT) {
                break;
            }
            start += PAGE_LIMIT;
        }

        return securities;
    }

    private List<List<String>> extractData(Securities response) {
        if (response == null) {
            return Collections.emptyList();
        }
        DataFromMoex securities = response.getSecurities();
        if (securities == null || securities.getData() == null) {
            return Collections.emptyList();
        }
        return securities.getData();
    }
}

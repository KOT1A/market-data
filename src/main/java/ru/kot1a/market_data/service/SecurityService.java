package ru.kot1a.market_data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kot1a.market_data.client.MoexClient;
import ru.kot1a.market_data.client.dto.Securities;
import ru.kot1a.market_data.mapper.SecurityMapper;
import ru.kot1a.market_data.repository.entity.Security;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecurityService {

    private final MoexClient moexClient;
    private final SecurityMapper securityMapper;

    public List<Security> getSecurities(){
        Securities securitiesData = moexClient.getSecurities(0, 100);
        List<Security> securities = securityMapper.map(securitiesData.getSecurities().getData());
        return securities;
    }
}

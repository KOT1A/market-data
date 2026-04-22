package ru.kot1a.market_data.client.moex.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DataFromMoex {
    @JsonIgnore
    private Object metadata;
    @JsonIgnore
    private List<String> columns;
    private List<List<String>> data;
}
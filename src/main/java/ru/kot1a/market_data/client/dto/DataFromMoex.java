package ru.kot1a.market_data.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DataFromMoex {
    @JsonIgnore
    Object metadata;
    @JsonIgnore
    List<String> columns;
    List<List<String>> data;
}
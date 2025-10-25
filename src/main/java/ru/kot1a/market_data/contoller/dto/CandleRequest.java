package ru.kot1a.market_data.contoller.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CandleRequest {
    private String engine;
    private String market;
    private String board;
    private String security;
    private Timestamp from;
    private Integer interval;
}

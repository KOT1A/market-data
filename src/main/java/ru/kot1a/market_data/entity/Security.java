package ru.kot1a.market_data.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Security {
    /**
     * Биржевой код инструмента в ISS. Не всегда «тикер» в бытовом смысле, а именно идентификатор инструмента в каталоге
     * MOEX.
     */
    private String secId;
    /**
     * Короткое имя инструмента, удобное для интерфейсов и списков.
     */
    private String shortname;
    /**
     * Регистрационный номер. Для акций/облигаций РФ часто заполнен, для фьючерсов и части иностранных инструментов -
     * нет.
     */
    private String regNumber;
    /**
     * Полное имя.
     */
    private String name;
    /**
     * Международный идентификатор. Для акций обычно есть, для фьючерсов/опционов обычно нет.
     */
    private String isin;
    /**
     * Признак того, что инструмент торгуется. Но тут важно не переоценивать поле: это не «сейчас идёт сделка», а скорее
     * признак торговой доступности инструмента в системе/листинге. То есть это поле из справочника, а не рыночное
     * состояние в реальном времени.
     */
    private Boolean isTraded;
    /**
     * Данные эмитента. Они логично есть у эмиссионных инструментов вроде акций и облигаций.
     */
    private String emitentId;
    private String emitentTitle;
    private String emitentInn;
    private String emitentOkpo;
    /**
     * Тип инструмента. В выдаче встречаются, например, common_share, futures, option, currency, stock_index_ie и
     * stock_index_if.
     */
    private String type;
    /**
     * Группа инструментов, более крупная бизнес-категория. Например, в ответе есть stock_shares, futures_forts,
     * futures_options, currency_selt, stock_index.
     */
    private String group;
    /**
     * Основной режим торгов для инструмента. На MOEX один и тот же инструмент может быть связан с несколькими режимами
     * торгов, но биржа выбирает “главный” board, который обычно используют как дефолтный режим для многих запросов и
     * представлений.
     */
    private String primaryBoardId;
    /**
     * board, который используется для рыночной цены / market price, если он определён
     */
    private String marketPriceBoardId;
}
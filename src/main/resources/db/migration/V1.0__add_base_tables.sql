--Создаем таблицу для хранения тикеров
create table ticker (
    ticker_id       integer not null,
    ticker_engine   text    not null,
    ticker_market   text    not null,
    ticker_board    text    not null,
    ticker_ticker   text    not null,
    ticker_lot_size integer not null    default 1,
    constraint pk_ticker_id primary key (ticker_id),
    constraint ticker_uniq unique (ticker_engine, ticker_market, ticker_board, ticker_ticker)
);

--Создаем таблицу для хранения свечей
create table candle (
    candle_uuid     uuid                        not null,
    ticker_id       integer                     not null,
    candle_interval smallint                    not null,
    candle_open     text                        not null,
    candle_close    text                        not null,
    candle_high     text                        not null,
    candle_low      text                        not null,
    candle_value    text                        not null,
    candle_volume   text                        not null,
    candle_begin    timestamp with time zone    not null,
    candle_end      timestamp with time zone    not null,
    constraint pk_candle_uuid primary key (candle_uuid)
);
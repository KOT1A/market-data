--Создаем таблицу для хранения тикеров
create table security (
    security_id               integer not null,
    security_ticker           text    not null,
    security_board            text    not null,
    security_market           text    not null,
    security_engine           text    not null,
    security_shortname        text    not null,
    security_name             text    not null,
    security_regnumber        text    not null,
    security_isin             text    not null,
    security_is_traded        boolean not null,
    security_emitent_id       text    not null,
    security_emitent_title    text    not null,
    security_emitent_inn      text    not null,
    security_emitent_okpo     text    not null,
    security_lot_size integer not null    default 1,
    constraint pk_security_id primary key (security_id),
    constraint security_uniq unique (security_engine, security_market, security_board, security_ticker)
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
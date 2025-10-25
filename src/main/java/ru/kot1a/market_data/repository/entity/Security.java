package ru.kot1a.market_data.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "security")
@Data
@Builder
public class Security {
    @Id
    private String securityId; //*generate*
    private String ticker; //secid
    private String board; //primary_boardid
    private String market; //group 1 значение
    private String engine; //group 2 значение
    private String shortname;
    private String name;
    private String regnumber;
    private String isin;
    private Boolean isTraded;
    private String emitentId;
    private String emitentTitle;
    private String emitentInn;
    private String emitentOkpo;
    private Integer lotSize;
}
package org.galatea.starter.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class IexHistoricalPrices {

    private BigDecimal close;

    private BigDecimal high;

    private BigDecimal low;

    private BigDecimal open;

    private String symbol;

    private long volume;

    private String date;
}

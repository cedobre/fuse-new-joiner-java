package org.galatea.starter.service;

import java.util.Collections;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.galatea.starter.domain.IexHistoricalPrices;
import org.galatea.starter.domain.IexLastTradedPrice;
import org.galatea.starter.domain.IexSymbol;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * A layer for transformation, aggregation, and business required when retrieving data from IEX.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class IexService {

  @NonNull
  private IexClient iexClient;


  /**
   * Get all stock symbols from IEX.
   *
   * @return a list of all Stock Symbols from IEX.
   */
  public List<IexSymbol> getAllSymbols(final String token) {
    return iexClient.getAllSymbols(token);
  }



  public List<IexLastTradedPrice> getLastTradedPriceForSymbols(final List<String> symbols, final String token) {
    if (CollectionUtils.isEmpty(symbols)) {
      return Collections.emptyList();
    } else {
      return iexClient.getLastTradedPriceForSymbols(symbols.toArray(new String[0]), token);
    }
  }



  /**
   * Get historical prices for each Symbol and range  passed in.
   *
   * @param symbol symbol to get a last historical price for.
   * @param range range to specify the range required
   * @return a list of last traded price objects for each Symbol that is passed in.
   */
  public List<IexHistoricalPrices> getHistoricalPrices(final String symbol, final String range, final String token) {

      return iexClient.getHistoricalPrices(symbol, range, token);

    }
  }

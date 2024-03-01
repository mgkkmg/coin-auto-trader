package org.kmg.coinautotrader.application.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AccountsResponse(
	String currency,
	String balance,
	String locked,
	@JsonProperty("avg_buy_price")
	String avgBuyPrice,
	@JsonProperty("avg_buy_price_modified")
	Boolean avgBuyPriceModified,
	@JsonProperty("unit_currency")
	String unitCurrency
) {
}

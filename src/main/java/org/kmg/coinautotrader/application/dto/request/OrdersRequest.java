package org.kmg.coinautotrader.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrdersRequest(
	String market,
	String side,
	Long volume,
	Long price,
	@JsonProperty("ord_type")
	String ordType
) {
}

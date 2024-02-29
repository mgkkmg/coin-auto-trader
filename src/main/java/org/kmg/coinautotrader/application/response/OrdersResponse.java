package org.kmg.coinautotrader.application.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrdersResponse(
	String uuid,
	String side,
	@JsonProperty("ord_type")
	String ordType,
	Long price,
	String state,
	String market,
	@JsonProperty("created_at")
	String createdAt,
	Long volume,
	@JsonProperty("remaining_volume")
	Long remainingVolume,
	@JsonProperty("reserved_fee")
	Long reservedFee,
	@JsonProperty("remaining_fee")
	Long remainingFee,
	@JsonProperty("paid_fee")
	Long paidFee,
	Long locked,
	@JsonProperty("executed_volume")
	Long executedVolume,
	@JsonProperty("trades_count")
	Integer tradesCount
) {
}

package org.kmg.coinautotrader.application.dto.request;

import org.kmg.coinautotrader.exception.CoinAutoTraderException;
import org.kmg.coinautotrader.exception.ErrorCode;
import org.kmg.coinautotrader.util.NumberUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrdersRequest(
	String market,
	String side,
	String volume,
	String price,
	@JsonProperty("ord_type")
	String ordType
) {
	public OrdersRequest {
		validateParameter(market, "market");
		validateParameter(side, "side");
		validateParameter(ordType, "ordType");
		validateNumberStringParameter(volume, "volume");
		validateNumberStringParameter(price, "price");
	}

	private static void validateParameter(String field, String fieldName) {
		if (field == null || field.trim().isEmpty()) {
			throw new CoinAutoTraderException(ErrorCode.REQUIRED_NOT_FOUND, fieldName);
		}
	}

	private static void validateNumberStringParameter(String field, String fieldName) {
		if (!NumberUtils.isNumeric(field)) {
			throw new CoinAutoTraderException(ErrorCode.REQUIRED_NOT_FOUND, fieldName);
		}
		validateParameter(field, fieldName);
	}
}

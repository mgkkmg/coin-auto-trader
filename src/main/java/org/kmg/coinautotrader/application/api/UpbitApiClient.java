package org.kmg.coinautotrader.application.api;

import java.util.List;

import org.kmg.coinautotrader.application.request.OrdersRequest;
import org.kmg.coinautotrader.application.response.AccountsResponse;
import org.kmg.coinautotrader.application.response.OrdersResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

public interface UpbitApiClient {
	@GetExchange("https://api.upbit.com/v1/accounts")
	List<AccountsResponse> getAccounts(
		@RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
		@RequestHeader(HttpHeaders.AUTHORIZATION) String authenticationToken
	);

	@PostExchange("https://api.upbit.com/v1/orders")
	List<OrdersResponse> orders(
		@RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
		@RequestHeader(HttpHeaders.AUTHORIZATION) String authenticationToken,
		@RequestBody OrdersRequest ordersRequest
	);
}

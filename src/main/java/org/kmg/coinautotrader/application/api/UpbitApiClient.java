package org.kmg.coinautotrader.application.api;

import java.util.List;

import org.kmg.coinautotrader.application.response.AccountResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;

public interface UpbitApiClient {
	@GetExchange("https://api.upbit.com/v1/accounts")
	List<AccountResponse> getAccounts(
		@RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
		@RequestHeader(HttpHeaders.AUTHORIZATION) String authenticationToken
	);
}

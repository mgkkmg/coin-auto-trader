package org.kmg.coinautotrader.application.service;

import java.util.List;

import org.kmg.coinautotrader.application.api.UpbitApiClient;
import org.kmg.coinautotrader.application.dto.response.AccountsResponse;
import org.kmg.coinautotrader.auth.JwtTokenProvider;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountsService {
	private final UpbitApiClient upbitApiClient;
	private final JwtTokenProvider jwtTokenProvider;

	public List<AccountsResponse> getAccounts() {
		return upbitApiClient.getAccounts(MediaType.APPLICATION_JSON_VALUE, jwtTokenProvider.createToken());
	}
}

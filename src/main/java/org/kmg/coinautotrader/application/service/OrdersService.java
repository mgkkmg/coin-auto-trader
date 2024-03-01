package org.kmg.coinautotrader.application.service;

import java.util.List;

import org.kmg.coinautotrader.application.api.UpbitApiClient;
import org.kmg.coinautotrader.application.dto.response.OrdersResponse;
import org.kmg.coinautotrader.auth.JwtTokenProvider;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrdersService {
	private final UpbitApiClient upbitApiClient;
	private final JwtTokenProvider jwtTokenProvider;

	public List<OrdersResponse> orders() {

		return upbitApiClient.orders(MediaType.APPLICATION_JSON_VALUE, jwtTokenProvider.createToken(), null);
	}
}

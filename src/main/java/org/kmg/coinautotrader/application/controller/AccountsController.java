package org.kmg.coinautotrader.application.controller;

import java.util.List;

import org.kmg.coinautotrader.application.dto.response.AccountsResponse;
import org.kmg.coinautotrader.application.service.AccountsService;
import org.kmg.coinautotrader.common.response.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AccountsController {
	private final AccountsService accountsService;

	@GetMapping("/api/v1/accounts")
	public CommonResponse<List<AccountsResponse>> getAccounts() {
		return CommonResponse.success(accountsService.getAccounts());
	}
}

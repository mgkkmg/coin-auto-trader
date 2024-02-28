package org.kmg.coinautotrader.application.controller;

import java.util.List;

import org.kmg.coinautotrader.application.response.AccountResponse;
import org.kmg.coinautotrader.application.service.AccountService;
import org.kmg.coinautotrader.common.response.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AccountController {
	private final AccountService accountService;

	@GetMapping("/api/v1/accounts")
	public CommonResponse<List<AccountResponse>> getAccounts() {
		return CommonResponse.success(accountService.getAccounts());
	}
}

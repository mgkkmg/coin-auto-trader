package org.kmg.coinautotrader.auth;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtTokenProvider {
	@Value("${upbit.access-key}")
	private String accessKey;

	@Value("${upbit.secret-key}")
	private String secretKey;

	public String createToken() {
		final Algorithm algorithm = Algorithm.HMAC256(secretKey);

		return "Bearer " + JWT.create()
			.withClaim("access_key", accessKey)
			.withClaim("nonce", UUID.randomUUID().toString())
			.sign(algorithm);
	}
}

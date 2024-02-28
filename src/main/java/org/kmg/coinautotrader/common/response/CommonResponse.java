package org.kmg.coinautotrader.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommonResponse<T> {

	private final String resultCode;
	private final T result;

	public static CommonResponse<Void> error(String errorCode) {
		return new CommonResponse<>(errorCode, null);
	}

	public static CommonResponse<Void> success() {
		return new CommonResponse<>("SUCCESS", null);
	}

	public static <T> CommonResponse<T> success(T result) {
		return new CommonResponse<>("SUCCESS", result);
	}

	public String toStream() {
		if (result == null) {
			return "{" +
				"\"resultCode\":" + "\"" + resultCode + "\"," +
				"\"result\":" + null + "}";
		}

		return "{" +
			"\"resultCode\":" + "\"" + resultCode + "\"," +
			"\"result\":" + "\"" + result + "\"" + "}";
	}
}

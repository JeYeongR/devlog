package com.devlog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devlog.domain.Token;
import com.devlog.domain.User;
import com.devlog.external.github.OauthUserResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserApplicationService {

	private final UserCommandService userCommandService;
	private final UserQueryService userQueryService;
	private final AuthService authService;
	private final TokenIssueService tokenIssueService;

	@Transactional
	public Token login(String code) {
		OauthUserResponse response = authService.getUserInfo(code);

		User user = userQueryService.findUser(response.socialProviderId())
			.orElseGet(() -> userCommandService.save(User.create(
				response.email(),
				response.nickname(),
				response.socialProviderId(),
				response.profileImageUrl()
			)));

		Token token = tokenIssueService.createTokens(user);

		user.updateToken(token);

		return token;
	}
}

package com.devlog.follow.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devlog.follow.domain.Follow;
import com.devlog.follow.repository.FollowRepository;
import com.devlog.user.domain.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class FollowQueryService {

	private final FollowRepository followRepository;

	public Optional<Follow> findFollowByFollowerAndFollowedUser(User follower, User followedUser) {
		return followRepository.findByFollowerAndFollowedUser(follower, followedUser);
	}
}

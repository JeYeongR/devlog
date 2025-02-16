package com.devlog.service;

import org.springframework.stereotype.Service;

import com.devlog.domain.User;
import com.devlog.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserCommandService {

	private final UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}
}

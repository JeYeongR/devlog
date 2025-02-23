package com.devlog.post.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.devlog.exception.ApiException;
import com.devlog.exception.ErrorType;
import com.devlog.post.domain.Post;
import com.devlog.post.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostQueryService {

	private final PostRepository postRepository;

	public Post findPostById(Long postId) {
		return postRepository.findById(postId)
			.orElseThrow(() -> new ApiException("포스트를 찾을 수 없습니다.", ErrorType.NOT_FOUND, HttpStatus.NOT_FOUND));
	}
}

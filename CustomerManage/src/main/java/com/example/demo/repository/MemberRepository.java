package com.example.demo.repository;

import com.example.demo.domain.List;
import com.example.demo.domain.Member;
import com.example.demo.domain.Optional;

public class MemberRepository {

		Member save( Member member);
		Optional<Member> findById(Long id);
		Optional<Member> findById(String name);
		List<Member> findAll();
		
		
		
}

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;

@Service
public class MemberService {
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	// 회원 가입 창
	
	public Long join(Member member) {
		
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
	}
	
	private void validateDuplicateMember(Member member) {
		// 같은 이름이 있는 중복 회원은 가입 불가
		//Optional<Member> result = memberRepository.findByName(member.getName());
		memberRepository.findByName(member.getName())
			.ifPresent( m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
			});
	}
	
	// 전체 회원 조회
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	public Optional<Member> findOne(Long memberId){
		return memberRepository.findById(memberId);
				
	}

}

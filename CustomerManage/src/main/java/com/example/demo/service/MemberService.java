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
	
	// ȸ�� ���� â
	
	public Long join(Member member) {
		
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
	}
	
	private void validateDuplicateMember(Member member) {
		// ���� �̸��� �ִ� �ߺ� ȸ���� ���� �Ұ�
		//Optional<Member> result = memberRepository.findByName(member.getName());
		memberRepository.findByName(member.getName())
			.ifPresent( m -> {
			throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
			});
	}
	
	// ��ü ȸ�� ��ȸ
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	public Optional<Member> findOne(Long memberId){
		return memberRepository.findById(memberId);
				
	}

}

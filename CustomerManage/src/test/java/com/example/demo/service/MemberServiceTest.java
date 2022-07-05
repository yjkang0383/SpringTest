package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
	
	MemberService memberservice ;
	MemoryMemberRepository memberRepository;
	
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberservice = new MemberService();
	}
	
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void join() { //회원가입
		//given
		Member member = new Member();
		member.setName("hello");
		
		//when
		Long saveId = memberservice.join(member);
		
		//then
		Member findMember = memberservice.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}
		
	
	@Test
	public void duplicatedMember() {
	
		Member mm1 = new Member();
		mm1.setName("spring");
		
		Member mm2 = new Member();
		mm2.setName("spring");

		
		//when
		memberservice.join(mm1);
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberservice.join(mm2));
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 최원입니다.");
		
		/*
		try {
			memberservice.join(mm2);
			fail();
		} catch (IllegalStateException e){
			assertThat(e.getMessage()).isEqualTo("이미 존재하는 최원입니다.");
		} 
		
		*/
	}
	
	@Test
	void FindMembers() {
		
	}

	@Test
	void FindOne() {
		
	}

}

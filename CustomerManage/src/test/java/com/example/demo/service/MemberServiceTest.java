package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Member;
import org.junit.jupiter.api.Test;

class MemberServiceTest {
	
	MemberService memberservice = new MemberService();
	
	@Test
	void Join() { //회원가입
		//given
		Member member = new Member();
		member.setName("hello");
		
		//when
		Long saveId = memberservice.join(member);
		
		//then
		Member findMember = memberservice.findOne(savceId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}
		
	@Test
	void FindMembers() {
		
	}

	@Test
	void FindOne() {
		
	}

}
